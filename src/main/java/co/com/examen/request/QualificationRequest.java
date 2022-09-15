package co.com.examen.request;

import co.com.examen.entity.StudentEntity;
import lombok.Data;

@Data
public class QualificationRequest {

	private Long id;

	private StudentEntity user;

	private Long valueQualification;

	private String menssage;
}
