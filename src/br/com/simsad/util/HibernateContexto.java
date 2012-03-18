package br.com.simsad.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class HibernateContexto implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		HibernateUtil.getSessionFactory();
	}

	public void contextDestroyed(ServletContextEvent sce) {

		HibernateUtil.getSessionFactory().close();
	}

}
