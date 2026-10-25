package cache_memory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p1 = new Product();
		p1.setName("shampoo");
		p1.setPrice(200);
		
		try {
			et.begin();
			em.persist(p1);
			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			et.rollback();
			e.printStackTrace();
		}
	}
}
