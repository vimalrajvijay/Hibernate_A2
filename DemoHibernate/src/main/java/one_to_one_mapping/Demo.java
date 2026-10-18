package one_to_one_mapping;

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
		Engine e1 = new Engine();
		e1.setType("Petrol");
		e1.setHp(1200);	
		Car c1 = new Car();
		c1.setBrand("BMW");
		c1.setPrice(15000);
		//Has-A
		c1.setEngine(e1);	
		try {
			et.begin();
			em.persist(e1);
			em.persist(c1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
