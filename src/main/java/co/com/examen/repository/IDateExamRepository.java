package co.com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.examen.entity.DateExamEntity;

@Repository
public interface IDateExamRepository extends JpaRepository<DateExamEntity, Long>{

}
