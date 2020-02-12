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


public class ListarFuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;
	private FuncionarioService service;

	public ListarFuncionarioController() {
		this.service = new FuncionarioService();
		this.funcionarios = new ArrayList<Funcionario>();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null) {
			
			try {
				this.service.removeById(Long.parseLong(request.getParameter("id")));
				this.funcionarios = this.service.list();
				RequestDispatcher rd = request.getRequestDispatcher("/pages/lista.jsp");
				request.setAttribute("funcionarios", this.funcionarios);
				request.setAttribute("exclusao", "Contato removido com sucesso");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/lista.jsp");
		try {
			this.funcionarios = this.service.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("funcionarios", this.funcionarios);
		rd.forward(request, response);
		
	}

	
}
