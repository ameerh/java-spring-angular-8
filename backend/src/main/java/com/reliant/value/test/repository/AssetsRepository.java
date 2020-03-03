package com.reliant.value.test.repository;
import com.reliant.value.test.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, Long> {

}
