package dao.api;

import dao.entity.Currency;

import java.time.LocalDateTime;
import java.util.List;

public interface ICurrencyDao extends ICRUD<Currency,Long,LocalDateTime> {
    @Override
    Currency create(Currency currency);

    @Override
    List<Currency> getAll();

    @Override
    Currency update(Long id, Currency currency, LocalDateTime dtUpdate);

    @Override
    void delete(Long id, LocalDateTime date);

    @Override
    Currency getById(Long id);
}
