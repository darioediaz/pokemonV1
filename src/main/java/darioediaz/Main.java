package darioediaz;

import darioediaz.Entities.Pokemon;
import darioediaz.Logic.FileReader;
import darioediaz.Repository.PokemonRepository;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		try {
			// 1. Crear el controller
			PokemonRepository pokemonController = new PokemonRepository();

			// 2. Crear el file reader, pasándole el controller
			FileReader fileReader = new FileReader(pokemonController);

			// 3. Leer el CSV y guardar los datos
			List<Pokemon> pokemons = fileReader.ReadCSV("X:\\Workspace_Code\\Projects\\pokemonV1\\pokemonV1\\src\\main\\resources\\csv\\Pokemon.csv");

			// 4. Mostrar por consola (opcional)
			pokemons.forEach(System.out::println);

			System.out.println("¡Carga de Pokemons completada!");

		} catch (IOException e) {
			System.out.println("Error leyendo el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}