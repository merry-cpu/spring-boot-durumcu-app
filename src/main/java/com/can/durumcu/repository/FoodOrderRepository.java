package com.can.durumcu.repository;

import com.can.durumcu.entity.Durum;
import com.can.durumcu.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

    @Modifying
    @Query(value = "insert into  (name) values (:name)",nativeQuery = true)
    void add( @Param("name") String name);


}
