package co.com.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "response_exam")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseExamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_exam")
	private Long idExam;

	@OneToOne
	@JoinColumn(name = "user")
	private StudentEntity user;

	@Column(name = "request_one")
	private String requestOne;
	
	@Column(name = "request_two")
	private String requestTwo;
	
	@Column(name = "request_three")
	private String requestThree;
	
	@Column(name = "request_four")
	private String requestFour;
	
	@Column(name = "request_five")
	private String requestFive;
	
	@Column(name = "request_six")
	private String requestSix;
	
	@Column(name = "request_seven")
	private String requestSeven;
	
	@Column(name = "request_eight")
	private String requestEight;
	
	@Column(name = "request_nine")
	private String requestNine;
	
	@Column(name = "request_ten")
	private String requestTen;

}
