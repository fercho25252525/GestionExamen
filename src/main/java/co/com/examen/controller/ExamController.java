package co.com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.examen.entity.ExamEntity;
import co.com.examen.request.ExamRequest;
import co.com.examen.service.IExamService;

@RestController
@RequestMapping(value = "/V1/exam")
public class ExamController implements BaseController {

	private final IExamService iExamService;

	@Autowired
	public ExamController(IExamService iExamService) {
		this.iExamService = iExamService;
	}

	@PostMapping(value = "/saveExam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveExam(@RequestBody ExamRequest examRequest) throws Exception {
		ExamEntity o = iExamService.saveExam(examRequest);
		if (o != null) {
			return basicResponseEntity(o, "OK");
		}
		return basicResponseEntity(null, "Ya se encuentra creada la pregunta " + examRequest.getNumeroPregunta());
	}

	@GetMapping(value = "/getExam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getExam() throws Exception {
		return basicResponseEntity(iExamService.getExam(), "OK");
	}
}
