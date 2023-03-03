/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Mar 3, 2023
 */
package defaultpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.VisitorHelper;
import controller.VisitorListDetailsHelper;
import model.Animals;
import model.Visitor;
import model.VisitorListDetails;

/**
 * @author riley
 *
 */
public class VisitorListDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Visitor bill = new Visitor("Bill");
		
		VisitorListDetailsHelper vldh = new VisitorListDetailsHelper();
		
		Animals tiger = new Animals("Tiger", "Jungle", 2345);
		Animals dog = new Animals("Dog", "Home", 987);
		
		List<Animals> billsAnimals = new ArrayList<Animals>();
		billsAnimals.add(tiger);
		billsAnimals.add(dog);
		
		VisitorListDetails billsList = new VisitorListDetails("Bill's Animal List", LocalDate.now(), bill);
		billsList.setListOfAnimals(billsAnimals);
		
		vldh.insertNewVisitorListDetails(billsList);
		
		List<VisitorListDetails> allLists = vldh.getLists();
		for(VisitorListDetails a: allLists) {
			System.out.println(a.toString());
		}
		
		/*VisitorHelper vh = new VisitorHelper();
		
		vh.insertVisitor(bill);
		
		
		
		VisitorListDetails billList = new VisitorListDetails("Bill's List", LocalDate.now(), bill);
		
		vldh.insertNewVisitorListDetails(billList);
		
		List<VisitorListDetails> allLists = vldh.getLists();
		for(VisitorListDetails a : allLists) {
			System.out.println(a.toString());
		}*/
	}

}
