package darioediaz.Logic;

import darioediaz.Entities.Pokemon;
import darioediaz.Repository.PokemonRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

	private final PokemonRepository pokemonController;

	public FileReader(PokemonRepository pokemonController) {
		this.pokemonController = pokemonController;
	}

	public List<Pokemon> ReadCSV(String resourcePath) throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);

		if (inputStream == null) {
			throw new IllegalArgumentException("Archivo no encontrado en recursos: " + resourcePath);
		}

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			List<Pokemon> pokemonList = reader.lines()
					.skip(1)
					.map(Pokemon::new)
					.collect(Collectors.toList());

			for (Pokemon pokemon : pokemonList) {
				pokemonController.create(pokemon);
			}

			return pokemonList;
		}
	}
}
