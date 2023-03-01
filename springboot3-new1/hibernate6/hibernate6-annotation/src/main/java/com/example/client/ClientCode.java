package com.example.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.example.model.User;
import com.example.util.HibernateUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;


public class ClientCode {

	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			Object result = session.createNativeQuery("select version()", Entity.class).getSingleResult();
			System.out.println("Database version: " + result);
			User u = new User();
			u.setLastName("ak");
			session.persist(u);
			//Object result1 = session.createNativeQuery("select id, name, sal from Employee", Employee.class).list();
			Object result1 = session.createNativeQuery("select id, last_name, first_name, email, password from usert", User.class).list();
			System.out.println("List: " + result1);
			User u1 = session.getReference(User.class, 1);
			System.out.println("User : " + u1);
			
            List<Tuple> tuples = session.createNativeQuery("""
                    select id, last_name, first_name, email, password from usert
                    """, Tuple.class)
                .getResultList();
            System.out.println("tuples : " + tuples);
            
            Tuple tuple = tuples.get(0);
            long id = tuple.get("id", Number.class).longValue();
            String last_name = tuple.get("last_name", String.class);
            
            System.out.println("last_name : " + last_name);
            
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
}


