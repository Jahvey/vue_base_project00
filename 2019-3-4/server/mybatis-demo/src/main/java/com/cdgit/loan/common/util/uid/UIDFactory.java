
package com.cdgit.loan.common.util.uid;

import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * <p>commons���ߣ�UUID����������, UUID��Ĭ�ϵ�String����</p>
 *
 * <p> ����:
 * <pre>
 * private static UIDFactory uuid = null;
 *
 * try {
 *      uuid = UIDFactory.getInstance("UUID");
 * } catch (UIDNotSupportException unsex) {};
 *
 * String id = uuid.getNextUID();
 * </pre>
 * @author mingzou
 * @version 1.0
 * @since 2007-02-11
*/

public abstract class UIDFactory
{

    public UIDFactory()
    {
        isMd5 = false;
    }
    /**
	 * ���Ĭ�ϵ�UIDFactory.
	 *
	 *@return   UIDFactory UID manager object
	 */
    public static UIDFactory getDefault()
    {
        return UUID.getInstance();
    }
    /**
	 * ���ָ����UIDFactory.
	 *
	 *@param uidfactory                         Description of the Parameter
	 *@return                                   UIDFactory
	 *@exception UIDNotSupportException         Description of the Exception
	 *@throws java.lang.ClassNotFoundException
	 */
    public static UIDFactory getInstance(String uidfactory)
        throws UIDNotSupportException
    {
        if(uidfactory.equalsIgnoreCase("UUID"))
            return UUID.getInstance();
        if(uidfactory.equalsIgnoreCase("GUID"))
            return GUID.getInstance();
        else
            throw new UIDNotSupportException((new StringBuilder()).append(uidfactory).append(" Not Found!").toString());
    }

    public abstract String getNextUID();

    public abstract String getUID();

    public void setMD5(boolean flag)
    {
        isMd5 = flag;
    }

    public boolean isMD5()
    {
        return isMd5;
    }

    public abstract void setUID(String s)
        throws Exception;

    public abstract String toPrintableString();

    protected static byte[] toMD5(byte bytes[])
    {
        return md5.digest(bytes);
    }

    private static long getMachineID()
    {
        long i = 0L;
        try
        {
            InetAddress inetaddress = InetAddress.getLocalHost();
            byte abyte0[] = inetaddress.getAddress();
            i = toInt(abyte0);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return i;
    }

    private static int toInt(byte abyte0[])
    {
        int i = abyte0[0] << 24 & 0xff000000 | abyte0[1] << 16 & 0xff0000 | abyte0[2] << 8 & 0xff00 | abyte0[3] & 0xff;
        return i;
    }

    public abstract String getNextUID(int i);

    public static final String UID_GUID = "GUID";
    public static final String UID_UUID = "UUID";
    protected static final long EPOCH;
    protected static final long JVMHASH = Math.abs((new Object()).hashCode());
    protected static final long MACHINEID = getMachineID();
    protected static final Random RANDOM;
    private static MessageDigest md5;
    private boolean isMd5;

    static 
    {
        EPOCH = System.currentTimeMillis();
        RANDOM = new Random(EPOCH);
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.out.println((new StringBuilder()).append("->").append(ex).toString());
        }
    }
}
