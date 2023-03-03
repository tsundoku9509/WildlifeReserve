package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;

/**
 * Servlet implementation class EditAnimalTypeServlet
 */
@WebServlet("/editAnimalTypeServlet")
public class EditAnimalTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalTypeServlet() {
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
		
		String animalType = request.getParameter("animalType");
		String habitat = request.getParameter("habitat");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Animals animalToUpdate = dao.searchForAnimalsById(tempId);
		
		animalToUpdate.setAnimalType(animalType);
		animalToUpdate.setHabitat(habitat);
		
		dao.updateAnimals(animalToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
	}

}
