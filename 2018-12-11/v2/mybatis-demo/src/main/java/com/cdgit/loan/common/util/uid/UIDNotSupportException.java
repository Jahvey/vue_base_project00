
package com.cdgit.loan.common.util.uid;

/**
 * <p>commons���ߣ�UID�쳣</p>
 * @author mingzou
 * @version 1.0
 * @since 2007-02-11
*/
public class UIDNotSupportException extends ClassNotFoundException
{
	/**
	 * ��Msg��Ĭ�Ϲ�����
	 *
	 *@param s  Description of the Parameter
	 */
    public UIDNotSupportException(String s)
    {
        super(s, null);
    }
}
