package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RoadTrackerPU");
	
	public EntityManager getConnection() {
		return emf.createEntityManager();
	}
	
}