package co.com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.examen.request.StudentRequest;
import co.com.examen.service.IStudentService;

@RestController
@RequestMapping(value = "/V1/students")
public class StudentController implements BaseController{
	
	private final IStudentService iStudentService;

	@Autowired
	public StudentController(IStudentService iStudentService) {
		this.iStudentService = iStudentService;
	}
	
	@PostMapping(value = "/saveStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveStudent(@RequestBody StudentRequest studentRequest) throws Exception {
		Object o = iStudentService.saveStudent(studentRequest);
		if(o != null) {
			return basicResponseEntity(o, "OK");
		}
		return basicResponseEntity(null, "El usuario ya existe");
	}
	
	

}
