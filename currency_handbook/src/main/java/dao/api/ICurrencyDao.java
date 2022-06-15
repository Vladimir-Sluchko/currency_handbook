package dao.api;

import dao.entity.Currency;

import java.util.List;

public interface ICurrencyDao extends ICRUD<Currency,Long> {
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
