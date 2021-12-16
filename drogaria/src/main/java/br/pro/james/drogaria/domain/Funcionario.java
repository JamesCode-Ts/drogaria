package br.pro.james.drogaria.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario extends GenericDomain{
	
	
	@Column
	private String carteiraTrabalho;

	@Column
	private String dataAdmissao;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;
	
	
	 
}
