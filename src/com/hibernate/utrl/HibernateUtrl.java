package com.hibernate.utrl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 使用hibernate jdbc api连接数据库
 * @author zhong
 *
 */
public class HibernateUtrl {

	private static Configuration configuration;//Configuration对象负责管理hibernate的配置信息
	private final static SessionFactory sessionFactory;//SessionFactory负责创建session对象
	//初始化Configuration和SessionFactory
	static{
		try {
			//读取并解析配置文件及映射文件
			configuration = new Configuration().configure("hibernate.cfg.xml");
			//根据配置文件的信息创建sessionFactory对象
			sessionFactory = configuration.buildSessionFactory();
		} catch (HibernateException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private HibernateUtrl(){}
	
	//获得session对象
	public static Session getCurrentSession(){
		//打开session,也可以使用openSession(),如果是通过该方法创建的session,事务结束后要close
		/*如果在配置文件中 hibernate.current_session_context_class设置为thread,这里用getCurrentSession()方法
			获得session,不需要close,hibernate会在关联的事务结束后自动关闭
		*/
		return sessionFactory.getCurrentSession();
	}
}
