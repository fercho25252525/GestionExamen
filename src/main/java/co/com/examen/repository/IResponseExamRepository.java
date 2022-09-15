package co.com.examen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.examen.entity.ResponseExamEntity;
import co.com.examen.entity.StudentEntity;

public interface IResponseExamRepository extends JpaRepository<ResponseExamEntity, Long>{
	
	
	Optional<ResponseExamEntity> findByUser(StudentEntity user);

}
