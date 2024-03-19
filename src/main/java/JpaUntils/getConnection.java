package JpaUntils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class getConnection {
private static EntityManagerFactory  factory;
	
	public static void main(String[] args) {
		getEntityManger();
		
	}
	
	
	public static EntityManager getEntityManger() {
		factory = Persistence.createEntityManagerFactory("asmjava4PU");
		return factory.createEntityManager();
	}
}
