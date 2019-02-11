
package com.cdgit.loan.common.util.uid;

import java.io.BufferedWriter;
import java.io.FileWriter;


/**
 * <p>commons���ߣ�UUID�����</p>
 * @author mingzou
 * @version 1.0
 * @since 2007-02-11
*/
public class UUIDGenerator
{

    public UUIDGenerator()
    {
    }
    /**
	 * ����UUID
	 * @return String
	 */
    public static synchronized String getUUID()
    {
        return uuid.getNextUID();
    }
    /**
	 * ���ָ�����ȵ�UUID��������δʵ��
	 * @param len int
	 * @return String
	 */
    public static String getUUID(int len)
    {
        return uuid.getNextUID(len);
    }

    public static void main(String args[])
    {
        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter("d:\\uuid.txt"));
            for(int i = 1; i < 10000; i++)
            {
                fw.write(uuid.getNextUID());
                fw.write(System.getProperty("line.separator"));
            }

            fw.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static UIDFactory uuid;

    static 
    {
        try
        {
            uuid = UIDFactory.getInstance("UUID");
        }
        catch(UIDNotSupportException unsex) {unsex.printStackTrace(); }
    }
}
