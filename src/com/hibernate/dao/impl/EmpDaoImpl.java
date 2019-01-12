package com.hibernate.dao.impl;

import java.util.List;

import com.hibernate.dao.EmpDao;
import com.hibernate.entity.Emp;

public class EmpDaoImpl extends BaseDaoImpl implements EmpDao {

	/**
	 * 保存员工信息
	 * @param emp
	 */
	@Override
	public void save(Emp emp) {
		// TODO 自动生成的方法存根
		currentSession().save(emp);
	}

	@Override
	public List<Emp> queryByDept(Byte deptNo) {
		String hql = "from Emp e where e.dept.deptNo = :deptNo";
		//通过对象属性绑定参数
		return currentSession().createQuery(hql).setByte("deptNo", deptNo).list();
	}

	@Override
	public List<Emp> queryAll() {
		return this.currentSession().createQuery("from Emp order by deptno").list();
	}

}
