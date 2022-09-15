package co.com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.examen.request.ResponseExamRequest;
import co.com.examen.service.IResponseExamService;

@RestController
@RequestMapping(value = "/V1/responseExam")
public class ResponseExamController implements BaseController{
	
	private final IResponseExamService iResponseExamService;

	@Autowired
	public ResponseExamController(IResponseExamService iResponseExamService) {
		this.iResponseExamService = iResponseExamService;
	}
	
	
	@PostMapping(value = "/saveResponseExam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveResponseExam(@RequestBody ResponseExamRequest responseExamRequest) throws Exception{
		return basicResponseEntity(iResponseExamService.saveResponseExam(responseExamRequest), "OK");
	}
	
	
	@GetMapping(value = "/getResponseExam/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getExam(@PathVariable String user) throws Exception {
		Object o = iResponseExamService.getResponseExam(user);
		if(o != null) {
			return basicResponseEntity(o, "OK");
		}
		return basicResponseEntity(null, "No se encontro el usuario del estudiante");
	}

}
