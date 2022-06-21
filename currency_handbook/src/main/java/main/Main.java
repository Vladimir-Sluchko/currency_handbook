package main;

import dao.CurrencyDao;
import dao.api.ICurrencyDao;
import dao.entity.Currency;
import service.CurrencyService;
import service.api.ICurrencyService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Currency currency1 = new Currency("update", "Грязные бабки2", "USD-T", LocalDateTime.now());
        //ICurrencyDao currencyDao = CurrencyDao.getInstance();
        //ICurrencyService currencyDao = CurrencyService.getInstance();

        //currencyDao.update(2l,currency1);
        //currencyDao.delete(2l);
        //currencyDao.create(currency1);
        //System.out.println("по id " + currencyDao.getById(2l));


        /*List<Currency> all = currencyDao.getAll();
        for (Currency currency : all) {
            System.out.println(currency.toString());
        }*/



    }
}
