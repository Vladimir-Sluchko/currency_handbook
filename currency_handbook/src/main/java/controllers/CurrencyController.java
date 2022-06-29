package controllers;

import dao.entity.Currency;
import dto.CurrencyCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.api.ICurrencyService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    private final ICurrencyService currencyService;

    public CurrencyController(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> getList(){
        return this.currencyService.getAll();
    }
    @GetMapping("/byName")
    public List<Currency> getListByName(@RequestParam("name") String name){
        return this.currencyService.getAll(name);
    }

    @GetMapping("{id}")
    //@RequestMapping(value = "{id}", method = RequestMethod.GET)// аналог @GetMapping
    public Currency get(@PathVariable Long id){
        return this.currencyService.getById(id);
    }
    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)// аналог @PostMapping
    public ResponseEntity<Currency> create(@RequestBody CurrencyCreate dto){
        return new ResponseEntity<>(this.currencyService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/version/{version}")
    public Currency update(@PathVariable Long id,@PathVariable Long version, @RequestBody CurrencyCreate dto){
        LocalDateTime lastUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(version), ZoneId.systemDefault());
        return this.currencyService.update(id,dto,lastUpdate);
    }
}
