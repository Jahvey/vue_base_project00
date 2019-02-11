
package com.cdgit.loan.common.util.uid;


/**
 * <p>commons���ߣ�GUID�ṹ��</p>
 * @author mingzou
 * @version 1.0
 * @since 2007-02-11
*/
public final class GUID extends UUID
{

    private GUID()
    {
        m_count = 0L;
        next();
    }
    /** ��ɲ�����һ��GUID�ͻ����ִ�. */
    protected void next()
    {
        m_hiTag = EPOCH + JVMHASH * 0x100000000L ^ MACHINEID;
        m_loTag = EPOCH * 0x7fffffffL + ++m_count;
        m_uuid = toString(toByteArray());
    }

    private long m_count;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (m_count ^ (m_count >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final GUID other = (GUID) obj;
		if (m_count != other.m_count)
			return false;
		return true;
	}
}
