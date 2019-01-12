package com.hibernate.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.hibernate.dao.EmpDao;
import com.hibernate.dao.impl.EmpDaoImpl;
import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;
import com.hibernate.service.EmpBiz;

public class EmpBizImpl implements EmpBiz{
	private EmpDao ed = new EmpDaoImpl();
	/**
	 * 保存员工信息
	 * @param emp
	 */
	@Override
	public void addNewEmp(Emp emp) {
		//事务控制对象
		Transaction tx = null;
		try {
			//begin开启事务
			tx = ed.currentSession().beginTransaction();
			//保存
			ed.save(emp);
			
			//提交
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
	}
	@Override
	public List<Emp> queryByDept(Byte deptNo) {
		//事务控制对象
		Transaction tx = null;
		List<Emp> emps = null;
		try {
			//begin开启事务
			tx = ed.currentSession().beginTransaction();
			//保存
			emps = ed.queryByDept(deptNo);
			
			//提交
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return emps;
	}
	@Override
	public List<Emp> queryAll() {
		//事务控制对象
		Transaction tx = null;
		List<Emp> emps = null;
		try {
			//begin开启事务
			tx = ed.currentSession().beginTransaction();
			//保存
			emps = ed.queryAll();
			
			//会话未关闭前可以关联查询另一个表的数据
			//本来emp表只能查询emp表中属于dept类的deptNo字段,但是hibernate在未关闭会话时直接输出会通过emp表deptNo关联查询dept表的信息
			for (Emp emp : emps) {
				System.out.println("员工姓名:" + emp.getEname() + "\t\t所属部门名称:" + emp.getDept().getdName()
						+ "\t\t部门所在地:" + emp.getDept().getLoc());
			}
			//提交
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
		}
		return emps;
	}

}
