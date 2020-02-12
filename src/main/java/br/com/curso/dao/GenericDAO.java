package br.com.curso.dao;

import java.io.Serializable;

public interface GenericDAO <T, ID extends Serializable>{
	
	public void save(T instance)throws Exception;

}
