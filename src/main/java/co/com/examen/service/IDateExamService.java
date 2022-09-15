package co.com.examen.service;

import java.text.ParseException;

import co.com.examen.request.DateExamRequest;

public interface IDateExamService {
	
	Object saveDateExam(DateExamRequest dateExamRequest) throws ParseException;

}
