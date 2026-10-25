package cache_memory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		Product p1 = em1.find(Product.class, 1);
		Product p2 = em2.find(Product.class, 1);
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
