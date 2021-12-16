package br.pro.james.drogaria.domain;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Produto extends GenericDomain {
	
	
	
	@NotBlank
	@NotNull
	@Column(length = 50)
	private String descricao;
	
	@Column
	@NotNull
	private Byte quantidade;
	
	@NotNull
	@Column(precision = 5, scale =2)
	private BigDecimal preco;
	
	@Column
	@NotNull
	private String dataDeValidade;
	
	@OneToOne(mappedBy = "produto")
	@JoinColumn(name="categoria_codigo")
    private Categoria categoria;
	
	
	



}