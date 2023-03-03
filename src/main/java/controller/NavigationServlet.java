package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalHelper dao = new AnimalHelper();
		
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllAnimalsServlet";
		
		if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Animals animalToDelete = dao.searchForAnimalsById(tempId);
				dao.deleteAnimal(animalToDelete);
			}catch(NumberFormatException e) {
				System.out.println("You forgot to select an animal type");
			}
			
		}else if(act.equals("Edit")) {
			try {
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				Animals animalToEdit = dao.searchForAnimalsById(tempID);
				request.setAttribute("animalToEdit", animalToEdit);
				path = "/edit-animaltype.jsp";
			}catch(NumberFormatException e) {
				System.out.println("You forgot to select an animal type");
			}
			
			
		}else if(act.equals("Add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	

}
