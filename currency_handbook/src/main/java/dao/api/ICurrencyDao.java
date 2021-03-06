package dao.api;

import dao.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICurrencyDao extends JpaRepository<Currency,Long> {


    //@Query("Select.....") можно написать свой запрос
    List<Currency> findByName(String name);


    //Currency update(Long id, Currency currency, LocalDateTime dtUpdate);

    //void delete(Long id, LocalDateTime date);

}
