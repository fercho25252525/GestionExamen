package co.com.examen.request;

import lombok.Data;

@Data
public class ExamRequest {
	
	private Long numeroPregunta;

	private String pregunta;
	
	private String opcionUno;
	
	private String opcionDos;
	
	private String opcionTres;
	
	private String opcionCuatro;
	
	private String respuestaCorrecta;
}
