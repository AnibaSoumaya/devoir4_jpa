package com.soumaya.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.soumaya.entities.Chaussure;
import com.soumaya.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class ChaussureDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Chaussure c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Chaussure c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Chaussure c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Chaussure consulter(Chaussure c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Chaussure> listerTous() {
		List<Chaussure> chauss = entityManager.createQuery("select c from Chaussure c").getResultList();

		return chauss;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Chaussure> listerParNom(String nom) {
		List<Chaussure> chauss = entityManager.createQuery("select c from Chaussure c where c.nomChauss like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();

		return chauss;
	}
}