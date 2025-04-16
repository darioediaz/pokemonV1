package darioediaz.Controller;

import darioediaz.Entities.Pokemon;
import darioediaz.Interfaces.IController;
import darioediaz.Services.PokemonService;

import java.util.List;
import java.util.Optional;

public class PokemonController implements IController<Pokemon, Integer> {

	PokemonService pokemonService = new PokemonService();

	@Override
	public void createEntity(Pokemon entity) {
		pokemonService.createEntity(entity);
	}

	@Override
	public void destroyEntity(Integer id) {
		pokemonService.destroyEntity(id);
	}

	@Override
	public void editEntity(Pokemon entity) {
		pokemonService.editEntity(entity);
	}

	@Override
	public Optional<Pokemon> findEntity(Integer id) {
		return pokemonService.findEntity(id);
	}

	@Override
	public List<Pokemon> findEntityList() {
		return pokemonService.findEntityList();
	}
}
