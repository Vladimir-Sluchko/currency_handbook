package controllers;

import dao.entity.Currency;
import dto.CurrencyCreate;
import org.springframework.web.bind.annotation.*;
import service.api.ICurrencyService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final ICurrencyService currencyService;

    public CurrencyController(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> getList(){
        return this.currencyService.getAll();
    }

    @GetMapping("{id}")
    //@RequestMapping(value = "{id}", method = RequestMethod.GET)// аналог @GetMapping
    public Currency get(@PathVariable Long id){
        return this.currencyService.getById(id);
    }
    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)// аналог @PostMapping
    public Currency create(@RequestBody CurrencyCreate dto){
        return this.currencyService.create(dto);
    }

    @PutMapping("/{id}/version/{version}")
    public Currency update(@PathVariable Long id,@PathVariable Long version, @RequestBody CurrencyCreate dto){
        LocalDateTime lastUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(version), ZoneId.systemDefault());
        return this.currencyService.update(id,dto,lastUpdate);
    }
}
