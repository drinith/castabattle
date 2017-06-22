package com.castaware.castabattle.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HighScore 
{
	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String jogador;
	
	@Column
	private Integer pontos;
	
	@Column(columnDefinition="TIMESTAMP")
	private Date data1;
	
	@Column(columnDefinition="DATE")
	private Date data2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public Date getData1() {
		return data1;
	}
	public void setData1(Date data1) {
		this.data1 = data1;
	}
	public Date getData2() {
		return data2;
	}
	public void setData2(Date data2) {
		this.data2 = data2;
	}
}
