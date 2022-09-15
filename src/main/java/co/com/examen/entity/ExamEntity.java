package co.com.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamEntity {
	
	@Id
	@Column(name = "id_question")	
	private Long idQuestion;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "opcion_one")
	private String optionOne;
	
	@Column(name = "option_two")
	private String optionTwo;
	
	@Column(name = "option_three")
	private String optionThree;
	
	@Column(name = "option_four")
	private String optionFour;

}
