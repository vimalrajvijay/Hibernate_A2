package dirty_checking;

import demo.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DirtyChecking {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = em.find(Student.class, 101);// Managed state
		
		try {
			et.begin();
			s1.setAge(30);
			et.commit(); // Update Query
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
