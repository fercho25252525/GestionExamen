package co.com.examen.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.examen.entity.ExamEntity;
import co.com.examen.entity.QualificationQuestionEntity;
import co.com.examen.repository.IExamRepository;
import co.com.examen.repository.IQualificationQuestionrepository;
import co.com.examen.request.ExamRequest;
import co.com.examen.service.IExamService;

@Service
public class ExamServiceImpl implements IExamService {

	private final IExamRepository iExamRepository;

	private final IQualificationQuestionrepository iQualificationQuestionrepository;

	@Autowired
	public ExamServiceImpl(IExamRepository iExamRepository,
			IQualificationQuestionrepository iQualificationQuestionrepository) {
		this.iExamRepository = iExamRepository;
		this.iQualificationQuestionrepository = iQualificationQuestionrepository;
	}

	@Override
	public ExamEntity saveExam(ExamRequest examRequest) {

		Optional<ExamEntity> examId = iExamRepository.findById(examRequest.getNumeroPregunta());

		if (examId.isEmpty()) {
			ExamEntity examEntity = ExamEntity.builder().idQuestion(examRequest.getNumeroPregunta())
					.question("Pregunta N° " + examRequest.getNumeroPregunta() + ". " + examRequest.getPregunta())
					.optionOne(examRequest.getOpcionUno()).optionTwo(examRequest.getOpcionDos())
					.optionThree(examRequest.getOpcionTres()).optionFour(examRequest.getOpcionCuatro()).build();

			ExamEntity exam = iExamRepository.save(examEntity);
			QualificationQuestionEntity questionEntity = QualificationQuestionEntity.builder()
					.idExam(exam.getIdQuestion()).correctQuialification(examRequest.getRespuestaCorrecta()).build();
			iQualificationQuestionrepository.save(questionEntity);
			return exam;
		}
		return null;
	}

	@Override
	public List<ExamEntity> getExam() {
		List<ExamEntity> exam = iExamRepository.findAll();
		return exam;
	}

}
