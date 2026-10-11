package dirty_checking;

import demo.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RefreshMethod {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = em.find(Student.class, 101);// Managed state
		s1.setName("BCD");
		System.out.println(s1.getName());
		try {
			et.begin();
			em.refresh(s1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		System.out.println(s1.getName());
	}
}
