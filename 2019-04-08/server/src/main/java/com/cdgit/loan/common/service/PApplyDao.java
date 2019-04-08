package com.cdgit.loan.common.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.transaction.annotation.Transactional;


public class PApplyDao implements InvocationHandler {
	private String[] methodNames = { "create", "save", "remove", "insert", "update", "delete" };

	private IApplyDao realDao;

	public PApplyDao(IApplyDao dao) {
		this.realDao = dao;
	}

	private <T extends Annotation> boolean havAnnotation(Method method, Class<T> clazz) throws SecurityException, NoSuchMethodException {
		// 子类覆盖或者重写方法以后父类注解不能继承，以防子类继续向下发展后忘了注解，在此通过判断继承父类注解
		Class<?> supper = realDao.getClass();
		do {
			if (supper.getMethod(method.getName(), method.getParameterTypes()).getAnnotation(clazz) != null) {
				return true;
			}
			supper = supper.getSuperclass();
		} while (supper.getName() != Object.class.getName());
		return false;
	}

	private boolean likeName(Method method) {
		String name = method.getName();
		for (int i = 0; i < methodNames.length; i++) {
			if (name.startsWith(methodNames[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object data = null;
		// if (likeName(method) || havAnnotation(method,
		// Transactional.class)) {
		if (havAnnotation(method, Transactional.class)) {
//			ITransactionManager tm = TransactionManagerFactory.getTransactionManager();
//			tm.begin();
			try {
				data = method.invoke(realDao, args);
//				tm.commit();
			} catch (Throwable e) {
//				tm.rollback();
				// e.printStackTrace();
//				throw EosUtil.getException(e);
			}
		} else {
			data = method.invoke(realDao, args);
		}
		return data;
	}
}
