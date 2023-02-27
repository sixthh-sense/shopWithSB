package demo.mall.repository;

import demo.mall.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
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

    // %itemDetail%이 아니라 %:itemDetail% -> : 콜론에 무슨 의미가 있는 걸까?
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // native query : Item -> item, i -> *
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

    /* QueryDslPredicateExecutor 메소드 일람
    *  long count(Predicate)
    * boolean exists(Predicate)
    * Iterable findAll(Predicate)
    * Page<T> findAll(Predicate, Pageable)
    * Iterable findAll(Predicate, Sort)
    * T findOne(Predicate)
    * */
}
