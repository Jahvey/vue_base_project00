package com.cdgit.loan.customerManage.natural.message;

/**
 * Created by Administrator on 2018/10/18.
 */
public class ResponseMsg {

    private String code;
    private String desc;
    private Object data;//后台返回数据结果
    private int totalRec;//分页查询返回总记录数
    private int total;

    public ResponseMsg() {
        this.code = "00";
        this.desc = "成功";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }

	public int getTotalRec() {
		return totalRec;
	}

	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
