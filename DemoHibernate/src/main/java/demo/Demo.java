package demo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("vimal");
		System.out.println(emf);
	}
}
