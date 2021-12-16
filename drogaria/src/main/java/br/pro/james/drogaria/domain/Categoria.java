package br.pro.james.drogaria.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Categoria extends GenericDomain{


	

	@NotBlank
    @NotNull
	@Column(length = 50)
    private String nome;
	
	

	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_codigo")
	private Produto produto;
	
	
	





}
