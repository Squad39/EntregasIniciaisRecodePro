package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Apoiador;
import model.ApoiadorDAO;


@WebServlet("/Inserir")
public class InserirContatoServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		String dataNasc = request.getParameter("dataNasc");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String tipoDoacao = request.getParameter("tipoDoacao");
		String telContato = request.getParameter("telContato");
		String email = request.getParameter("email");
		
		
		// criando o objeto contato 
		Apoiador objContato =  new Apoiador();
		
		// guardando os dados do formulario do objeto
		objContato.setNome(dataNasc);
		objContato.setNome(nome);
		objContato.setNome(telefone);
		objContato.setNome(tipoDoacao);
		objContato.setNome(telContato);
		objContato.setNome(email);
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		ApoiadorDAO cdao = new ApoiadorDAO();		
		cdao.save(objContato);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("home");
		
		
		
	}

}
