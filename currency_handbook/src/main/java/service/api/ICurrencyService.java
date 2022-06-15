package service.api;

import dao.api.ICurrencyDao;
import dao.entity.Currency;

import java.util.List;

public interface ICurrencyService extends ICurrencyDao{
    @Override
    Currency create(Currency currency);

    @Override
    List<Currency> getAll();

    @Override
    Currency update(Long id, Currency currency);

    @Override
    void delete(Long id);

    @Override
    Currency getById(Long id);
}
