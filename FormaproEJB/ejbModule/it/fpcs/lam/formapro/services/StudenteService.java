package it.fpcs.lam.formapro.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import it.fpcs.lam.formapro.entities.Studente;


@Stateless
public class StudenteService {
	@PersistenceContext(unitName = "Formapro")
	private EntityManager em;

    public StudenteService() {
    }
    
    public List<Studente> findStudentsByEdition(int idEdizione){
		List<Studente> studenti = em
				.createQuery("Select s from Studente s where s.id_edizione= :edId", Studente.class)
				.setHint("javax.persistence.cache.storeMode", "REFRESH").setParameter("edId", idEdizione).getResultList();
		if (studenti.isEmpty())
			return null;
		else 
			return studenti;
	}

}
