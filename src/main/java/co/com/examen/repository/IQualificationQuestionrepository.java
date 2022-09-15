package co.com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.examen.entity.QualificationQuestionEntity;

public interface IQualificationQuestionrepository extends JpaRepository<QualificationQuestionEntity, Long>{
	
//	QualificationQuestionEntity findByIdExam();
	
	@Query("SELECT q.correctQuialification FROM QualificationQuestionEntity q WHERE q.idExam=:idExam")
	String getQualification(Long idExam);

}
