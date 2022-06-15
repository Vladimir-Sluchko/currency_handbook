package dao;

import dao.api.ICurrencyDao;
import dao.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;

public class CurrencyDao implements ICurrencyDao {
    private final static CurrencyDao instance = new CurrencyDao();

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
        List<Currency> currencyList = entityManager.createQuery( "from Currency", Currency.class ).getResultList();
        entityManager.getTransaction().commit();
        return currencyList;

    }

    @Override
    public Currency update(Long id, Currency currency) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Currency currencyUp = entityManager.find(Currency.class, id);
        currencyUp.setDateUpdate(currency.getDateUpdate());
        currencyUp.setCode(currency.getCode());
        currencyUp.setDescription(currency.getDescription());
        currencyUp.setName(currency.getName());
        entityManager.persist(currencyUp);
        entityManager.getTransaction().commit();
        return currencyUp;
    }

    @Override
    public void delete(Long id) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Currency currency = entityManager.find(Currency.class, id);
        entityManager.remove(currency);
        entityManager.getTransaction().commit();
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
    public static CurrencyDao getInstance(){
        return instance;
    }
}
