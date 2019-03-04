package com.cdgit.loan.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import com.ccb.openframework.util.FrameworkContext;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.CollectionUtils;

/**
 * bean对象工具类
 * 
 * @author 范钟艺
 * 
 */
public abstract class BeanUtil {
	private static final String OMIT_REG = "_";

	protected static final String DateFormat = "yyyyMMdd";
	protected static final String DTTMFormat = "yyyyMMddHHmmssSSS";
	protected static final String SDTTMFormat = "yyyyMMddHHmmss";

	protected final static Log log = LogFactory.getLog(BeanUtil.class);

	private static ConfigurableConversionService conversionService;

	static {
		conversionService = new DefaultConversionService();
		Converter<String, Date> sdConverter = new StringToDateConverter();
		Converter<Date, String> dsConverter = new DateToStringConverter();
		Converter<String, Timestamp> dtConverter = new StringToTimestampConverter();
		conversionService.addConverter(sdConverter);
		conversionService.addConverter(dsConverter);
		conversionService.addConverter(dtConverter);
	}

	protected static ConfigurableConversionService getConverter() {
		return conversionService;
	}

	/**
	 * 字符串转日期
	 * @author fanzhongyi.zh
	 *
	 */
	protected static class StringToDateConverter implements Converter<String, Date> {
		public Date convert(String source) {
			SimpleDateFormat sdfDt = new SimpleDateFormat(DateFormat);
			Date d = null;
			try {
				d = sdfDt.parse(source);
			} catch (ParseException e) {
				throw new IllegalArgumentException(String.format("类型转换失败，需要格式[" + DateFormat + "]，但输入是[%s]", source));
			}
			return d;
		}
	}

	/**
	 * 日期转字符串
	 * @author fanzhongyi.zh
	 *
	 */
	protected static class DateToStringConverter implements Converter<Date, String> {
		public String convert(Date source) {
			SimpleDateFormat sdfDt = new SimpleDateFormat(DateFormat);
			return sdfDt.format(source);
		}
	}

	/**
	 * 字符串转时间戳
	 * @author fanzhongyi.zh
	 *
	 */
	protected static class StringToTimestampConverter implements Converter<String, Timestamp> {
		public Timestamp convert(String source) {
			try {
				if (source.length() == DTTMFormat.length()) {
					SimpleDateFormat sdfDt = new SimpleDateFormat(DTTMFormat);
					return new Timestamp(sdfDt.parse(source).getTime());
				} else if (source.length() == SDTTMFormat.length()) {
					SimpleDateFormat sdfDt = new SimpleDateFormat(SDTTMFormat);
					return new Timestamp(sdfDt.parse(source).getTime());
				} else {
					throw new IllegalArgumentException(String.format("类型转换失败，需要格式[" + DTTMFormat + "]或者[" + SDTTMFormat + "]，但输入是[%s]", source));
				}
			} catch (ParseException e) {
				throw new IllegalArgumentException(String.format("类型转换失败，需要格式[" + DTTMFormat + "]或者[" + SDTTMFormat + "]，但输入是[%s]", source));
			}
		}
	}

	/**
	 * 方法说明：拷贝对象中的属性 MO --> DO DO --> MO
	 *    默认对null字段也进行赋值
	 * @param source
	 * @param target
	 */
	public static void copyBeanProperties(Object source, Object target) {
		copyBeanProperties(source, target, false);
	}
	

	/**
	 * 方法说明：拷贝对象中的属性 MO --> DO DO --> MO
	 * @param source
	 * @param target
	 * @param ignoreNull 是否忽略掉源对象中的null字段
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void copyBeanProperties(Object source, Object target, Boolean ignoreNull) {
		// 如果转换对象为空直接返回
		if (source == null) {
			return;
		}
		Class sourceClz = source.getClass();
		Class targetClz = target.getClass();
		// 得到源对象Class所表征的类的所有属性(包括私有属性)
		PropertyDescriptor[] srcPropertys = BeanUtils.getPropertyDescriptors(sourceClz);
		Object srcValue = null;

		log.debug("Bean转化开始："+sourceClz.getName()+"-->"+targetClz.getName());
		for (PropertyDescriptor srcProperty : srcPropertys) {
			try {
				PropertyDescriptor desProperty = new PropertyDescriptor(srcProperty.getName(), targetClz);
				// 由方法的名字得到get和set方法的Method对象
				Method setMethod = desProperty.getWriteMethod();
				Method getMethod = srcProperty.getReadMethod();
				if (getMethod == null || setMethod == null) {
					continue;
				}
				// 调用source对象的getMethod方法
				srcValue = getMethod.invoke(source);
				if (srcValue == null) {
					if(!ignoreNull){
						setMethod.invoke(target, srcValue);
					}
					continue;
				}
				if (srcProperty.getPropertyType() != desProperty.getPropertyType()) {
					setMethod.invoke(target, convert(srcValue, desProperty.getPropertyType()));
				} else {
					setMethod.invoke(target, srcValue);
				}
			} catch (IntrospectionException e) { // 在获取目标类中属性时,若属性不存在会抛此异常
				continue;
			} catch (IllegalArgumentException e) {
//				String nodeName = getNodeName(srcProperty, sourceClz);
//				log.warn(String.format("Bean转化出错：%s属性[%s][%s]值%s-->%s,原因:%s", sourceClz.getName(), srcProperty.getName(), nodeName, srcValue, targetClz.getName(), e.getMessage()), e);
//				throw new BusinessException("XDCAL0449906", e);
				e.printStackTrace();
			} catch (Exception e) {
//				String nodeName = getNodeName(srcProperty, sourceClz);
//				log.warn(String.format("Bean转化出错：%s属性[%s][%s]值%s-->%s,原因:%s", sourceClz.getName(), srcProperty.getName(), nodeName, srcValue, targetClz.getName(), e.getMessage()), e);
//				throw new BusinessException("XDCAL0449906", e);
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取属性的MsgNode（Annotation）定义的值
	 * @param srcProperty
	 * @param sourceClz
	 * @return
	 */
//	@SuppressWarnings("rawtypes")
//	private static String getNodeName(PropertyDescriptor srcProperty, Class sourceClz) {
//		String nodeName = srcProperty.getName();
//		Annotation annotation = srcProperty.getPropertyType().getAnnotation(MsgNode.class);
//		if (annotation != null) {
//			nodeName = ((MsgNode) annotation).name();
//		} else {
//			Field oneField;
//			try {
//				oneField = sourceClz.getDeclaredField(nodeName);
//				if (oneField != null) {
//					Annotation fdAn = oneField.getAnnotation(MsgNode.class);
//					nodeName = ((MsgNode) fdAn).name();
//				}
//			} catch (SecurityException e) {
//				e.printStackTrace();
//			} catch (NoSuchFieldException e) {
//				e.printStackTrace();
//			}
//		}
//		return nodeName;
//	}

	public static Object convert(Object obj, Class<?> clazz) {
		return getConverter().convert(obj, clazz);
	}

//	public static Object getBean(String beanName) {
//		return FrameworkContext.getApplicationContext().getBean(beanName);
//	}
//	
//	public static <T> T getBean(String beanName, Class<T> clz) {
//		return FrameworkContext.getApplicationContext().getBean(beanName, clz);
//	}

	/**
	 * 对比两个DO里面的相同字段和不同字段
	 * 
	 * @param classOne
	 * @param classTwo
	 */
	public static void difClassBetween(Class<?> classOne, Class<?> classTwo) {
		List<String> sameProperties = new ArrayList<String>();// 相同字段
		List<String> difOneProperties = new ArrayList<String>();// 类一 特有字段
		List<String> difTwoProperties = new ArrayList<String>();// 类二 特有字段
		Field[] oneFields = classOne.getDeclaredFields();
		Field[] twoFields = classTwo.getDeclaredFields();
		for (Field tempField : twoFields) {
			difTwoProperties.add(tempField.getName());
		}
		String oneFieldName, twoFieldName;
		Boolean success = false;
		for (int i = 0; i < oneFields.length; i++) {
			oneFieldName = oneFields[i].getName();
			success = false;
			for (int j = 0; j < twoFields.length; j++) {
				twoFieldName = twoFields[j].getName();
				if (oneFieldName.equals(twoFieldName)) {
					sameProperties.add(twoFieldName);
					difTwoProperties.remove(twoFieldName);
					success = true;
					break;
				}
			}
			if (!success) {
				difOneProperties.add(oneFieldName);
			}
		}
		// 输出
		System.out.println("---------相同字段-----");
		Integer i = 1;
		for (String temp : sameProperties) {
			System.out.println(i.toString() + ":" + temp);
			i++;
		}
		i = 1;
		System.out.println("----类:" + classOne.getSimpleName() + "特有字段-----");
		for (String temp : difOneProperties) {
			System.out.println(i.toString() + ":" + temp);
			i++;
		}
		i = 1;
		System.out.println("----类:" + classTwo.getSimpleName() + "特有字段-----");
		for (String temp : difTwoProperties) {
			System.out.println(i.toString() + ":" + temp);
			i++;
		}
	}

	/**
	 * 将map集合转换成Bean集合，Bean的属性名与map的key值对应时不区分大小写，并对map中key做忽略OMIT_REG正则处理
	 * 
	 * @param <E>
	 * @param cla
	 * @param mapList
	 * @return
	 */
	public static <E> List<E> toBeanList(Class<E> cla, List<Map<String, Object>> mapList) {
		List<E> list = new ArrayList<E>(mapList.size());

		for (Map<String, Object> map : mapList) {
			E obj = mapToBean(cla, map);
			list.add(obj);
		}

		return list;
	}

	/**
	 * 将map转换成Bean，Bean的属性名与map的key值对应时不区分大小写，并对map中key做忽略OMIT_REG正则处理
	 * 
	 * @param <E>
	 * @param cla
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static <E> E mapToBean(Class<E> cla, Map<String, Object> map) {

		// 创建对象
		E obj = null;
		try {
			obj = cla.newInstance();
			if (obj == null) {
				throw new RuntimeException("实例化"+cla.getName()+"失败");
			}
		} catch (Exception e) {
			log.error("类型实例化对象失败,类型:" + cla, e);
			return null;
		}

		// 处理map的key
		Map<String, Object> newmap = new HashMap<String, Object>();
		for (Map.Entry<String, Object> en : map.entrySet()) {
			newmap.put("set" + en.getKey().trim().replaceAll(OMIT_REG, "").toLowerCase(), en.getValue());
		}

		// 进行值装入
		Method[] ms = cla.getMethods();
		for (Method method : ms) {
			String mname = method.getName().toLowerCase();
			if (mname.startsWith("set")) {

				Class[] clas = method.getParameterTypes();
				Object v = newmap.get(mname);
				if (v != null && clas.length == 1) {
					try {
						method.invoke(obj, v);
					} catch (Exception e) {
						log.error("属性值装入失败,装入方法：" + cla + "." + method.getName() + ".可装入类型" + clas[0] + ";欲装入值的类型:" + v.getClass());
					}
				}
			}
		}

		return obj;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map beanToMap(Object bean) {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		} catch (IntrospectionException e) {
			log.error("Java Bean转Map时，方法convertBean 出错，" + e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			log.error("Java Bean转Map时，方法convertBean 出错，" + e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error("Java Bean转Map时，方法convertBean 出错，" + e.getMessage(), e);
		} catch (InvocationTargetException e) {
			log.error("Java Bean转Map时，方法convertBean 出错，" + e.getMessage(), e);
		}

		return returnMap;
	}

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertMap(Class type, Map map) {
		BeanInfo beanInfo = null;
		Object obj = null;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			// 获取类属性
			obj = type.newInstance();// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				Class propertyType = descriptor.getPropertyType();
				if (map.containsKey(propertyName)) {
					// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
					String value = String.valueOf(map.get(propertyName));
					Object[] args = new Object[1];
					if ("java.lang.Long".equals(propertyType.getName()) || (propertyType == Long.TYPE)) {
						args[0] = Long.valueOf(value);
					} else if ("long".equals(propertyType.getName()) || (propertyType == Long.TYPE)) {
						args[0] = Long.parseLong(value);
					} else if ("java.lang.Integer".equals(propertyType.getName()) || (propertyType == Integer.TYPE)) {
						args[0] = Integer.valueOf(value);
					} else if ("int".equals(propertyType.getName()) || (propertyType == Integer.TYPE)) {
						args[0] = Integer.parseInt(value);
					} else if ("double".equals(propertyType.getName()) || (propertyType == Double.TYPE)) {
						args[0] = Integer.parseInt(value);
					} else if ("java.lang.Double".equals(propertyType.getName()) || (propertyType == Double.TYPE)) {
						args[0] = Double.valueOf(value);
					} else if ("java.lang.Boolean".equals(propertyType.getName()) || (propertyType == Boolean.TYPE)) {
						args[0] = Boolean.valueOf(value);
					} else if ("boolean".equals(propertyType.getName()) || (propertyType == Boolean.TYPE)) {
						args[0] = Boolean.getBoolean(value);
					} else if ("java.lang.Float".equals(propertyType.getName()) || (propertyType == Float.TYPE)) {
						args[0] = Float.valueOf(value);
					} else if ("float".equals(propertyType.getName()) || (propertyType == Float.TYPE)) {
						args[0] = Float.parseFloat(value);
					} else if ("java.util.Date".equals(propertyType.getName()) || (propertyType == Date.class)) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							args[0] = sdf.parse(value);
						} catch (ParseException e) {
							log.error("Map转Java Bean时，方法convertMap 出错，ParseException" + e.getMessage());
						}
					} else {
						args[0] = value;
					}
					try {
						descriptor.getWriteMethod().invoke(obj, args);
					} catch (IllegalArgumentException e) {
						log.error("Map转Java Bean时，方法convertMap 出错，IllegalArgumentException" + e.getMessage());
					} catch (InvocationTargetException e) {
						log.error("Map转Java Bean时，方法convertMap 出错，InvocationTargetException" + e.getMessage());
					}

				}
			}
		} catch (IntrospectionException e) {
			log.error("Map转Java Bean时，方法convertMap 出错，IntrospectionException" + e.getMessage());
		} catch (InstantiationException e) {
			log.error("Map转Java Bean时，方法convertMap 出错，InstantiationException" + e.getMessage());
		} catch (IllegalAccessException e) {
			log.error("Map转Java Bean时，方法convertMap 出错，IllegalAccessException" + e.getMessage());
		}

		return obj;
	}

	// 关键代码 执行序列化和反序列化 进行深度拷贝
	public static List<?> deepListCopy(List<?> src) {
		List<?> dest = null;
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(src);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			dest = (List<?>) in.readObject();
		} catch (IOException e) {
			log.error("====IOException======ObjectBeanUtil服务接口deepCopy失败:" + e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			log.error("=====ClassNotFoundException=====ObjectBeanUtil服务接口deepCopy失败:" + e.getMessage(), e);
		}
		return dest;
	}

	/**
	 * 复制对象属性
	 * modified by caichaogang 2015-04-16 增添转换时的属性转换功能
	 * 
	 * @param source
	 * @param target
	 * @param excludsArray
	 *            排除属性列表
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void copyPropertiesExclude(Object source, Object target, String[] excludsArray) {
		List<String> excludesList = null;
		// 如果转换对象为空直接返回
		if (source == null) {
			return;
		}
		if (excludsArray != null && excludsArray.length > 0) {
			excludesList = Arrays.asList(excludsArray); // 构造列表对象
		}
		Class sourceClz = source.getClass();
		Class targetClz = target.getClass();
		// 得到源对象Class所表征的类的所有属性(包括私有属性)
		PropertyDescriptor[] srcPropertys = BeanUtils.getPropertyDescriptors(sourceClz);
		Object srcValue = null;

		log.debug("Bean转化开始："+sourceClz.getName()+"-->"+targetClz.getName());
		for (PropertyDescriptor srcProperty : srcPropertys) {
			try {
				PropertyDescriptor desProperty = new PropertyDescriptor(srcProperty.getName(), targetClz);
				// 由方法的名字得到get和set方法的Method对象
				Method setMethod = desProperty.getWriteMethod();
				Method getMethod = srcProperty.getReadMethod();
				if (getMethod == null || setMethod == null) {
					continue;
				}
				// 调用source对象的getMethod方法
				srcValue = getMethod.invoke(source);
				if (srcValue == null) {
						setMethod.invoke(target, srcValue);
					continue;
				}
				// 排除列表检测
				if (excludesList != null && excludesList.contains(srcProperty.getName())) {
					continue;
				}
				if (srcProperty.getPropertyType() != desProperty.getPropertyType()) {
					setMethod.invoke(target, convert(srcValue, desProperty.getPropertyType()));
				} else {
					setMethod.invoke(target, srcValue);
				}
			} catch (IntrospectionException e) { // 在获取目标类中属性时,若属性不存在会抛此异常
				continue;
			} catch (IllegalArgumentException e) {
//				String nodeName = getNodeName(srcProperty, sourceClz);
//				log.warn(String.format("Bean转化出错：%s属性[%s][%s]值%s-->%s,原因:%s", sourceClz.getName(), srcProperty.getName(), nodeName, srcValue, targetClz.getName(), e.getMessage()), e);
//				throw new BusinessException("XDCAL0449906", e);
				e.printStackTrace();
			} catch (Exception e) {
//				String nodeName = getNodeName(srcProperty, sourceClz);
//				log.warn(String.format("Bean转化出错：%s属性[%s][%s]值%s-->%s,原因:%s", sourceClz.getName(), srcProperty.getName(), nodeName, srcValue, targetClz.getName(), e.getMessage()), e);
//				throw new BusinessException("XDCAL0449906", e);
				e.printStackTrace();
			}
		}
	
	}
	
	
	/**
	 * 调用bean方法
	 * @param beanId
	 * @param methodId
	 * @param args
	 * @return
	 */
//	public static Object callBeanMethod(String beanId, String methodId, Object... args){
//		Object ret = null;
//		Method method = null;
//		Object bean = null;
//		Class<?>[] actualParameterTypes = null;
//		StringBuilder sb = new StringBuilder(methodId+"(");
//		if(args!=null && args.length > 0){
//			actualParameterTypes = new Class<?>[args.length];
//			for(int i=0; i<args.length; i++){
//				sb.append(args[i].getClass().getName()+",");
//				actualParameterTypes[i] = args[i].getClass();
//			}
//		}
//		sb.setCharAt(sb.length()-1, ')');
//		String methodString = sb.toString();
//		
//		try{
//			bean = getBean(beanId);
//			method = getAppropriateMethod(bean.getClass(),methodId,actualParameterTypes);
//			if(null == method){
////				log.error("调用方法出错，没有找到该方法，beanId："+beanId+",方法："+methodString);	
//				throw new BusinessException("YBLAL0449910","调用方法出错，没有找到该方法，beanId："+beanId+",方法："+methodString);
////				return null;
//			}
//			ret = method.invoke(bean, args);
//		}catch(BeansException e){
////			log.error("调用方法出错，描述：没有找到bean，beanId："+beanId+",方法："+methodString,e);		
//			throw new BusinessException("YBLAL0449910","调用方法出错，没有找到bean，beanId："+beanId+",方法："+methodString);
////			return null;
//		}catch(IllegalArgumentException e){
////			log.error("调用方法出错，描述：参数非法,beanId:"+beanId+",方法:"+methodString, e);
//			throw new BusinessException("YBLAL0449910","调用方法出错，参数非法，beanId："+beanId+",方法："+methodString+"描述："+e.getCause().getMessage());
////			return null;
//		}catch(IllegalAccessException e){
////			log.error("调用方法出错，描述：访问非法,beanId:"+beanId+",方法:"+methodString, e);
//			throw new BusinessException("YBLAL0449910","调用方法出错，访问非法，beanId："+beanId+",方法："+methodString+"描述："+e.getCause().getMessage());
////			return null;
//		}catch(InvocationTargetException e){
////			log.error("调用方法出错，描述：方法执行中抛出异常,beanId:"+beanId+",方法:"+methodString+",原因描述:"+e.getCause().getMessage(), e);
//			throw new BusinessException("YBLAL0449910","调用方法出错，方法执行中抛出异常，beanId："+beanId+",方法："+methodString+"描述："+e.getCause().getMessage());
////			return null;
//		}catch(Exception e){
////			log.error("调用方法出错，描述：未知异常,beanId："+beanId+",方法："+methodString, e);
//			throw new BusinessException("YBLAL0449910","调用方法出错，未知异常，beanId："+beanId+",方法："+methodString+"描述："+e.getCause().getMessage());
////			return null;
//		}
//		
//		return ret;
//	}
	
	/**
	 * 调用静态方法
	 * @param className
	 * @param methodId
	 * @param args
	 * @return
	 */
//	public static Object callStaticMethod(String className, String methodId, Object...args){
//		Class<?> targetClass = null;
//		Method method = null;
//		Object result = null;
//		Class<?>[] actualParameterTypes = null;
//		StringBuilder sb = new StringBuilder(methodId+"(");
//		if(args!=null && args.length > 0){
//			actualParameterTypes = new Class<?>[args.length];
//			for(int i=0; i<args.length; i++){
//				sb.append(args[i].getClass().getName()+",");
//				actualParameterTypes[i] = args[i].getClass();
//			}
//		}
//		sb.setCharAt(sb.length()-1, ')');
//		String methodString = sb.toString();
//		try{
//			targetClass = Class.forName(className);
//			method = getAppropriateMethod(targetClass, methodId, actualParameterTypes);
//			if(null == method){
////				log.error("调用方法出错，描述：没有找到该方法，类名："+className+",方法："+methodString);
//				throw new BusinessException("YBLAL0449910","调用方法出错，没有找到该方法，类名："+className+",方法："+methodString);
////				return null;
//			}
//			result = method.invoke(null,args);
//			
//		}catch(ClassNotFoundException e){
////			log.error("调用方法出错，描述：没有找到该类,类名:"+className+",方法:"+methodString, e);
//			throw new BusinessException("YBLAL0449910");
////			result = null;
//		}catch(IllegalArgumentException e){
////			log.error("调用方法出错，描述：参数非法,类名:"+className+",方法:"+methodString, e);
//			throw new BusinessException("YBLAL0449910");
////			result = null;
//		}catch(IllegalAccessException e){
////			log.error("调用方法出错，描述：访问非法,类名:"+className+",方法:"+methodString, e);
//			throw new BusinessException("YBLAL0449910");
////			result = null;
//		}catch(InvocationTargetException e){
////			log.error("调用方法出错，描述：方法执行中抛出异常,类名:"+className+",方法:"+methodString+",原因描述:"+e.getCause().getMessage(), e);
//			throw new BusinessException("YBLAL0449910");
////			result = null;
//		}catch(BusinessException e){
//			throw e;
//		}catch(Exception e){
////			log.error("调用方法出错，描述：未知异常，类名:"+className+",方法:"+methodString, e);
//			throw new BusinessException("YBLAL0449910");
////			return null;
//		}
//		
//		return result;
//	}
	
	/**返回恰当的方法，根据方法名称和参数类型进行比较
	 * 返回目标类targetClass中 名称为methodId，且参数类型与actualParameterTypes中的类型向上兼容 的方法
	 * @param bean
	 * @param methodId
	 * @param actualParameterTypes
	 * @return 方法
	 */
	public static Method getAppropriateMethod(Class<?> targetClass, String methodId, Class<?>[] actualParameterTypes) {
		Method method = null;
		if (null != actualParameterTypes && actualParameterTypes.length > 0) {
			boolean flag = true;
			Method[] methods = targetClass.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().equals(methodId)) {
					Class<?>[] methodParmTypes = m.getParameterTypes();
					if (actualParameterTypes.length == methodParmTypes.length) {
						flag = true;
						for (int i = 0; i < actualParameterTypes.length; i++) {
							Class<?> parm = actualParameterTypes[i];
							if (!methodParmTypes[i].isAssignableFrom(parm)) {
								flag = false;
								break;
							}
						}
						if (flag) {
							method = m;
							break;
						}
					}
				}
			}
		} else {
			try {
				method = targetClass.getMethod(methodId, actualParameterTypes);
			} catch (Exception e) {
				log.warn("获取方法" + targetClass.getName() + "." + methodId + "出现异常", e);
				method = null;
			}
		}
		return method;
	}

	/**
     * Tells whether the given object is compatible with the given class ---that is, whether the
     * given object can be passed as an argument to a method or constructor whose parameter type is
     * the given class. If object is null this will return true because null is compatible with any
     * type.
     */
    public static final boolean isTypeCompatible(Object object, Class c)
    {
        boolean result = true;

        if (object != null) {
            if (c.isPrimitive()) {
                if (getArgClass(object) != c) {
                    result = false;
                }
            } else if (!c.isInstance(object)) {
                result = false;
            }
        }
        return result;
    }
    

    /**
     * Tells whether the first array of classes is more specific than the second. Assumes that the
     * two arrays are of the same length.
     */
    public static final boolean isMoreSpecific(Class[] classes1, Class[] classes2)
    {
        for (int index = 0, count = classes1.length; index < count; ++index) {
            Class c1 = classes1[index], c2 = classes2[index];
            if (c1 == c2)
                continue;
            else if (c1.isPrimitive())
                return true;
            else if (c1.isAssignableFrom(c2))
                return false;
            else if (c2.isAssignableFrom(c1))
                return true;
        }

        // They are the same! So the first is not more specific than the second.
        return false;
    }
    
    /**
     * Gets the class for a method argument that is appropriate for looking up methods by
     * reflection, by looking for the standard primitive wrapper classes and exchanging for them
     * their underlying primitive class objects. Other classes are passed through unchanged.
     *
     * @param arg an object that is being passed to a method
     * @return the class to use to look up the method
     */
    public static final Class getArgClass(Object arg)
    {
        if (arg == null)
            return null;
        Class c = arg.getClass();
        if (c == Boolean.class)
            return Boolean.TYPE;
        else if (c.getSuperclass() == Number.class) {
            if (c == Integer.class)
                return Integer.TYPE;
            if (c == Double.class)
                return Double.TYPE;
            if (c == Byte.class)
                return Byte.TYPE;
            if (c == Long.class)
                return Long.TYPE;
            if (c == Float.class)
                return Float.TYPE;
            if (c == Short.class)
                return Short.TYPE;
        } else if (c == Character.class)
            return Character.TYPE;
        return c;
    }
	
	/**
	 * 将一个列表中的值全部复制到另一个列表中，可用于将请求报文中的集合属性赋值给查询条件的场景
	 * 示例：比如要将请求报文中的资产组合代码的列表复制到查询条件的响应列表中，可以以如下形式调用
	 * criteria.setAstprtflGrpList(getNonEmptyFieldValues((List)reqVo.getAstprtflGrp(), "astprtflId"))
	 *
	 * @param beans 复制的数据源
	 * @parm fieldName 源数据集合中的属性名称,不是集合的名称
	 * @return 复制的目的地
	 */
	public static List<String> getNonEmptyFieldValues(List<Object> beans, String fieldName) {
		if (CollectionUtils.isEmpty(beans)) {
			return null;
		}

		List<String> fieldValues = new ArrayList<String>(beans.size());
		for (Object bean : beans) {
			final Object value = getFieldValue(bean, fieldName);
			final String valueStr = (value == null) ? null : value.toString();
			if (StringUtils.isNotEmpty(valueStr)) {
				fieldValues.add(valueStr);
			}
		}
		return fieldValues;
	}

	/**
	 * 通过域名取得bean的属性值
	 */
	private static Object getFieldValue(Object bean, String fieldName) {
		Field[] fields = bean.getClass().getDeclaredFields();
		Field.setAccessible(fields, true);

		Object obj = null;
		for (Field field : fields) {
			if (fieldName.equals(field.getName())) {
				try {
					obj = field.get(bean);
				} catch (IllegalArgumentException e) {
					log.warn(e.getMessage());
				} catch (IllegalAccessException e) {
					log.warn(e.getMessage());
				}
			}
		}
		return obj;
	}
}