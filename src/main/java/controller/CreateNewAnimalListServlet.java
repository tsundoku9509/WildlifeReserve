package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;
import model.Visitor;
import model.VisitorListDetails;

/**
 * Servlet implementation class CreateNewAnimalListServlet
 */
@WebServlet("/createNewAnimalListServlet")
public class CreateNewAnimalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAnimalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalHelper anh = new AnimalHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String guestName = request.getParameter("guestName");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedAnimals = request.getParameterValues("allAnimalsToAdd");
		List<Animals> selectedAnimalsInList = new ArrayList<Animals>();
		if(selectedAnimals != null && selectedAnimals.length > 0) {
			for(int i = 0; i<selectedAnimals.length; i++) {
				System.out.println(selectedAnimals[i]);
				Animals a = anh.searchForAnimalsById(Integer.parseInt(selectedAnimals[i]));
				selectedAnimalsInList.add(a);
			}
		}
		Visitor visitor = new Visitor(guestName);
		VisitorListDetails vld = new VisitorListDetails(listName, ld, visitor);
		vld.setListOfAnimals(selectedAnimalsInList);
		VisitorListDetailsHelper vldh = new VisitorListDetailsHelper();
		vldh.insertNewVisitorListDetails(vld);
		
		System.out.println("Success!");
		System.out.println(vld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
