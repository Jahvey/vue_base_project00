
package com.cdgit.loan.common.util.uid;

import java.io.BufferedWriter;
import java.io.FileWriter;


/**
 * <p>commons���ߣ�GUID�����</p>
 * @author mingzou
 * @version 1.0
 * @since 2007-02-11
*/
public class GUIDGenerator
{

    public GUIDGenerator()
    {
    }

    public static synchronized String getGUID()
    {
        return uuid.getNextUID();
    }

    public static void main(String args[])
    {
        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter("d:\\guid.txt"));
            for(int i = 0; i <= 10000; i++)
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
            uuid = UIDFactory.getInstance("GUID");
        }
        catch(UIDNotSupportException unsex) {unsex.printStackTrace(); }
    }
}
