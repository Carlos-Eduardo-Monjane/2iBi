package com.carlos.api_2ibi_challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "paises")
public class Country {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "capital")
	private String capital;

	@Column(name = "regiao")
	private String regiao;

	@Column(name = "sub_regiao")
	private String sub_regiao;

	@Column(name = "area")
	private Double area;


	public Country(String nome, String capital, String regiao, String sub_regiao, Double area) {
		this.nome = nome;
		this.capital = capital;
		this.regiao = regiao;
		this.sub_regiao = sub_regiao;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getSub_regiao() {
		return sub_regiao;
	}

	public void setSub_regiao(String sub_regiao) {
		this.sub_regiao = sub_regiao;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Country [area=" + area + ", capital=" + capital + ", id=" + id + ", nome=" + nome + ", regiao=" + regiao
				+ ", sub_regiao=" + sub_regiao + "]";
	}

	public Country() {
	}

	
}
	
