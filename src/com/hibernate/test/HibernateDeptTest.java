package com.hibernate.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Transaction;

import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;
import com.hibernate.service.DeptBiz;
import com.hibernate.service.impl.DeptBizImpl;
import com.hibernate.utrl.HibernateUtrl;

/**
 * hibernate dept类操作 测试类
 * @author zhong
 *
 */
public class HibernateDeptTest {

	public static void main(String[] args) {
		DeptBiz db = new DeptBizImpl();
		
		
		/*Dept dept = new Dept(new Byte("52"), "人事部", "中国浙江");
		Emp emp = new Emp();
		//如果该编号的员工存在,那么会覆盖其信息,其余没数据的字段会是null
		emp.setEmpno(new Short("7935"));
		emp.setEname("王五");
		emp.setJob("普通员工");
		
		//添加部门表的同时将新的员工添加到该部门 关联
		emp.setDept(dept);
		dept.getEmps().add(emp);
		
		//关联完毕
		db.addNewDept(dept);//保存
		*/
		
		//删除部门数据及关联的员工表下属于该部门的记录都会删除,此时不需要像保存那样相互set关联字段
		/*Dept dept = new Dept(new Byte("52"));
		db.deleteDept(dept);//删除	
*/		 							
		
		//更新
		
		
		
		//--------------------------------------------------------------------------
		//deleteDept方法参数已改Dept类型
		
		//加载数据操作
		//db.deleteDept( new Byte("50") );//删除
		//Dept dept = db.findDeptById( new Byte("50") );//查询
		
		//输出调用load方法时已在之前输出结果
		//System.out.println(dept.getdName() + "\t" + dept.getLoc());
		
		//---------------------------------------------------------------------------
		
		//输出所有部门表信息
		//List<Dept> depts = db.queryAllDepts();//执行list查询,返回list集合
		
		/*for (Dept dept : depts) {
			System.out.println("部门名称:\t" + dept.getdName());
		}*/
		
		//执行iterate查询,返回iterator集合,测试结果在方法体内已输出
		//db.queryAllDepts();
		
		//---------------------------------------------------------------------------
		
		//按部门位置查询部门信息
		//List<Dept> depts = db.queryDeptByLocation("China");//执行list查询,返回list集合
		/*List<Dept> depts = db.queryDeptByConditions( new Dept (new Byte("50"), "China") );//执行list查询,返回list集合

		for (Dept dept : depts) {
			System.out.println("部门编号:  " + dept.getDeptNo() + "   部门名称:\t" + dept.getdName() + "\t部门所在地:\t" + dept.getLoc() );
		}*/
		
		//返回单个记录
		//Dept dept = db.queryDeptByDeptNo( new Byte("50") );
		//System.out.println("部门编号:  " + dept.getDeptNo() + "   部门名称:\t" + dept.getdName() + "\t部门所在地:\t" + dept.getLoc() );
		
		//---------------------------------------------------------------------------

		//分页查询,第一页,每页返回2条记录
		List<Dept> depts = db.queryDeptByPage(3, 2);
		for (Dept dept : depts) {
			System.out.println("部门编号:  " + dept.getDeptNo() + "   部门名称:\t" + dept.getdName() + "\t部门所在地:\t" + dept.getLoc() );
		}
		
		/*Transaction tx = HibernateUtrl.getCurrentSession().beginTransaction();
		//2个方法都能获得一条记录,第一个获得的是第一条记录,第2个不清楚
		Dept dept = (Dept)HibernateUtrl.getCurrentSession().createQuery("from Dept").list().get(0);
		//Dept dept = (Dept)HibernateUtrl.getCurrentSession().createQuery("from Dept").list().iterator().next();
		
		System.out.println("部门编号:  " + dept.getDeptNo() + "   部门名称:\t" + dept.getdName() + "\t部门所在地:\t" + dept.getLoc() );
		tx.commit();*/
		//---------------------------------------------------------------------------
		
//		Dept dept = new Dept();
//		dept.setdName("维修");//添加一个维修部门Repair
//		dept.setLoc("China");//部门地址在中国
//		dept.setDeptNo(new Byte("50"));//部门编号为50
		
		//db.addNewDept(dept);//添加
		//db.updateDept(dept);//更新
	}
}
