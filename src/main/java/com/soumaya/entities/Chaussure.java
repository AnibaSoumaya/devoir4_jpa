package com.soumaya.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chaussure implements Serializable{

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	
	private Long idChauss;
	private String nomChauss;
	private double prix;
	
	public Chaussure() {
	super();
	}

	public Long getIdChauss() {
		return idChauss;
	}

	public void setIdChauss(Long idChauss) {
		this.idChauss = idChauss;
	}

	public String getNomChauss() {
		return nomChauss;
	}

	public void setNomChauss(String nomChauss) {
		this.nomChauss = nomChauss;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Chaussure [idChauss=" + idChauss + ", nomChauss=" + nomChauss + ", prix=" + prix + "]";
	}

}

