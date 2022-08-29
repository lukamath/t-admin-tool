package it.fpcs.lam.formapro.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.fpcs.lam.formapro.entities.Struttura;
import it.fpcs.lam.formapro.entities.Tirocinio;


@Stateless
@LocalBean
public class TirocinioService {
	@PersistenceContext(unitName = "Formapro")
	private EntityManager em;
	
    public TirocinioService() {
    }
    
    public List<Tirocinio> findTirociniByIscrizione(int idIscrizione){
		List<Tirocinio> tirocini = em
				.createQuery("Select t from Tirocinio t where t.id_iscrizione= :enrId", Tirocinio.class)
				.setHint("javax.persistence.cache.storeMode", "REFRESH").setParameter("enrId", idIscrizione).getResultList();
		if (tirocini.isEmpty())
			return null;
		else 
			return tirocini;
	}

}
