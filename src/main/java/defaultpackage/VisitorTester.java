/**
 *@author Riley Ahlrichs riahl12 - rpahlrichs
 *CIS175 - Spring 2023
 *Mar 3, 2023
 */
package defaultpackage;

import java.util.List;

import controller.VisitorHelper;
import model.Visitor;

/**
 * @author riley
 *
 */
public class VisitorTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Visitor sally = new Visitor(0, "Sally", 4, "sightseeing", 25.25);
		VisitorHelper vh = new VisitorHelper();
		
		vh.insertVisitor(sally);
		
		List<Visitor> allVisitors = vh.showAllVisitors();
		for(Visitor a: allVisitors) {
			System.out.println(a.toString());
		}
	}

}
