package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// create session from session factory
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			// create transaction
			tx = session.beginTransaction();
			// create book
			Book b1 = new Book();
			b1.setBook_id(101);
			b1.setBook_name("Gulliver Travels 5");
			// save book
			Integer res=(Integer)session.save(b1);
			System.out.println("Result = "+res);
			// commit the transaction
			tx.commit();
			System.out.println("Saved...");
		} catch (Exception e) {
			//if transaction is not done, rollback
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			//close session
			session.close();
			//close session factory
			sf.close();
		}
	}
}
