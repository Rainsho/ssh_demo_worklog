package com.rainsho.aop;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoginCheck {

	@Before("execution(* com.rainsho.action.LogAction.find*(..))")
	public void logincheck() {
		try {
			if (ServletActionContext.getRequest().getSession()
					.getAttribute("LOGIN_USER") == null) {
				ServletActionContext.getResponse().sendRedirect("index.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before("execution(* com.rainsho.action.LogAction.add*(..))")
	public void logincheck2() {
		logincheck();
	}

	@Before("execution(* com.rainsho.action.LogAction.log*(..))")
	public void logincheck3() {
		logincheck();
	}

}
