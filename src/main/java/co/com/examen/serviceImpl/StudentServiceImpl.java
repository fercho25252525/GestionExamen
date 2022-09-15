package co.com.examen.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.examen.entity.StudentEntity;
import co.com.examen.repository.IStudentRepository;
import co.com.examen.request.StudentRequest;
import co.com.examen.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	
	private final IStudentRepository iStudentRepository;	
	
	@Autowired
	public StudentServiceImpl(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	@Override
	public Object saveStudent(StudentRequest studentRequest) {
		Optional<StudentEntity> usuario = iStudentRepository.findById(studentRequest.getUsuario());
		if(usuario.isEmpty()) {
			StudentEntity student = StudentEntity.builder()
					.user(studentRequest.getUsuario())
					.name(studentRequest.getNombre())
					.age(studentRequest.getEdad())
					.city(studentRequest.getCiudad())
					.timeZone(studentRequest.getZonaHoraria())
					.build();
			return iStudentRepository.save(student);
		}
		return null;
	}
}
