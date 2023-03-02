package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;
import model.Visitor;

/**
 * Servlet implementation class WildlifeServ
 */
@WebServlet("/WildlifeServ")
public class WildlifeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WildlifeServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String wildlife = request.getParameter("wildlife");
		Visitor animal = new Visitor(wildlife, 0, wildlife, 0);
		PrintWriter writer = response.getWriter();
		writer.println("Your visitor info is: " + animal.toString());
		writer.close();
		request.setAttribute("Visitor", animal);
		getServletContext().getRequestDispatcher("/wildlife.jsp").forward(request, response);
	}

}
