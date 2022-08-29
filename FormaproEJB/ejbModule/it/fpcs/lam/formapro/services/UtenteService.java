package it.fpcs.lam.formapro.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.fpcs.lam.formapro.entities.Utente;


@Stateless
public class UtenteService {
	@PersistenceContext(unitName = "Formapro")
	private EntityManager em;
	
    public UtenteService() {
    }
    
    public Utente checkCredentials(String usrn, String pwd) throws NonUniqueResultException {
		List<Utente> uList = new ArrayList<Utente>();
		try {
			uList = em.createNamedQuery("Utente.checkCredentials", Utente.class).setParameter(1, usrn).setParameter(2, pwd)
					.getResultList();
		} catch (PersistenceException e) {
			System.out.println("Impossibile verificare le credenziali utente");
		}
		if (uList.isEmpty())
			return null;
		else if (uList.size() == 1)
			return uList.get(0);
		throw new NonUniqueResultException("Piu' di un utente risulta registrato con le stesse credenziali");

	}
    
    
}
