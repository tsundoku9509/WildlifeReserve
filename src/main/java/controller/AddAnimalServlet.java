package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;

/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet("/addAnimalServlet")
public class AddAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnimalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String animalType = request.getParameter("animalType");
		String habitat = request.getParameter("habitat");
		int trackingNum = Integer.parseInt(request.getParameter("trackingNum"));
		
		Animals ani = new Animals(animalType,habitat,trackingNum);
		AnimalHelper dao = new AnimalHelper();
		dao.insertAnimal(ani);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
