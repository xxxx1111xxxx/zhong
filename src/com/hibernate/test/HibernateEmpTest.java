package com.hibernate.test;

import java.util.Date;
import java.util.List;

import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;
import com.hibernate.service.EmpBiz;
import com.hibernate.service.impl.EmpBizImpl;

/**
 * emp类操作测试类
 * @author zhong
 *
 */
public class HibernateEmpTest {

	public static void main(String[] args) {
		EmpBiz eb = new EmpBizImpl();
		
		//添加新员工
		/*Dept dept = new Dept(new Byte("51"));
		Emp emp = new Emp();
		emp.setEmpno(new Short("7936"));
		emp.setEname("李四");//员工姓名
		emp.setDept(dept);//部门编号
		emp.setJob("CLERK");//职位,普通员工
		emp.setHiredate(new Date());//入职日期
		eb.addNewEmp(emp);*/
		
		//查询某部门下的所有员工
		/*List<Emp> emps = eb.queryByDept(dept.getDeptNo());
		for (Emp emp : emps) {
			System.out.println("员工姓名:\t" + emp.getEname() + "\t所有部门信息:" + emp.getDept().getdName() );
		}*/
		
		//查询所有员工信息,因为要关联查询,只能在会话未关闭前输出结果,所以在方法中已经输出
		eb.queryAll();
	}

}
