package many_to_many_mapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import many_to_one_mapping.Book;
import many_to_one_mapping.Library;

public class Demo {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c1 = new Course();
		c1.setName("Development");
		c1.setPrice(30000);
		Course c2 = new Course();
		c2.setName("Testing");
		c2.setPrice(25000);
		Course c3 = new Course();
		c3.setName("AIML");
		c3.setPrice(40000);
		
		List<Course> courses1 = new ArrayList<Course>();
		courses1.add(c1);
		courses1.add(c2);
		
		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(c2);
		courses2.add(c3);
		
		List<Course> courses3 = new ArrayList<Course>();
		courses3.add(c1);
		courses3.add(c3);
		
		Student s1 = new Student();
		s1.setName("abc");
		s1.setAge(21);
		s1.setCourses(courses1);
		
		Student s2 = new Student();
		s2.setName("mno");
		s2.setAge(25);
		s2.setCourses(courses2);
		
		Student s3 = new Student();
		s3.setName("xyz");
		s3.setAge(24);
		s3.setCourses(courses3);
		
		try {
			et.begin();
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(s1);
			em.persist(s2);
			em.persist(s3);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
