package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			Book b2=new Book(103,"Gulliver Travels 3");
			s.delete(b2);
			System.out.println("Book deleted");
			
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
