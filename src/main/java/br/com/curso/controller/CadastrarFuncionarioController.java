package br.com.curso.controller;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.model.Departamento;
import br.com.curso.model.Empresa;
import br.com.curso.model.Endereco;
import br.com.curso.model.Funcionario;
import br.com.curso.service.FuncionarioService;


public class CadastrarFuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;
	private Funcionario funcionario;
	private Endereco endereco;
	private Empresa empresa;
	private Departamento departamento;
	private FuncionarioService service;

	public CadastrarFuncionarioController() {
		this.service = new FuncionarioService();
		this.endereco = new Endereco();
		this.empresa = new Empresa();
		this.departamento = new Departamento();
		this.funcionario = new Funcionario();
		this.funcionarios = new ArrayList<Funcionario>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null) {
			
			try {
				this.funcionario = this.service.findById(Long.parseLong(request.getParameter("id")));
				RequestDispatcher rd = request.getRequestDispatcher("/pages/cadastro.jsp");
				request.setAttribute("funcionario", this.funcionario);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String sobrenome = request.getParameter("sobrenome");
		String telefone = request.getParameter("telefone");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String nomeDepartamento = request.getParameter("departamento");
		String nomeEmpresa = request.getParameter("empresa");

		this.funcionario.setNome(nome);
		this.funcionario.setEmail(email);
		this.funcionario.setSobrenome(sobrenome);
		this.funcionario.setTelefone(telefone);
		this.endereco.setRua(rua);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.departamento.setNome(nomeDepartamento);
		this.empresa.setNome(nomeEmpresa);
		this.departamento.setEmpresa(empresa);
		this.funcionario.setDepartamento(departamento);
		this.funcionario.setEndereco(endereco);
	
		
		
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
