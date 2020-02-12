package br.com.curso.dao;

import java.util.List;

import br.com.curso.model.Funcionario;

public interface IContatoDAO extends GenericDAO<Funcionario, Long> {

	public void save(Funcionario funcionario) throws Exception;
	
	public List<Funcionario> list() throws Exception;
	
	public void removeById(Long id) throws Exception;

	void update(Funcionario funcionario) throws Exception;
}
