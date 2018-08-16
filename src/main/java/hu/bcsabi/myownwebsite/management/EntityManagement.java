package hu.bcsabi.myownwebsite.management;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Az {@code EntityManagement} osztály reprezentálja az adatbázissal való kapcsolat vezérlését.
 */
public class EntityManagement {

    /**
     * Az {@code EntityManagerFactory} objektum.
     */
    private static EntityManagerFactory entityManagerFactory;

    /**
     * Az entitásokat kezelő entitás menedzser objektum.
     */
    private static EntityManager entityManager;

    /**
     * Létrehozza az adatbázissal való kapcsolatot, a {@code entitiyManager} létrehozásával.
     * @param persistenceUnitName a persistence.xml megegtalálásához szükséges név.
     */
    public void createConnection(String persistenceUnitName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = entityManagerFactory.createEntityManager();
    }

    /**
     * Bezárja az adatbázissal való kapcsolatot.
     */
    public void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * Visszaadja az EntityManagerFactory-t.
     * @return EntityManagerFactory.
     */
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    /**
     * Beállítja az EntitiyManagerFactory-t.
     * @param entityManagerFactory az új EntityManagerFactory.
     */
    public void setEntityManagerFactory(EntityManagerFactory newEntityManagerFactory) {
        entityManagerFactory = newEntityManagerFactory;
    }

    /**
     * Visszaadja az EntityManager-t.
     * @return EntityManager.
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Beállítja az EntitiyManager-t.
     * @param entityManager az új EntityManager.
     */
    public void setEntityManager(EntityManager newEntityManager) {
        entityManager = newEntityManager;
    }
}