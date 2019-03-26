package com.cdgit.loan.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.service.CsmBackupSubConAndGrtRelServiceImpl;
import com.cdgit.loan.csm.service.CsmCreateSubConTzFlowServiceImpl;

@RestController
@RequestMapping("backupSubConAndGrtRel")
public class CsmBackupSubConAndGrtRelController {

	@Autowired
	CsmBackupSubConAndGrtRelServiceImpl csmBackupSubConAndGrtRelServiceImpl;
	
	@Autowired
	CsmCreateSubConTzFlowServiceImpl csmCreateSubConTzFlowServiceImpl;
	
	
	
//	@RequestMapping("testDemo")
//	public void testDemo() {
//		
//		System.err.println(csmBackupSubConAndGrtRelServiceImpl.backupSubConAndGrtRel("", ""));
//		
//	}
//	
//	
//	@RequestMapping("testDemo1")
//	public void testDemo1() {
//		
//		System.err.println(csmCreateSubConTzFlowServiceImpl.createSubConTzFlow("", ""));
//		
//	}
}
