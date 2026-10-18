package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindStudent {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		Student s1 = em.find(Student.class, 102);
		System.out.println(s1);
	}
}
