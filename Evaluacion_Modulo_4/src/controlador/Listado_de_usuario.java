package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.Listausuario;
import modelo.Usuario;


/**
 * Servlet implementation class Listado_de_usuario
 */
@WebServlet("/Listado_de_usuario")
public class Listado_de_usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listado_de_usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession misesion = request.getSession();
			if(null == misesion.getAttribute("nombresesion")){  
				
				request.getRequestDispatcher("loginsesion").forward(request,response);
				
			}else {
				
				Listausuario lusu = new Listausuario();
				List<Usuario> listadousu = lusu.obtener();
				request.setAttribute("usua", listadousu);
				request.getRequestDispatcher("Listado_de_usuario.jsp").forward(request, response);
			}
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
