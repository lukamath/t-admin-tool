package it.fpcs.lam.formapro.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.fpcs.lam.formapro.entities.Autorizzazione;


@Stateless
public class AutorizzazioneService {
	@PersistenceContext(unitName = "Formapro")
	private EntityManager em;

    public AutorizzazioneService() {
    }
    
    public Autorizzazione checkCredentials(String usrn, String pwd) throws NonUniqueResultException {
		List<Autorizzazione> authList = new ArrayList<Autorizzazione>();
		try {
			authList = em.createNamedQuery("Autorizzazione.checkCredentials", Autorizzazione.class).setParameter(1, usrn).setParameter(2, pwd)
					.getResultList();
		} catch (PersistenceException e) {
			System.out.println("Impossibile verificare le credenziali utente");
		}
		if (authList.isEmpty())
			return null;
		else if (authList.size() == 1)
			return authList.get(0);
		throw new NonUniqueResultException("Piu' di un utente risulta registrato con le stesse credenziali");

	}

}
