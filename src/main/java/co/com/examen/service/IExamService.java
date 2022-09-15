package co.com.examen.service;

import java.util.List;

import co.com.examen.entity.ExamEntity;
import co.com.examen.request.ExamRequest;

public interface IExamService {

	ExamEntity saveExam(ExamRequest examRequest);
	
	List<ExamEntity> getExam();
}
