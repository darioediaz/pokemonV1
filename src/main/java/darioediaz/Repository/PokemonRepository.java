package darioediaz.Repository;

import darioediaz.Entities.Pokemon;
import darioediaz.Interfaces.IPokemonController;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PokemonRepository implements IPokemonController<Pokemon, Integer> {

	private EntityManagerFactory emf;

	public PokemonRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public PokemonRepository() {
		emf = Persistence.createEntityManagerFactory("pokemonV1PU");
	}

	public EntityManager getEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("EntityManagerFactory no inicializado");
		}
		return emf.createEntityManager();
	}


	@Override
	public void create(Pokemon entity) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void destroy(Integer id) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Pokemon pokemon = em.find(Pokemon.class, id);

			if (pokemon == null) {
				throw new EntityExistsException("El pokemon con el id " + id + " no existe!");
			}

			em.remove(pokemon);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void edit(Pokemon entity) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Pokemon findById(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Pokemon.class, id);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Pokemon> findAll() {
		EntityManager em = getEntityManager();
		try {
			return em.createQuery("SELECT p FROM Pokemon p", Pokemon.class).getResultList();
		} finally {
			em.close();
		}
	}
}
