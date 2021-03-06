package controllers.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) ///400  ошибка
    public List<Map<String,Object>> handle(IllegalArgumentException e){
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("logref","error");
        map.put("message",e.getMessage());
        data.add(map);
        return data;
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) //500 ошибка
    public List<Map<String,Object>> handle(IllegalStateException e){
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("logref","error");
        map.put("message",e.getMessage());
        data.add(map);
        return data;
    }
    @ExceptionHandler
    public List<Map<String,Object>> handle(Exception e){
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("logref","error");
        map.put("message",e.getMessage());
        data.add(map);
        return data;
    }
}
