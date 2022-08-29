package it.fpcs.lam.formapro.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.fpcs.lam.formapro.entities.Edizione;

@Stateless
@LocalBean
public class EdizioneService {
	@PersistenceContext(unitName = "Formapro")
	private EntityManager em;


    public EdizioneService() {
    }
    
    
    public List<Edizione> findAllEditions() throws PersistenceException  {
    	List<Edizione> edizioni = null;
		try {
			edizioni=em.createNamedQuery("Edizione.findAll", Edizione.class).getResultList();		
		} catch (PersistenceException e){
			System.out.println("Could not find All Editions");
		}
		return edizioni;
    }
    
    public Edizione findEditionDetailsById(int edizioneid) throws PersistenceException {
    	List<Edizione> edizioni = em
	    	.createQuery("Select e from Edizione e where e.idEdizione= :edId", Edizione.class)
			.setHint("javax.persistence.cache.storeMode", "REFRESH").setParameter("edId", edizioneid).getResultList();
		if (edizioni.isEmpty())
			return null;
		else if (edizioni.size() == 1)
			return edizioni.get(0);
		throw new NonUniqueResultException("More than one customer registered with same credentials");
    }
    
    public Edizione findCourseByEdition(int edizioneid) throws PersistenceException {
    	List<Edizione> edizioni = em
    	    	.createQuery("Select e from Edizione e where e.idEdizione= :edId", Edizione.class)
    			.setHint("javax.persistence.cache.storeMode", "REFRESH").setParameter("edId", edizioneid).getResultList();
    		if (edizioni.isEmpty())
    			return null;
    		else if (edizioni.size() == 1)
    			return edizioni.get(0);
		throw new NonUniqueResultException("More than one customer registered with same credentials");
    }
    
    
}
