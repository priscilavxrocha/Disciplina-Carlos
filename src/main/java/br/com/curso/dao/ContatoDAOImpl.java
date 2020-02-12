package br.com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.com.curso.model.Funcionario;
import br.com.curso.utils.JPAUtils;

public class ContatoDAOImpl implements IContatoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = null;

	public void save(Funcionario funcionario) throws Exception {
		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			if (funcionario.getId() == null) {
				factory.persist(funcionario);
			} else {
				factory.merge(funcionario);
			}
			factory.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
	}

	@Override
	public List<Funcionario> list() throws Exception {
		this.factory = emf.createEntityManager();
		List<Funcionario> funcionarios = null;
		try {
			factory.getTransaction().begin();
			 TypedQuery<Funcionario> query = factory.createQuery("select c from Funcionario c", Funcionario.class);
			 return query.getResultList();
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

		return funcionarios;
	}
	
	@Override
	public void removeById(Long id) throws Exception {
		this.factory = emf.createEntityManager();
		Funcionario funcionario = new Funcionario();

		try {

			funcionario = factory.find(Funcionario.class, id);
			factory.getTransaction().begin();
			factory.remove(funcionario);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}
	
	
	public Funcionario findById(Long id) throws Exception  {
		this.factory = emf.createEntityManager();
		Funcionario funcionario = new Funcionario();
		try {
			funcionario = factory.find(Funcionario.class, id);
			return funcionario;

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
			
		} finally {
			factory.close();
		}
		return null;
	}
	
	
	@Override
	public void update(Funcionario funcionario) throws Exception {
		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			factory.merge(funcionario);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
	}

}
