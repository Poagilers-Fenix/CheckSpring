package br.com.fiap.epictask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O nome não pode ficar em branco.")
	private String name;
	
	@Email(message="Insira um e-mail válido. Ex: google@gmail.com")
	@NotBlank(message="O e-mail não pode ficar vazio.")
	private String email;
	
	@Size(min = 8, message="A senha deve ter no mínimo 8 caracteres")
	private String pass;
	
	private int score;
}
