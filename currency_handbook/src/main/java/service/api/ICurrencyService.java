package service.api;

import dao.api.ICurrencyDao;
import dao.entity.Currency;
import dto.CurrencyCreate;

import java.time.LocalDateTime;
import java.util.List;

public interface ICurrencyService {

    Currency create(CurrencyCreate currency);

    List<Currency> getAll();
    List<Currency> getAll(String name);


    Currency update(Long id, CurrencyCreate currencyCreate, LocalDateTime dtUpdate);


    //void delete(Long id,LocalDateTime date);


    Currency getById(Long id);
}
