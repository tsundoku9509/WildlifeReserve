package defaultpackage;
import java.util.List;
import java.util.Scanner;

import controller.AnimalHelper;
import model.Animals;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static AnimalHelper ani = new AnimalHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter an animal type: ");
			String animalType = in.nextLine();
			System.out.print("Enter a habitat: ");
			String habitat = in.nextLine();
			System.out.println("Enter the animals tracking number: ");
			int trackingNum = in.nextInt();
			Animals toAdd = new Animals(animalType,habitat,trackingNum);
			ani.insertAnimal(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the animal type to delete: ");
			String animalType = in.nextLine();
			System.out.print("Enter the habitat to delete: ");
			String habitat = in.nextLine();
			System.out.println("Enter the tracking number to delete: ");
			int trackingNum = in.nextInt();
			Animals toDelete = new Animals(animalType,habitat,trackingNum);
			ani.deleteAnimal(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Animal Type");
			System.out.println("2 : Search by Habitat");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Animals> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the Animal Type: ");
				String animalType = in.nextLine();
				foundItems = ani.searchForAnimalByAnimalType(animalType);
				
			} else {
				System.out.print("Enter the Habitat: ");
				String habitat = in.nextLine();
				foundItems = ani.searchForAnimalByHabitat(habitat);
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Animals l : foundItems) {
					System.out.println(l.getTrackingNum() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Animals toEdit = ani.searchForAnimalsById(idToEdit);
				System.out.println("Retrieved " + toEdit.getHabitat() + " from " + toEdit.getAnimalType());
				System.out.println("1 : Update Animal Type");
				System.out.println("2 : Update Habitat");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Animal Type: ");
					String newAnimalType = in.nextLine();
					toEdit.setAnimalType(newAnimalType);
				} else if (update == 2) {
					System.out.print("New Habitat: ");
					String newHabitat = in.nextLine();
					toEdit.setHabitat(newHabitat);
				}

				ani.updateAnimals(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Here is our animal list for visitors! ---");
			while (goAgain) {
				System.out.println("*  Select an animal:");
				System.out.println("*  1 -- Add an animal");
				System.out.println("*  2 -- Edit an animal");
				System.out.println("*  3 -- Delete an animal");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the list");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ani.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<Animals> allAnimals = ani.showAllAnimals();
			for(Animals singleAnimal : allAnimals) {
				System.out.println(singleAnimal.returnAnimalDetails());
			}
			

		}

	}
