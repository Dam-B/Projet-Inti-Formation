package fr.formation.inti.jpa.dao;

import java.util.List;

import fr.formation.inti.entities.Branch;

public interface IBranchDao extends IGenericDao<Branch, Integer>{

	
	public List<Branch> getAll();
	
	public void persist(Branch e);
	
	public Integer save(Branch e);
	
	public void update(Branch e);
	
	public void delete(Branch e);
	
	public void deleteByID(Integer id);
	
	public Branch findById(Integer id);
	
	public List<Branch> findByName(String name); 
	
	
	public void close();
}
