package darioediaz.Interfaces;

import java.util.List;
import java.util.Optional;

public interface IController<T, id> {

	void createEntity(T entity);

	void destroyEntity(Integer id);

	void editEntity(T entity);

	Optional<T> findEntity(Integer id);

	List<T> findEntityList();

}
