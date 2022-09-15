package co.com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.examen.entity.StudentEntity;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, String>{

}
