package darioediaz.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "#")
	private int pokedexNumber;
	private String name;
	private String type1;
	private String type2;
	private int total;
	private int hp;
	private int attack;
	private int defense;
	private int specialAttack;
	private int specialDefense;
	private int speed;
	private int generation;
	private boolean legendary;

	public Pokemon() {
	}

	public Pokemon(int id, int pokedexNumber, String name, String type1, String type2, int total, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, int generation, boolean legendary) {
		this.id = id;
		this.pokedexNumber = pokedexNumber;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.total = total;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
		this.generation = generation;
		this.legendary = legendary;
	}

	public Pokemon(String linea) {
		String[] valores = linea.split(",");
		this.pokedexNumber = Integer.parseInt(valores[0]);
		this.name = valores[1];
		this.type1 = valores[2];
		this.type2 = valores[3];
		this.total = Integer.parseInt(valores[4]);
		this.hp = Integer.parseInt(valores[5]);
		this.attack = Integer.parseInt(valores[6]);
		this.defense = Integer.parseInt(valores[7]);
		this.specialAttack = Integer.parseInt(valores[8]);
		this.specialDefense = Integer.parseInt(valores[9]);
		this.speed = Integer.parseInt(valores[10]);
		this.generation = Integer.parseInt(valores[11]);
		this.legendary = Boolean.parseBoolean(valores[12]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPokedex() {
		return pokedexNumber;
	}

	public void setNumeroPokedex(int pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(int specialDefense) {
		this.specialDefense = specialDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	@Override
	public String toString() {
		return "------------------------------------------" +
				"\nId: " + id +
				"\n#" + pokedexNumber +
				"\nname: " + name +
				"\ntype1: " + type1 +
				"\ntype2: " + type2 +
				"\ntotal: " + total +
				"\nhp: " + hp +
				"\nattack: " + attack +
				"\ndefense: " + defense +
				"\nspecialAttack: " + specialAttack +
				"\nspecialDefense: " + specialDefense +
				"\nspeed: " + speed +
				"\ngeneration: " + generation +
				"\nlegendary: " + legendary;
	}
}
