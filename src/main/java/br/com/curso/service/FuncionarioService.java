package br.com.curso.service;

import java.util.List;

import br.com.curso.dao.ContatoDAOImpl;
import br.com.curso.model.Funcionario;

public class FuncionarioService {

	private ContatoDAOImpl impl;

	public FuncionarioService() {
		this.impl = new ContatoDAOImpl();
	}

	public void save(Funcionario funcionario) throws Exception {
		this.impl.save(funcionario);
	}

	public List<Funcionario> list() throws Exception{
		return this.impl.list();
	}
	
	public void removeById(Long id) throws Exception{
		this.impl.removeById(id);
	}

	public void update(long parseLong) {
		
		
	}

	public Funcionario findById(Long id) throws Exception {
		return this.impl.findById(id);
	}
}
