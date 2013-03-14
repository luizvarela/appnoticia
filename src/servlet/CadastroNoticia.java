package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Noticia;

/**
 * Servlet implementation class CadastroNoticia
 */
public class CadastroNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("notTitulo");
		String texto = request.getParameter("notTexto");
		String usuario = request.getParameter("notUsuario");
		
		Noticia noticia = new Noticia();
		noticia.setTexto(texto);
		noticia.setTitulo(titulo);
		noticia.setUsuario(usuario);
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("ultimaNoticiaCadastrada", noticia);
		ArrayList<Noticia> listaNoticia = (ArrayList<Noticia>) session.getAttribute("listaNoticia");
		
		if(listaNoticia == null){
			listaNoticia = new ArrayList<Noticia>();
			listaNoticia.add(noticia);
			session.setAttribute("listaNoticia",listaNoticia);
		}else{
			listaNoticia.add(noticia);
			session.setAttribute("listaNoticia",listaNoticia);
		}
		
		response.sendRedirect("index.html");
	}

}
