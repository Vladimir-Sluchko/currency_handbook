package dao;

import dao.api.ICurrencyDao;
import dao.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public class CurrencyDao implements ICurrencyDao {
    @Override
    public Currency create(Currency currency) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();
        return currency;
    }

    @Override
    public List<Currency> getAll() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Currency> currencyList = entityManager.createQuery( "FROM Currency", Currency.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return currencyList;

    }

    @Override
    public Currency update(Long id, Currency currency, LocalDateTime dtUpdate) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Currency currencyUp = entityManager.find(Currency.class, id);
        if (currencyUp.getDateUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Обновление уже было сделано");
        }
        currencyUp.setCode(currency.getCode());
        currencyUp.setDescription(currency.getDescription());
        currencyUp.setName(currency.getName());

        entityManager.persist(currencyUp);
        entityManager.getTransaction().commit();
        entityManager.close();
        return currencyUp;
    }

    @Override
    public void delete(Long id, LocalDateTime dtUpdate) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Currency currency = entityManager.find(Currency.class, id);
        if (currency.getDateUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Обновление уже было сделано");
        }
        entityManager.remove(currency);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Currency getById(Long id) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Currency currency = entityManager.find(Currency.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return currency;
    }
}
