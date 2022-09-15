package co.com.examen.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.examen.entity.QualificationEntity;
import co.com.examen.entity.ResponseExamEntity;
import co.com.examen.entity.StudentEntity;
import co.com.examen.repository.IExamRepository;
import co.com.examen.repository.IQualificationQuestionrepository;
import co.com.examen.repository.IQualificationRepository;
import co.com.examen.repository.IResponseExamRepository;
import co.com.examen.repository.IStudentRepository;
import co.com.examen.service.IQualificationService;

@Service
public class QualificationServiceImpl implements IQualificationService {

	private final IQualificationRepository iQualificationRepository;

	private final IQualificationQuestionrepository iQualificationQuestionrepository;

	private final IStudentRepository iStudentRepository;

	private final IResponseExamRepository iResponseExamRepository;

	private final IExamRepository iExamRepository;

	@Autowired
	public QualificationServiceImpl(IQualificationRepository iQualificationRepository,
			IQualificationQuestionrepository iQualificationQuestionrepository, IStudentRepository iStudentRepository,
			IResponseExamRepository iResponseExamRepository, IExamRepository iExamRepository) {
		this.iQualificationRepository = iQualificationRepository;
		this.iQualificationQuestionrepository = iQualificationQuestionrepository;
		this.iStudentRepository = iStudentRepository;
		this.iResponseExamRepository = iResponseExamRepository;
		this.iExamRepository = iExamRepository;
	}

	@Override
	public List<QualificationEntity> generatequalification() {
		iQualificationRepository.deleteAll();
		List<StudentEntity> studentEntity = iStudentRepository.findAll();
		

		long correct = 0;
		long countQuestions = iExamRepository.count();
		long score = 100 / countQuestions;
		long scoreFinal = 0;

		for (StudentEntity estuden : studentEntity) {
			QualificationEntity qualificationEntity = new QualificationEntity();
			
			Optional<ResponseExamEntity> responseExam = iResponseExamRepository.findByUser(estuden);
			if (!responseExam.isEmpty()) {

				if (responseExam.get().getRequestOne() != null && responseExam.get().getRequestOne()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 1))) {
					correct++;
					scoreFinal += score;
				} 

				if (responseExam.get().getRequestTwo() != null && responseExam.get().getRequestTwo()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 2))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestThree() != null && responseExam.get().getRequestThree()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 3))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestFour() != null && responseExam.get().getRequestFour()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 4))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestFive() != null && responseExam.get().getRequestFive()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 5))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestSix() != null && responseExam.get().getRequestSix()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 6))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestSeven() != null && responseExam.get().getRequestSeven()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 7))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestEight() != null && responseExam.get().getRequestEight()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 8))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestNine() != null && responseExam.get().getRequestNine()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 9))) {
					correct++;
					scoreFinal += score;
				} 
				
				if (responseExam.get().getRequestTen() != null && responseExam.get().getRequestFive()
						.equalsIgnoreCase(iQualificationQuestionrepository.getQualification((long) 10))) {
					correct++;
					scoreFinal += score;
				}

				qualificationEntity.setUser(estuden);
				qualificationEntity.setMenssage("Correctas: " + correct + " de " + countQuestions + " preguntas.");
				if(scoreFinal>= 98) {
					scoreFinal = 100;	
				}
				qualificationEntity.setValueQualification(scoreFinal);
				iQualificationRepository.save(qualificationEntity);

			} else {
				qualificationEntity.setUser(estuden);
				qualificationEntity.setMenssage("No se encontro prueba");
				qualificationEntity.setValueQualification(scoreFinal);
				iQualificationRepository.save(qualificationEntity);
			}

			iQualificationRepository.save(qualificationEntity);
			responseExam = null;
			correct = 0;
			scoreFinal = 0;
		}
		
		return iQualificationRepository.findAll();
	}

}
