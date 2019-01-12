package com.hibernate.dao;

import org.hibernate.Session;

/**
 * dao基类封装currentSession方法,其他dao继承该类,简化获得session的代码
 * @author zhong
 *
 */
public interface BaseDao {

	public Session currentSession();
}
