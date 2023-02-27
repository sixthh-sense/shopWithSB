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
    *
    * 기타 메소드 형태는 JPA 사이트에서 검색할 것
    * */
    List<Item> findByItemNm(String itemNm);
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    List<Item> findByPriceLessThan(Integer price);
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);



}
