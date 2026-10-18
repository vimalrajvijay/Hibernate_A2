package one_to_many_mapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one_to_one_mapping.Car;
import one_to_one_mapping.Engine;

public class Demo {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e1 = new Employee();
		e1.setName("abc");
		e1.setSalary(10000);
		Employee e2 = new Employee();
		e2.setName("mno");
		e2.setSalary(15000);
		Employee e3 = new Employee();
		e3.setName("xyz");
		e3.setSalary(18000);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		Company c1 = new Company();
		c1.setName("Google");
		//Has-A
		c1.setEmployees(employees);
		
		try {
			et.begin();
			em.persist(e1);
			em.persist(e2);
			em.persist(e3);
			em.persist(c1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
