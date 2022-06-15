package dao.api;

import java.util.List;

public interface ICRUD<T,ID> {
    T create(T item);
    List<T> getAll();
    T update(ID id,T iteam);
    void delete(ID id);
    T getById(ID id);

}
