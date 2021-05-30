package kodlamaio.northwind.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")   //9. ders

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	@Email //email olduğunu söyler,pom.xml'e spring-boot-starter-validation dependency'si eklendi
	@NotBlank //boş geçilemez kuralı koyar
	@NotNull //boş bırakılamaz kuralı koyar
	private String email;
	 
	@Column(name="password")
	@NotBlank //boş geçilemez kuralı koyar
	@NotNull //boş bırakılamaz kuralı koyar
	private String password;
}
