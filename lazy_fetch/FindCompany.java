package lazy_fetch;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindCompany {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
		Company c1 = em.find(Company.class, 1);
		System.out.println(c1);
		System.out.println(c1.getEmployees());
	}
}
