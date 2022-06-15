package service;

import dao.CurrencyDao;
import dao.api.ICurrencyDao;
import dao.entity.Currency;

import service.api.ICurrencyService;

import java.time.LocalDateTime;
import java.util.List;

public class CurrencyService implements ICurrencyService{
    private static final CurrencyService instance = new CurrencyService();
    ICurrencyDao currencyDao = CurrencyDao.getInstance();

    @Override
    public Currency create(Currency currency) {
        if (currency.getCode() != null & currency.getDescription() != null & currency.getName() != null){
            currency.setDateUpdate(LocalDateTime.now());
            currency.setDateCreat(LocalDateTime.now());
            currencyDao.create(currency);
        } else throw new IllegalArgumentException("Переданы неправильные данные");
        return currency;
    }

    @Override
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }

    @Override
    public Currency update(Long id, Currency currency) {
        if (currency.getCode() != null & currency.getDescription() != null & currency.getName() != null & id>0){
            currency.setDateUpdate(LocalDateTime.now());
            currencyDao.update(id,currency);
        } else throw new IllegalArgumentException("Переданы неправильные данные");
        return null;
    }

    @Override
    public void delete(Long id) {
        if(id>0){
            currencyDao.delete(id);
        } else throw new IllegalArgumentException("Неверный id");

    }

    @Override
    public Currency getById(Long id) {
        if(id<=0){
            throw new IllegalArgumentException("Неверный id");
        } else return currencyDao.getById(id);
    }

    public static CurrencyService getInstance(){
        return instance;
    }
}
