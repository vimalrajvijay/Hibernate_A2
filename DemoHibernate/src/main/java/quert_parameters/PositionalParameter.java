package quert_parameters;

import demo.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PositionalParameter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s where s.id = ?1 and s.name = ?2";
		
		Query q = em.createQuery(jpql);
		
		q.setParameter(1, 101);
		q.setParameter(2, "ABC");
		
		Student s = (Student)q.getSingleResult();
		
		System.out.println(s);
	}
}
