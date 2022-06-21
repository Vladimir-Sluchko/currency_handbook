package service;

import dao.CurrencyDao;
import dao.api.ICurrencyDao;
import dao.entity.Currency;

import dto.CurrencyCreate;
import org.springframework.stereotype.Service;
import service.api.ICurrencyService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CurrencyService implements ICurrencyService {
    private final ICurrencyDao currencyDao;

    public CurrencyService(ICurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public Currency create(CurrencyCreate currencyCreate) {
        if (currencyCreate.getCode() == null & currencyCreate.getDescription() == null & currencyCreate.getName() == null) {
            throw new IllegalArgumentException("Переданы неправильные данные");
        }
            Currency currency = new Currency();
            currency.setDateUpdate(LocalDateTime.now());
            currency.setDateCreate(LocalDateTime.now());
            currency.setName(currencyCreate.getName());
            currency.setCode(currencyCreate.getCode());
            currency.setDescription(currencyCreate.getDescription());

            return this.currencyDao.create(currency);
    }

    @Override
    public List<Currency> getAll() {
        return this.currencyDao.getAll();
    }

    @Override
    public Currency update(Long id, CurrencyCreate currencyCreate, LocalDateTime dtUpdate) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Неверный id");
        }
        if (currencyCreate.getCode() == null & currencyCreate.getDescription() == null & currencyCreate.getName() == null) {
            throw new IllegalArgumentException("Переданы неправильные данные");
        }
        Currency currency = new Currency();
        currency.setName(currencyCreate.getName());
        currency.setCode(currencyCreate.getCode());
        currency.setDescription(currencyCreate.getDescription());

        this.currencyDao.update(id,currency,dtUpdate);

        return this.currencyDao.getById(id);
    }

    @Override
    public void delete(Long id,LocalDateTime date) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Неверный id");
        }
            this.currencyDao.delete(id,date);
    }

    @Override
    public Currency getById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Неверный id");
        }
        return this.currencyDao.getById(id);
    }
}


