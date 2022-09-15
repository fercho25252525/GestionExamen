package co.com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.examen.service.IQualificationService;

@RestController
@RequestMapping(value = "/V1/Qualification")
public class QualificationController implements BaseController{
	
	private final IQualificationService iQualificationService;

	@Autowired
	public QualificationController(IQualificationService iQualificationService) {
		this.iQualificationService = iQualificationService;
	}
	
	@GetMapping(value = "/generateQualification", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> generateQualification() throws Exception {
		
		return basicResponseEntity(iQualificationService.generatequalification(),"OK");
	}

}
