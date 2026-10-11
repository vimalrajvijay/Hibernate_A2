package quert_parameters;

import demo.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NameParameter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s "
				+ "where s.id = :stu_id and s.name = :stu_name";
		
		Query q = em.createQuery(jpql);
		
		q.setParameter("stu_id", 101);
		q.setParameter("stu_name", "ABC");
		
		Student s = (Student)q.getSingleResult();
		
		System.out.println(s);
	}
}
