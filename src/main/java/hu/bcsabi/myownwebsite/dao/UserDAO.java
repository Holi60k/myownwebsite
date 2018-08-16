package hu.bcsabi.myownwebsite.dao;

import javax.persistence.EntityManager;

import hu.bcsabi.myownwebsite.management.EntityManagement;
import hu.bcsabi.myownwebsite.validation.Credentials;

public class UserDAO {

    private static final EntityManager entityManager = new EntityManagement().getEntityManager();

    public UserDAO() {

    }

    /**
     * A függvény ellenőrzi, hogy a bejelentkezési adatok helyesek-e.
     *
     * @param credentials az aktuális bejelentkezési adatok.
     * @return boolean érték, amely azt mutatja, hogy a bejelentkezési adatok érvényesek-e vagy sem.
     */
    public boolean userIsValid(Credentials credentials) {
        return !entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
                .setParameter("username", credentials.getUsername())
                .setParameter("password", credentials.getPassword())
                .getResultList()
                .isEmpty();
    }


}