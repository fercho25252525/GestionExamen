package co.com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.examen.entity.ExamEntity;

public interface IExamRepository extends JpaRepository<ExamEntity, Long>{

}
