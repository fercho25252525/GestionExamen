package co.com.examen.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.examen.entity.ResponseExamEntity;
import co.com.examen.entity.StudentEntity;
import co.com.examen.repository.IExamRepository;
import co.com.examen.repository.IResponseExamRepository;
import co.com.examen.repository.IStudentRepository;
import co.com.examen.request.ResponseExamRequest;
import co.com.examen.service.IResponseExamService;

@Service
public class ResponseExamServiceImpl implements IResponseExamService {
	
	private final IResponseExamRepository iResponseExamRepository;
	
	private final IStudentRepository iStudentRepository;
	
	private final IExamRepository iExamRepository;
	
	@Autowired
	public ResponseExamServiceImpl(IResponseExamRepository iResponseExamRepository, IStudentRepository iStudentRepository, IExamRepository iExamRepository) {
		this.iResponseExamRepository = iResponseExamRepository;
		this.iStudentRepository = iStudentRepository;
		this.iExamRepository = iExamRepository;
	}

	@Override
	public Object saveResponseExam(ResponseExamRequest responseExamRequest) {
		
		ResponseExamEntity responseExam = new ResponseExamEntity();
		Optional<StudentEntity> student = iStudentRepository.findById(responseExamRequest.getUser());
//		long countQuestions = iExamRepository.count();
		
		
		
		responseExam.setUser(student.get());
		responseExam.setRequestOne(responseExamRequest.getQuestionOne());
		responseExam.setRequestTwo(responseExamRequest.getQuestionTwo());
		responseExam.setRequestThree(responseExamRequest.getQuestionThree());
		responseExam.setRequestFour(responseExamRequest.getQuestionFour());
		responseExam.setRequestFive(responseExamRequest.getQuestionFive());
		responseExam.setRequestSix(responseExamRequest.getQuestionSix());
		responseExam.setRequestSeven(responseExamRequest.getQuestionSeven());
		responseExam.setRequestEight(responseExamRequest.getQuestionEight());
		responseExam.setRequestNine(responseExamRequest.getQuestionNine());
		responseExam.setRequestTen(responseExamRequest.getQuestionTen());
	
		
		
		return iResponseExamRepository.save(responseExam);
	}

	@Override
	public List<ResponseExamEntity> getResponseExam(String user) {
		Optional<StudentEntity> student = iStudentRepository.findById(user);
		Optional<ResponseExamEntity> students = iResponseExamRepository.findByUser(student.get());
		if(!students.isEmpty()) {
			return iResponseExamRepository.findAll();
		}
		return null;
	}

}
