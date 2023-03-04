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
 * Servlet implementation class EditVisitorListDetailsServlet
 */
@WebServlet("/editVisitorListDetailsServlet")
public class EditVisitorListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVisitorListDetailsServlet() {
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
		VisitorListDetailsHelper dao = new VisitorListDetailsHelper();
		AnimalHelper anh = new AnimalHelper();
		VisitorHelper vh = new VisitorHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		VisitorListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String guestName = request.getParameter("guestName");
		Visitor newVisitor = vh.findVisitor(guestName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Animals> selectedAnimalsInList = new ArrayList<Animals>();
			
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Animals a = anh.searchForAnimalsById(Integer.parseInt(selectedItems[i]));
				selectedAnimalsInList.add(a);
			}
			listToUpdate.setListOfAnimals(selectedAnimalsInList);
		}catch(NullPointerException ex) {
			List<Animals> selectedAnimalsInList = new ArrayList<Animals>();
			listToUpdate.setListOfAnimals(selectedAnimalsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setVisitor(newVisitor);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}











