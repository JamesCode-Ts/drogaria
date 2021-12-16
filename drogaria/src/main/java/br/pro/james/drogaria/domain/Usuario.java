package br.pro.james.drogaria.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario extends GenericDomain {


	
	@Column
	@NotBlank
	@NotNull
	private String username;
	
	@NotBlank
	@NotNull
	@Column(length = 32, nullable = false)
	private String senha;
	
	
	
	
}
