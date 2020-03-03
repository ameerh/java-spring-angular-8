package com.reliant.value.test.repository;
import com.reliant.value.test.model.Assets;
import com.reliant.value.test.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

}
