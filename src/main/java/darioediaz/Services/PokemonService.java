package darioediaz.Services;

import darioediaz.Entities.Pokemon;
import darioediaz.Interfaces.IController;
import darioediaz.Repository.PokemonRepository;
import jakarta.persistence.EntityExistsException;

import java.util.List;
import java.util.Optional;

public class PokemonService implements IController<Pokemon, Integer> {

	PokemonRepository pokemonRepository = new PokemonRepository();

	@Override
	public void createEntity(Pokemon entity) {
		pokemonRepository.create(entity);
	}

	@Override
	public void destroyEntity(Integer id) {
		try {
			pokemonRepository.destroy(id);
		} catch (EntityExistsException e) {
			System.err.println("Error: No se puede eliminar el pokemon con el ID: " + id);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void editEntity(Pokemon entity) {
		try {
			pokemonRepository.edit(entity);
		} catch (EntityExistsException e) {
			System.err.println("Error: No se puede editar el pokemon: " + entity.getName());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<Pokemon> findEntity(Integer id) {
		return Optional.ofNullable(pokemonRepository.findById(id));
	}

	@Override
	public List<Pokemon> findEntityList() {
		return pokemonRepository.findAll();
	}
}
