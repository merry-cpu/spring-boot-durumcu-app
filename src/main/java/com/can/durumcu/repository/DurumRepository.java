package com.can.durumcu.repository;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.Durum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DurumRepository extends JpaRepository<Durum, Long> {


    @Query("FROM Durum  WHERE name =:name")
    List<Durum> getByName(@Param("name") String name);

}
