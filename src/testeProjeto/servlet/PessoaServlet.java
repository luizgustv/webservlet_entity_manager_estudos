package testeProjeto.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testeProjeto.main.CriarPersistencia;
import testeProjeto.model.Pessoa;

@WebServlet(urlPatterns = "/pessoa")
public class PessoaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CriarPersistencia persistencia = new CriarPersistencia();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();

		printWriter.println("Testando servlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		Pessoa pessoa = new Pessoa(nome, email);

		EntityManager manager = persistencia.entityManager();

		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();

		printWriter.println("Pessoa cadastrada com sucesso!!!");
		
		//printWriter.println("Nome/Email não preenchidos!!!");

	}

}
