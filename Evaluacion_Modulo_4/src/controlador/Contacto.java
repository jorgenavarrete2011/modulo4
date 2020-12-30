package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Contacto
 */
@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacto() {
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
				request.getRequestDispatcher("Contacto.jsp").forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("Email");
		String telefono = request.getParameter("telefono");
		String comentario = request.getParameter("comentario");
		
		System.out.println("Nombre: "+nombre+" Email: "+email+" Telefono: "+telefono+" Comentario: "+comentario);

		 request.getRequestDispatcher("Contacto.jsp").forward(request,response);
		
		
	}

}
