package com.hibernate.service;

import java.util.List;

import com.hibernate.entity.Emp;

public interface EmpBiz {
	/**
	 * 保存员工信息
	 * @param emp
	 */
	public void addNewEmp(Emp emp);
	
	/**
	 * 通过部门表dept编号查询该部门所有员工
	 * @return
	 */
	public List<Emp> queryByDept(Byte deptNo);
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Emp> queryAll();
}
