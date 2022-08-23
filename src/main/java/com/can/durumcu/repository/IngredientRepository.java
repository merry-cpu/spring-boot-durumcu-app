package com.can.durumcu.repository;

import com.can.durumcu.entity.Durum;
import com.can.durumcu.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Modifying
    @Query(value = "insert into  (id,name) values (:id, :name)",nativeQuery = true)
    void add(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query("UPDATE Ingredient SET name=:name WHERE id=:id")
    int update(@Param("id") Long id, @Param("name") String name);

    @Query("DELETE FROM Ingredient WHERE id=:id")       // it will delete all the record with specific name
    int delete(@Param("id") Long id);

    @Query("FROM Ingredient  WHERE name =:name")
    List<Ingredient> getByName(@Param("name") String name);

}




