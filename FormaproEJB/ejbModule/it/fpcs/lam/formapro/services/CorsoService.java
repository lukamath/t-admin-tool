package it.fpcs.lam.formapro.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.fpcs.lam.formapro.entities.Corso;

@Stateless
@LocalBean
public class CorsoService {
	@PersistenceContext(unitName = "Formapro")
	private EntityManager em;

    public CorsoService() {
    }

    public String findCorsoByEditionId(int edizioneid) throws PersistenceException {
    	List<String> nomec1 = em
				.createQuery("Select e.id_corso from Edizione e WHERE e.id_edizione=:edId", String.class)
				.setHint("javax.persistence.cache.storeMode", "REFRESH").setParameter("edId", edizioneid).getResultList();
	    if (nomec1.isEmpty())
			return null;
		else if (nomec1.size() == 1)
			return (String) nomec1.get(0);
		throw new NonUniqueResultException("More than one customer registered with same credentials");
    }
    
    public Corso findCorsoById(int idc) throws PersistenceException {
    	List<Corso> nomec = em
				.createQuery("Select c from Corso c WHERE c.idCorso=:corsoId", Corso.class)
				.setHint("javax.persistence.cache.storeMode", "REFRESH").setParameter("corsoId", idc).getResultList();
	    if (nomec.isEmpty())
			return null;
		else if (nomec.size() == 1)
			return nomec.get(0);
		throw new NonUniqueResultException("More than one customer registered with same credentials");
    }
    
}
