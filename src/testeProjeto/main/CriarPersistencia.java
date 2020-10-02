package testeProjeto.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarPersistencia {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("luiz");
	
	public EntityManager entityManager() {
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

}
