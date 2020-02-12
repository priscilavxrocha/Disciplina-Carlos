package br.com.curso.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.model.Funcionario;
import br.com.curso.service.FuncionarioService;

/**
 * Servlet implementation class ContatoController
 */
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;
	private Funcionario funcionario;
	private FuncionarioService service;

	public FuncionarioController() {
		this.service = new FuncionarioService();
		this.funcionario = new Funcionario();
		this.funcionarios = new ArrayList<Funcionario>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			this.funcionarios = this.service.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("contatos", this.funcionarios);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String sobrenome = request.getParameter("sobrenome");
		String telefone = request.getParameter("telefone");

		this.funcionario.setNome(nome);
		this.funcionario.setEmail(email);
		this.funcionario.setSobrenome(sobrenome);
		this.funcionario.setTelefone(telefone);
		
		System.out.println(nome);
		System.out.println(email);
		
		try {
			this.service.save(this.funcionario);
			this.funcionario = new Funcionario();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
