package dao.api;

import java.util.List;

public interface ICRUD<T,ID,D> {
    T create(T item);
    List<T> getAll();
    T update(ID id,T iteam,D date);
    void delete(ID id,D date);
    T getById(ID id);

}
