package main;

import dao.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class MainCreate {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //entityManager.persist();
        entityManager.persist(new Currency("EUR","Грязные бабки", "USD-T", LocalDateTime.now()));
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
