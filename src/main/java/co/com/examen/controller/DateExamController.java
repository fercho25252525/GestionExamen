package co.com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.examen.request.DateExamRequest;
import co.com.examen.service.IDateExamService;

@RestController
@RequestMapping(value = "/V1/dateExam")
public class DateExamController implements BaseController{

	private final IDateExamService iDateExamService;

	@Autowired
	public DateExamController(IDateExamService iDateExamService) {
		this.iDateExamService = iDateExamService;
	}
	
	@PostMapping(value = "/saveDateExam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveResponseExam(@RequestBody DateExamRequest dateExamRequest) throws Exception{
		return basicResponseEntity(iDateExamService.saveDateExam(dateExamRequest), "OK");
	}
}
