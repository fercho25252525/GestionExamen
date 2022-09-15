package co.com.examen.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.examen.entity.DateExamEntity;
import co.com.examen.repository.IDateExamRepository;
import co.com.examen.request.DateExamRequest;
import co.com.examen.service.IDateExamService;

@Service
public class DateExamServiceImpl implements IDateExamService{
	
	private final IDateExamRepository iDateExamRepository;

	@Autowired
	public DateExamServiceImpl(IDateExamRepository iDateExamRepository) {
		this.iDateExamRepository = iDateExamRepository;
	}

	@Override
	public Object saveDateExam(DateExamRequest dateExamRequest) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date fecha = formato.parse(dateExamRequest.getDate());
		DateExamEntity examEntity = DateExamEntity.builder()
				.date(fecha)
				.build();
		return iDateExamRepository.save(examEntity);
	}

}
