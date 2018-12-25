
package com.cdgit.loan.common.util;

import java.math.BigDecimal;

public class MathUtil
{

    public MathUtil()
    {
    }
    /**
	 * ������ֵ�ļ��� ��<BR>
	 * ��ת��ΪBigdecimal������
	 * */
    public static double BDadd(double a, double b)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        b1 = b1.add(b2);
        return b1.doubleValue();
    }
    /**
	 * ������ֵ�ļ��� ��<BR>
	 * ��ת��ΪBigdecimal������
	 * */
    public static double BDmultiply(double a, double b)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        b1 = b1.multiply(b2);
        return b1.doubleValue();
    }
    /**
	 * ������ֵ�ļ��� �� return = a - b<BR>
	 * ��ת��ΪBigdecimal������
	 * */
    public static double BDsubtract(double a, double b)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        b1 = b1.subtract(b2);
        return b1.doubleValue();
    }
    /**
	 * ������ֵ�ļ��� �� return= a / b<BR>
	 * ��ת��ΪBigdecimal������ ֻ���ڿ�������Ӧ�ã�
	 * @see  cn.easyuda.commons.MathUtil.BDdivide(double a,double b,int scale)
	 * */
    public static double BDdivide(double a, double b)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        b1 = b1.divide(b2, 7);
        return b1.doubleValue();
    }
    /**
	 * ������ֵ�ļ��� �� return= a / b<BR>
	 * ��ת��ΪBigdecimal������
	 * @param scale ��ȷ��С����λ��
	 * */
    public static double BDdivide(double a, double b, int scale)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        b1 = b1.divide(b2, scale, 4);
        return b1.doubleValue();
    }
}
