package com.cdgit.loan.csm.process.bizApply;

import com.cdgit.loan.csm.process.bizApply.AProcessActions.CrtAction;

public enum ProcessType {
	
	crt(new CrtAction()); // 合同签约
	
	private IProcessAction action;

	private ProcessType(IProcessAction action) {
		this.action = action;
	}

	public IProcessAction getAction() {
		return action;
	}

	public static ProcessType get(String type) {
		ProcessType[] temps = ProcessType.values();
		for (ProcessType p : temps) {
			if (p.toString().equals(type)) {
				return p;
			}
		}
		return null;
	}
	

}
