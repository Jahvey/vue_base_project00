package com.cdgit.loan.common.service;

import java.util.Map;

public interface IDao {

	public Object create(Map<String, Object> data);
//
	public Object update(Map<String, Object> data);

	public void remove(String dataId);

	public void remove(Object data);
	
//	public void remove(DataObject data);

}
