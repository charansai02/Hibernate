package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookRetriveDemo {
	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//retrieve the book object
			Book b1=session.get(Book.class, 103);
			System.out.println("Book obj retrieved...");
			System.out.println(b1);
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
