package important_annotations;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//@Entity
@Table(name = "employees")
public class Employee {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xyz")
//	@SequenceGenerator(name = "xyz", initialValue = 101, allocationSize = 1)
	private int id;
	@Column(name = "emp_name", length = 8)
	private String name;
	@Column(name = "emp_sal")
	private double sal;
	@Column(name = "emp_email", nullable = false, unique = true)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
