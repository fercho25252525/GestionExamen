package co.com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.examen.entity.QualificationEntity;

@Repository
public interface IQualificationRepository extends JpaRepository<QualificationEntity, Long>{

}
