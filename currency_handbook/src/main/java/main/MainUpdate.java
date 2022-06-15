package main;

import dao.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class MainUpdate {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Currency currency = entityManager.find(Currency.class, 1l);
        //entityManager.persist(new Currency("USD","Грязные бабки", "USD-T", LocalDateTime.now()));
        currency.setCode("USDT");
        currency.setDateUpdate(LocalDateTime.now());
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
