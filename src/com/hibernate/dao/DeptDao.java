package com.hibernate.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;

/**
 * dao层操作dept的类
 * 
 * 在进行修改或删除操作时,应先加载类,再执行修改或删除操作,hibernate提供了2种按主键加载对象:get()和load()方法
 * @author zhong
 *
 */
public interface DeptDao extends BaseDao {

	public Dept get(Serializable id);
	
	public Dept load(Serializable id);
	
	/**
	 * 保存 新添加的部门
	 * @param dept
	 */
	public void save(Dept dept);
	
	/**
	 * 删除 新添加的部门
	 * @param dept
	 */
	public void delete(Dept dept);
	
	/**
	 * 修改部门信息,因为要级联修改emp员工表信息,所有参数要有Emp
	 * @param dept
	 */
	/*public void update(Dept dept);*/
	
	/**
	 * 使用HQL(hibernate query language)语言 实现查询功能
	 */
	public Iterator<Dept> queryAll();
	
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
	 * @param pageNo 当前页起始下标
	 * @param pageSize 每页记录
	 * @return
	 */
	public List<Dept> queryDeptByPage(int pageNo, int pageSize);
}
