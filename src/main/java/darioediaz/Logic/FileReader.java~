package darioediaz.Logic;

import darioediaz.Entities.Pokemon;
import darioediaz.Repository.PokemonRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

	private final PokemonRepository pokemonController;

	public FileReader(PokemonRepository pokemonController) {
		this.pokemonController = pokemonController;
	}

	public List<Pokemon> ReadCSV(String fileName) throws IOException {

		List<Pokemon> pokemonList = Files.lines(Paths.get(fileName))
				.skip(1)
				.map(Pokemon::new)
				.toList();

		for (Pokemon pokemon : pokemonList) {
			pokemonController.create(pokemon);
		}
		return pokemonList;
	}


}
