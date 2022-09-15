package co.com.examen.request;

import lombok.Data;

@Data
public class StudentRequest {
	
	private String usuario;

	private String nombre;

	private String edad;

	private String ciudad;

	private String zonaHoraria;
	
	private String  dateExam;

}
