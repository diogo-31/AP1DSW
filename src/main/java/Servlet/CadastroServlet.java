package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//instanciando um objeto do tipo Jogo
		Jogo j = new Jogo();
		j.setNome(req.getParameter("nomeP"));
		j.setEstilo(req.getParameter("estiloP"));
		
		//Inserindo no "Banco de Dados"
		BancoDeDados.insert(j);
		
		//Gerar a p�gina dinamicamente
		PrintWriter escritor = resp.getWriter();
		escritor.write("<html>");
		escritor.write("<head><title>Lista de jogos</title></head>");
		escritor.write("<body>");
		escritor.write("Data: " + formatar(new Date()));
		escritor.write("<br/>Jogo cadastrado com sucesso.<br/>");
		escritor.write("<table>");
		escritor.write("<thead><tr><th>Nome</th><th>Estilo</th></tr></thead>");
		escritor.write("<tbody>");
		escritor.write(BancoDeDados.select());
		escritor.write("</tbody>");
		escritor.write("</table>");
		escritor.write("<br/><a href=\"index.html\">voltar</a>");
		escritor.write("</body>");
		escritor.write("</html>");
	}
}
