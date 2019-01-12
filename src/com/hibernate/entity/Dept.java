package com.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * oracle数据库中的部门表
 * @author zhong
 *
 */
public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte deptNo;//部门编号,该测试表只有4个记录
	private String dName;//部门名称
	private String loc;//所在位置
	private Set<Emp> emps = new HashSet<Emp>();//一个部门映射多个员工
	
	public Dept() {
		super();
	}

	public Dept(byte deptNo) {
		super();
		this.deptNo = deptNo;
	}

	public Dept(byte deptNo, String dName, String loc) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	public byte getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(byte deptNo) {
		this.deptNo = deptNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
