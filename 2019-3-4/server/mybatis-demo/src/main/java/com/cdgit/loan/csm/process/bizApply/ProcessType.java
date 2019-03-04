package com.cdgit.loan.csm.process.bizApply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessType {

	@Autowired
	IProcessAction action;

	public ProcessType(IProcessAction action) {
		this.action = action;
	}

	public IProcessAction getAction() {
		return action;
	}

//	public  ProcessType get(String type) {
//		ProcessType[] temps = ProcessType.;
//		for (ProcessType p : temps) {
//			if (p.toString().equals(type)) {
//				return p;
//			}
//		}
//		return null;
//	}
	

}
