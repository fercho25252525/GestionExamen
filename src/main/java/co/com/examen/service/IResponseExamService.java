package co.com.examen.service;

import java.util.List;

import co.com.examen.entity.ResponseExamEntity;
import co.com.examen.request.ResponseExamRequest;

public interface IResponseExamService {

	Object saveResponseExam(ResponseExamRequest responseExamRequest);
	
	List<ResponseExamEntity> getResponseExam(String user);
}
