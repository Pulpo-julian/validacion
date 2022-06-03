package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import models.Contador;

/**
 * Servlet implementation class CtrlPrincipal
 */
@WebServlet("/controlprincipal")
public class CtrlPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
      	String boton=request.getParameter("boton");
		out.println("<h1>Bienvenido " + nombre+" "+apellido +" "+boton+ "</h1>");
       
		
		PrintWriter out = response.getWriter();
		try {
			
			int numeroBuscar = Integer.valueOf(request.getParameter("busqueda"));
			
			
			out.print("se ha buscado el numero: " + numeroBuscar + " por " + (Contador.getContador()) + " vez");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			out.print("debes ingresar un numero");
			
		}
		*/
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String consultaPre = "SELECT cedula FROM tblcliente;";
		List<String> cedulas = new ArrayList<String>();
		String cedulaBuscar = request.getParameter("busqueda");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientesappweb","root","el_pulpo");
			stmt = conn.prepareStatement(consultaPre);
			rs = stmt.executeQuery();
			
			for(;rs.next();) {
				
				cedulas.add(rs.getString(1));
				
			}
			
			
			boolean encontrado = false;
			
			if(cedulaBuscar.length() == 10) {
				
				for(int i = 0; i < cedulas.size() && encontrado == false; i++) {
					
					if(cedulaBuscar.equals(cedulas.get(i))){
						
						encontrado = true;
					} 
					
				}
				
				if(encontrado) {
					out.print("la cedula ya esta en la base de datos");
				} else {
					out.print("la cedula es valida");
				}
				
			} else {
				
				out.print("ingrese un numero de cedula correcto");
				
			}
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}finally {
			
			try {
				
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			
		}
		
		//doGet(request, response);
	}

}
