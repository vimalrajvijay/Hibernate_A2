package one_to_many_many_to_one_bi;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Demo {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Library l1 = new Library();
		l1.setName("Qspiders");
		
		Book b1 = new Book();
		b1.setTitle("Java");
		b1.setPrice(5000);
		
		Book b2 = new Book();
		b2.setTitle("Python");
		b2.setPrice(2500);
		
		Book b3 = new Book();
		b3.setTitle("c#");
		b3.setPrice(2000);
		
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		b1.setLibrary(l1);
		b2.setLibrary(l1);
		b3.setLibrary(l1);
		
		l1.setBooks(books);
		
		try {
			et.begin();
			em.persist(l1);
			em.persist(b1);
			em.persist(b2);
			em.persist(b3);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
