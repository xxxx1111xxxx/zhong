package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;

/**
 * 操作员工表接口
 * @author zhong
 *
 */
public interface EmpDao extends BaseDao{

	/**
	 * 保存员工信息
	 * @param emp
	 */
	public void save(Emp emp);
	
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
