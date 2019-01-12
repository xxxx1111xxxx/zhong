package com.hibernate.dao.impl;

import org.hibernate.Session;

import com.hibernate.dao.BaseDao;
import com.hibernate.utrl.HibernateUtrl;
/**
 * dao基类封装currentSession方法,其他dao继承该类,简化获得session的代码
 * @author zhong
 *
 */
public class BaseDaoImpl implements BaseDao{
	public Session currentSession(){
		return HibernateUtrl.getCurrentSession();
	}
}
