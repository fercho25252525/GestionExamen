package co.com.examen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.examen.response.BaseResponse;

public interface BaseController {

	public default ResponseEntity<?> basicResponseEntity(Object o, String menssage) throws Exception {
		return new ResponseEntity<>(BaseResponse.builder()
				.code((long) 1)
				.data(o)
				.menssge(menssage)
				.build(),
				HttpStatus.OK);
	}
}
