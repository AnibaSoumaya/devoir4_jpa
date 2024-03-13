package com.soumaya.test;

import com.soumaya.dao.ChaussureDao;
import com.soumaya.entities.Chaussure;

public class Chaussuretest {

	public static void main(String[] args) {
		// créer un objet client
		Chaussure c = new Chaussure();
		c.setNomChauss("addidas");
		c.setPrix(260);
		
		Chaussure c1 = new Chaussure();
		c1.setNomChauss("nike");
		c1.setPrix(510);
		
		// ajouter l'objet client à la BD
		ChaussureDao cltDao = new ChaussureDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c1);
		
		System.out.println("Appel de la méthode listerTous");
		for (Chaussure cl : cltDao.listerTous())
			System.out.println(cl);
		System.out.println("Appel de la méthode listerParNom");
		for (Chaussure cl : cltDao.listerParNom("add"))

			System.out.println(cl);

		// tester les autres méthodes de la classe ClientDao
	}
}
