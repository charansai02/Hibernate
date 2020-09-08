package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookUpdateDemo {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			Book b1=new Book();
			b1.setBook_id(101);
			b1.setBook_name("Lizards");
			s.update(b1);
			System.out.println("Book updated");
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			sf.close();
			s.close();
		}
	}
}
