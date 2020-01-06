package fr.formation.inti.jpa.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, I extends Serializable> {

	
	public void persist(T e);
	
	public I save(T e);
	
	public void update(T e);
	
	public void delete(T e);
	
	public void deleteByID(I id,Class<?> persistClass);
	
	public T findById(I id,Class<?> persistClass);
	
	public void update(List<T> list);
	
	public void close();

	public List<T> getAll();

	
}
