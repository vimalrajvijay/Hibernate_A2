package important_annotations;

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
		
//		Employee e1 = em.find(Employee.class, 101);
		
		Employee e1 = new Employee();
		e1.setName("ABCDEF");
		e1.setSal(10000);
		e1.setEmail("xyz@gmail.com");
//		
		try {
			et.begin();
//			e1.setSal(15000);
			em.persist(e1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
