package com.hibernate.service;

import java.util.Iterator;
import java.util.List;

import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;

/**
 * 业务层 dept类操作
 * @author zhong
 *
 */
public interface DeptBiz {

	
	/**
	 * 通过部门id查询部门表的名称
	 * @param id
	 * @return
	 */
	public Dept findDeptById(Byte id);
	
	/**
	 * 添加数据
	 * @param dept
	 */
	public void addNewDept(Dept dept);
	
	/**
	 * 修改部门信息
	 * @param dept
	 */
	/*public void updateDept(Dept dept);*/
	
	/**
	 * 通过部门id删除部门
	 * @param id
	 * @return
	 */
	public void deleteDept(Dept dept);

	/**
	 * 使用HQL(hibernate query language)语言 实现查询功能
	 * 
	 */
	public Iterator<Dept> queryAllDepts();
	
	/**
	 * 通过部门位置查询部门信息
	 * @return
	 */
	public List<Dept> queryDeptByLocation(String loc);
	
	/**
	 * 通过部门位置和部门编号查询部门信息
	 * @return
	 */
	public List<Dept> queryDeptByConditions(Dept conditions);
	
	/**
	 * 通过部门部门编号查询部门信息,此时编号是唯一的
	 * @return
	 */
	public Dept queryDeptByDeptNo(Byte deptNo);
	
	/**
	 * 分页查询
	 * @param pageNo 当前页(起始下标)
	 * @param pageSize 每页记录
	 * @return
	 */
	public List<Dept> queryDeptByPage(int pageNo, int pageSize);
	
}
