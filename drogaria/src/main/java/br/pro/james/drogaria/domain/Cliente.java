package br.pro.james.drogaria.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Cliente extends GenericDomain {

	
	
	
	
	@Column
	private String dataCadastro;
	
	
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "codigo_pessoa")
		private Pessoa pessoa;
	    
	  
	    

}
