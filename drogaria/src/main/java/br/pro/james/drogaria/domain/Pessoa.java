package br.pro.james.drogaria.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pessoa")
@Entity

public class Pessoa extends GenericDomain{
	
	
	
	@Column(name = "nome")
	@Size(min = 5, max = 50,message = "O nome deve conter no minimo 5 caracteres")
	@NotNull(message = "o campo nome não pode ser nulo")
	private String nome;
	
	
	
	
	@Column(name = "cpf")
	@Size(max = 14)
	@NotBlank(message ="O cpf não pode ser vazio")
	@NotNull(message = "o campo cpf não pode ser nulo")
	private String cpf;
	
	
	
	@Column(name = "rg")
	@Size(max = 12)
	@NotBlank(message ="O rg não pode ser vazio")
	@NotNull(message = "o campo rg não pode ser nulo")
	private String rg;
	
	
	
	
	@Column(name = "rua")
	@Size(max = 50)
	@NotBlank(message ="O rua não pode ser vazio")
	@NotNull(message = "o campo rua não pode ser nulo")
	private String rua;
	

	@Column(name = "numero")
	@NotNull(message = "o campo numero não pode ser nulo")
	private Short numero;
	
	
	@Column(name = "bairro")
	@Size(max = 30)
	@NotBlank(message ="O bairro não pode ser vazio")
	@NotNull(message = "o campo bairro não pode ser nulo")
	private String bairro;
	
	
	@Column(name = "cep")
	@Size(max = 10)
	@NotBlank(message ="O cep não pode ser vazio")
	@NotNull(message = "o campo cep não pode ser nulo")
	private String cep;
	
	@Column(name = "complemento")
	@Size(max = 10)
	@NotBlank(message ="O complemento não pode ser vazio")
	@NotNull(message = "o campo complemento não pode ser nulo")
	private String complemento;
	
	
	@Column(name = "telefone")
	@Size(max = 13)
	@NotBlank(message ="O telefone não pode ser vazio")
	@NotNull(message = "o campo telefone não pode ser nulo")
	private String telefone;

	@Column(name = "celular")
	@Size(max = 14)
	@NotBlank(message ="O celular não pode ser vazio")
	@NotNull(message = "o campo celular não pode ser nulo")
	private String celular;
	
	@Column(name = "email")
	@Size(max = 100)
	@NotBlank(message ="O email não pode ser vazio")
	@NotNull(message = "o campo email não pode ser nulo")
	private String email;
	
	
	   @OneToOne(mappedBy = "pessoa")
	   private Cliente cliente;
	   
	   
	   @OneToOne(mappedBy = "pessoa")
	   private Funcionario funcionario;
}