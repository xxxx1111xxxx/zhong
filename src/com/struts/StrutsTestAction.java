package com.struts;

import com.opensymphony.xwork2.Action;

public class StrutsTestAction implements Action{
	private String name = "";
	private String message = "";

	@Override
	public String execute() throws Exception {
		this.setMessage("你输入的数据为: " + this.getName());
		
		return "/page/struts";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
