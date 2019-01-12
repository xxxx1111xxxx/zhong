package com.hibernate.entity;

import java.util.Date;

/**
 * scott员工表 emp
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short empno;//员工编号
	private Dept dept;//部门表 emp表关联dept表的deptNo 所属部门编号
	private String ename;//ename:员工姓名
	private String job;//员工职位
	private Short mgr;
	private Date hiredate;//入职日期
	private Double sal;//薪资
	private Double comm;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(Short empno) {
		this.empno = empno;
	}

	// Property accessors

	public Short getEmpno() {
		return this.empno;
	}

	public void setEmpno(Short empno) {
		this.empno = empno;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Short getMgr() {
		return this.mgr;
	}

	public void setMgr(Short mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return this.sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return this.comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

}