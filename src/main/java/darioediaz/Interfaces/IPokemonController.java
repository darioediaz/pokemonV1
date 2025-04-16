package darioediaz.Interfaces;

import java.util.List;

public interface IPokemonController<T, id> {

	void create(T entity);

	void destroy(Integer id);

	void edit(T entity);

	T findById(Integer id);

	List<T> findAll();

}
