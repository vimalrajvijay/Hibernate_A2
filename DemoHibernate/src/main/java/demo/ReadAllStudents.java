package demo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ReadAllStudents {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s";
		Query q = em.createQuery(jpql);
		
		List<Student> students =  q.getResultList();
		
		System.out.println(students);
	}
}
