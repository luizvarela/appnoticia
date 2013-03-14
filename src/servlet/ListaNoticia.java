package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Noticia;

/**
 * Servlet implementation class ListaNoticia
 */
public class ListaNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Noticia> listaNoticia = (ArrayList<Noticia>) session.getAttribute("listaNoticia");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Lista de Noticia</title>");
		out.print("</head>");
		out.print("<body>");
		if(listaNoticia == null){
			out.print("<h1>Nao existe Noticia Cadastrada</h1>");
		}else{
			for (Noticia noticia : listaNoticia) {
				out.print("<h1>"+noticia.getTitulo()+"</h1>");
				out.print("<h3>"+noticia.getTexto()+"</h3>");
				out.print("<p>Usuario: "+noticia.getUsuario()+"</p>");
				out.print("<hr>");
			}
			
		}
		out.print("<a href=\"/AppNoticia/index.html\">Voltar</a>");
		out.print("</body>");
		out.print("</html>");
	}

}
