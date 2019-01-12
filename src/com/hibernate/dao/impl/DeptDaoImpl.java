package com.hibernate.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.hibernate.dao.DeptDao;
import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;
import com.hibernate.utrl.HibernateUtrl;
/**
 * dao层操作dept的类
 * 
 * 在进行修改或删除操作时,应先加载类,再执行修改或删除操作,hibernate提供了2种按主键加载对象:get()和load()方法
 * @author zhong
 *
 */
public class DeptDaoImpl extends BaseDaoImpl implements DeptDao{
	public Dept get(Serializable id){
		//通过session的get()方法根据OID加载指定对象,如果没有指定主键的返回值,会返回null
		return (Dept)currentSession().get(Dept.class, id);
	}
	
	public Dept load(Serializable id){
		//通过session的load()方法根据OID加载指定对象,如果没有指定主键的返回值,会抛异常
		return (Dept)currentSession().load(Dept.class, id);
	}
	
	/**
	 * 保存 新添加的部门
	 * @param dept
	 */
	public void save(Dept dept){
		currentSession().save(dept);
	}
	
	/**
	 * 删除 新添加的部门
	 * @param dept
	 */
	public void delete(Dept dept){
		currentSession().delete(this.load(dept.getDeptNo()));
	}
	
	/**
	 * 修改部门信息
	 * @param dept
	 */
	/*public void update(Dept dept){
		this.currentSession().update( this.load(dept.getDeptNo()) );
	}*/
	
	/**
	 * 使用HQL(hibernate query language)语言 实现查询功能
	 * 
	 * @return 执行list查询,返回list集合
	 * @return 执行iterate查询,返回iterator集合
	 * 
	 * list方法和iterator方法的区别是:list将sql语句合成一句(生成一条sql语句),查询所有符合条件的记录,
	 * iterator方法先查询所有符合条件的主键值,然后在需要对象其他属性值时,才生成按主键查询的sql语句
	 */
	public Iterator<Dept> queryAll(){
		//因为使用的是HQL(hibernate query language)语言,他是一种面向对象的语言,没有表，字段的概念，只有类，对象，属性的概念
		//所以这里的Dept是对象,而不是数据库中的表,也可以用com.hibernate.entity.Dept代替,类的全限定名
		String hql = "from Dept";
		
		//这个Query是hibernate的一个接口
		Query query = currentSession().createQuery(hql);
		
		//return query.list();//执行list查询,返回list集合
		return query.iterate();//执行iterate查询,返回iterator集合
	}
	
	/**
	 * 通过部门位置查询部门信息
	 * @return
	 */
	public List<Dept> queryDeptByLocation(String loc){
		//按占位符绑定
		//String hql = "from Dept d where d.loc = ?";
		//按参数名称绑定
		String hql = "from Dept d where d.loc = :loc";
		
		Query query = currentSession().createQuery(hql);
		//绑定参数
		query.setString("loc", loc);//通过参数名称来绑定,以( :参数名 )形式,优先考虑
		//query.setString(0, "China");//通过占位符绑定参数,从0开始
		
		return query.list();
		
	}
	
	/**
	 * 通过部门位置和部门编号查询部门信息
	 * @return
	 */
	public List<Dept> queryDeptByConditions(Dept conditions){
		//按参数名称绑定
		String hql = "from Dept d where d.loc = :loc and d.deptNo = :deptNo";
		
		Query query = currentSession().createQuery(hql);
		//绑定参数,setProperties()方法根据命名参数的名称,从conditions中获取相应的属性进行赋值
		query.setProperties(conditions);
		return query.list();
		
	}
	
	/**
	 * 通过部门部门编号查询部门信息,此时编号是唯一的,所以应该只有1条或没记录,所以不用list和iterator方法
	 * @return
	 */
	public Dept queryDeptByDeptNo(Byte deptNo){
		//按参数名称绑定
		String hql = "from Dept d where d.deptNo = :deptNo";
		
		Query query = currentSession().createQuery(hql);
		//绑定参数
		query.setString("deptNo", deptNo.toString());//通过参数名称来绑定,以( :参数名 )形式,优先考虑
		
		return (Dept)query.uniqueResult();//unique唯一,Result结果
		
	}
	
	/**
	 * 分页查询
	 * @param pageNo 当前页起始下标
	 * @param pageSize 每页记录
	 * @return
	 */
	public List<Dept> queryDeptByPage(int pageNo, int pageSize){
		String hql = "from Dept d order by d.deptNo";
		
		//分页
		return currentSession().createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize)//设置分页起始下标,(pageNo - 1) * pageSize计算当前页的起始下标
				.setMaxResults(pageSize)//设置每页返回的记录
				.list();
		
	}
}
