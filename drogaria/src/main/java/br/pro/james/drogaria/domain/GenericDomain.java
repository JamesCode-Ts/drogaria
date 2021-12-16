package br.pro.james.drogaria.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;



@Data
@MappedSuperclass
public class GenericDomain {

	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Short codigo;
	
}
