package com.example.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Employee;
import com.example.util.HibernateUtil;

import jakarta.persistence.Entity;


public class ClientCode {

	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			Object result = session.createNativeQuery("select version()", Entity.class).getSingleResult();
			System.out.println("Database version: " + result);
			Employee e = new Employee();
			e.setName("ak");
			e.setSal(1000);
			session.persist(e);
			Object result1 = session.createNativeQuery("select id, name, sal from Employee", Employee.class).list();
			System.out.println("List: " + result1);
			Employee e1 = session.getReference(Employee.class, 1);
			System.out.println("Employee : " + e1);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
