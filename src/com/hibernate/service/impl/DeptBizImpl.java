package com.hibernate.service.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.hibernate.dao.DeptDao;
import com.hibernate.dao.impl.DeptDaoImpl;
import com.hibernate.entity.Dept;
import com.hibernate.service.DeptBiz;
import com.hibernate.utrl.HibernateUtrl;
/**
 * 业务层 dept类操作
 * @author zhong
 *
 */
public class DeptBizImpl implements DeptBiz{
	private DeptDao deptDao = new DeptDaoImpl();
	
	/**
	 * 通过部门id查询部门表的名称
	 * @param id
	 * @return
	 */
	public Dept findDeptById(Byte id){
		Transaction tx = null;//事务对象
		Dept dept = null;
		
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用get方法,如果没有指定主键的返回值,会返回null
			dept = deptDao.get(id);
			
			//---------------------------------------------------------------------------------
			//调用load方法
			//dept = deptDao.load(id);

			//输出结果,与调用get方法不同,需在会话关闭前测试查询结果,如果没有指定主键的返回值,会抛异常
			//System.out.println(dept.getdName());
			//---------------------------------------------------------------------------------
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}
		return dept;
	}
	
	/**
	 * 添加数据
	 * @param dept
	 */
	public void addNewDept(Dept dept){
		Transaction tx = null;//事务对象
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//保存
			deptDao.save(dept);;
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}
	}
	
	/**
	 * 通过部门id删除部门
	 * @param id
	 * @return
	 */
	public void deleteDept(Dept dept){
		Transaction tx = null;//事务对象
		
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用get或load方法加载要删除的部门对象
			//Dept dept = deptDao.get(id);//在dao层调用delete方法时直接load加载了delete(this.load(dept.getDeptNo()))
			deptDao.delete(dept);
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}
	}

	/**
	 * 修改部门         -----------------------还未使用
	 * @param id
	 * @return
	 */
	public void updateDept(Dept dept){
		Transaction tx = null;//事务对象
		
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用get或load方法加载要删除的部门对象
			Dept update = deptDao.get(dept.getDeptNo());
			//更新数据
			update.setdName(dept.getdName());
			update.setLoc(dept.getLoc());
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}
	}
	
	/**
	 * 使用HQL(hibernate query language)语言 实现查询功能
	 * 
	 * @return 执行list查询,返回list集合
	 * @return 执行iterate查询,返回iterator集合
	 * 
	 * list方法和iterator方法的区别是:list将sql语句合成一句(生成一条sql语句),查询所有符合条件的记录,
	 * iterator方法先查询所有符合条件的主键值,然后在需要对象其他属性值时,才生成按主键查询的sql语句
	 */
	public Iterator<Dept> queryAllDepts(){
		Transaction tx = null;//事务对象
		
		//List<Dept> depts = null;//执行list查询,返回list集合
		Iterator<Dept> depts = null;//执行iterate查询,返回iterator集合
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用deptDao的queryAll方法查询部门表中的所有信息
			depts = deptDao.queryAll();
			
			//与list()方法不同,iterator方法须在会话关闭前测试查询效果
			while(depts.hasNext()){
				Dept dept = depts.next();
				System.out.println("部门名称:\t" + dept.getdName());
			}
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}finally{
			return depts;
		}
	}
	
	/**
	 * 通过部门位置查询部门信息
	 * @return
	 */
	public List<Dept> queryDeptByLocation(String loc){
		Transaction tx = null;//事务对象
		
		List<Dept> depts = null;//执行list查询,返回list集合
		//Iterator<Dept> depts = null;//执行iterate查询,返回iterator集合
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用deptDao的queryAll方法查询部门表中的所有信息
			depts = deptDao.queryDeptByLocation(loc);
			
			//与list()方法不同,iterator方法须在会话关闭前测试查询效果
			/*while(depts.hasNext()){
				Dept dept = depts.next();
				System.out.println("部门名称:\t" + dept.getdName());
			}*/
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}finally{
			return depts;
		}
		
	}
	
	/**
	 * 通过部门位置和部门编号查询部门信息
	 * @return
	 */
	public List<Dept> queryDeptByConditions(Dept conditions){
		Transaction tx = null;//事务对象
		
		List<Dept> depts = null;//执行list查询,返回list集合
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用deptDao的queryAll方法查询部门表中的所有信息
			depts = deptDao.queryDeptByConditions(conditions);
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}finally{
			return depts;
		}
	}
	
	/**
	 * 通过部门部门编号查询部门信息,此时编号是唯一的,所以应该只有1条或没记录,所以不用list和iterator方法
	 * @return
	 */
	public Dept queryDeptByDeptNo(Byte deptNo){
		Transaction tx = null;//事务对象
		Dept dept = null;
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用deptDao的queryAll方法查询部门表中的所有信息
			dept = deptDao.queryDeptByDeptNo(deptNo);
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}finally{
			return dept;
		}
	}
	
	/**
	 * 分页查询
	 * @param pageNo 当前页(起始下标)
	 * @param pageSize 每页记录
	 * @return
	 */
	public List<Dept> queryDeptByPage(int pageNo, int pageSize){
		Transaction tx = null;//事务对象
		List<Dept> depts = null;
		try {
			//开启事务
			tx = HibernateUtrl.getCurrentSession().beginTransaction();
			
			//调用deptDao的queryAll方法查询部门表中的所有信息
			depts = deptDao.queryDeptByPage(pageNo, pageSize);
			
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				//回滚事务
				tx.rollback();
			}
		}finally{
			return depts;
		}
	}
	
	
	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
}
