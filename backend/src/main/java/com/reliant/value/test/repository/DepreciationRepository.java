package com.reliant.value.test.repository;
import com.reliant.value.test.model.Assets;
import com.reliant.value.test.model.Depreciation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepreciationRepository extends JpaRepository<Depreciation, Long> {

}
