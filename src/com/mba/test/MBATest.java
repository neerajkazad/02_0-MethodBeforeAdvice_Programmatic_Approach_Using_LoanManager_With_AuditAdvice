package com.mba.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mba.beans.AuditAdvice;
import com.mba.beans.LoanManager;

public class MBATest {

	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new LoanManager());
		pf.addAdvice(new AuditAdvice());
		
		LoanManager proxy = (LoanManager) pf.getProxy();
		boolean status = proxy.approveLoan("l1001");
		System.out.println("Status: "+status);
	}
}
