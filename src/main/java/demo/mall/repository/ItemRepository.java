package demo.mall.repository;

import demo.mall.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    /*
    * <S extends T> save(S entity)
    * void delete(T entity)
    * count()
    * Iterable<T> findAll()
    * */
    List<Item> findByItemNm(String itemNm);
}
