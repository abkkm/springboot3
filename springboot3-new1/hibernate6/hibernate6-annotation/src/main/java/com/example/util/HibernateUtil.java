package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// method 1
	private static SessionFactory sessionFactory;
	/*
	static {
		if (sessionFactory == null) {
			try {
				Configuration cfg = new Configuration().configure();
				cfg.addResource("com/example/model/Employee.hbm.xml");
				StandardServiceRegistry ssRegistry = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties()).build();
				sessionFactory = cfg.buildSessionFactory(ssRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	*/

	// method 2
	// private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
	static {
	        if (sessionFactory == null) {
		        try {
				        standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				        Metadata metadata = metadataSources.getMetadataBuilder().build();
				        sessionFactory = metadata.getSessionFactoryBuilder().build();
			        } catch (Exception e) {
				        if(standardServiceRegistry != null) {
				        	StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				        }
			        }
	        }
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
