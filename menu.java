/* SALMAN MAULAVIZADA 20604686
DSA ASSIGNMENT */

import java.util.*;
import java.io.*;

public class menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		journeyClass journey = new journeyClass(); // initialising variables
		DSAGraph graph = new DSAGraph();
		LinkedList list = new LinkedList();
		String[] rankArray;
		String convCheck = "metres";
		boolean loop = true;
		if (args.length == 0) {
			System.out.println(
					"This program has two modes.\n --You can run it with '-s', which will take in a input 'map file' as the second commandline argument.\n --The 'journey' file for the third commandline argument, which is the preferences for the routes.\n --The fourth commandline argument is the save file, which will save the routes generated.");
			System.out.println(
					"The second mode is ran with '-i'.\nThis will open the program in interactive mode.\nIn this mode, you will have the following options:\n -- Load input file (load in the map file)\n -- Node operations (allows user to remove, edit, add, or update nodes)\n -- Edge operations (allows user to remove,edit,add,or update edges)\n -- Parameter tweaks (allows user to choose different units for the 'distance')\n -- Display graph (displays adjacency matrix of all nodes in the graph and their connected nodes\n -- Display world (displays all routes in the map)\n -- Enter journey details (allows user to set the journey preferences for the routes to be generated upon)\n -- Generate routes (generates routes dependant on the user's journey input)\n -- Display routes (displays generated routes, and gives option to save)\n -- Save network (allows user to save all routes in the map to a file)\n -- Exit (...)");
		} // if user starts program with no parameters

		else if (args[0].equals("-i")) {
			while (loop) {
				try {
					System.out.println("(1) Load input file");
					System.out.println("(2) Node operations");
					System.out.println("(3) Edge operations");
					System.out.println("(4) Parameter tweaks");
					System.out.println("(5) Display graph");
					System.out.println("(6) Display world");
					System.out.println("(7) Enter journey details");
					System.out.println("(8) Generate routes"); // menu choices
					System.out.println("(9) Display routes");
					System.out.println("(10) Save network");
					System.out.println("(11) Exit");
					choice = sc.nextInt();
					if (choice == 1) {
						System.out.println("Enter file name to read");
						sc.nextLine();
						String file = sc.nextLine();
						int check = fileIO.readFile(file, graph); // reads file in to the graph
						if (check == 0) {
							System.out.println("*****************Map Loaded****************"); // if successfully reads
																								// prints to user
						}
					} else if (choice == 2) {
						System.out.println("Choose between\n(1) Find\n(2) Insert\n(3) Delete\n(4) Update");
						int innerChoice = sc.nextInt();
						if (innerChoice == 1) {
							System.out.println("Enter node name"); // find node function
							sc.nextLine();
							String finder = sc.nextLine();
							if (graph.hasVertex(finder)) {
								System.out.println(finder + " does exist"); // uses node information entered by user to
																			// find the node in the graph
							} else {
								System.out.println("Node does not exist");
							}

						}

						else if (innerChoice == 2) {
							System.out.println("Enter node name");
							sc.nextLine();
							String name = sc.nextLine(); // adds node to graph based on user input
							graph.addVertex(name, null);
							System.out.println("*********************************Node Inserted*********************");
						}

						else if (innerChoice == 3) {
							System.out.println("Enter node name");
							sc.nextLine();
							String name = sc.nextLine(); // removes node from graph
							graph.removeVertex(name);
						}

						else if (innerChoice == 4) {
							System.out.println("Enter the node which you wish to update");
							sc.nextLine();
							String name = sc.nextLine(); // changes node name
							System.out.println("Enter the new name for node");
							String newName = sc.nextLine();
							graph.updateNode(name, newName);
						}
					}

					else if (choice == 3) {

						System.out.println("Choose between\n(1) Find\n(2) Add\n(3) Remove\n(4) Update");
						int innerChoice = sc.nextInt();
						if (innerChoice == 1) {
							System.out.println("Enter the edge start location"); // finds edge using user input
																					// information
							sc.nextLine();
							String start = sc.nextLine();
							System.out.println("Enter the destination of the edge");
							String end = sc.nextLine();
							System.out.println(
									"Enter the security level,obstacles, and distance of the edge separated by commas");
							System.out.println("If there is no security level or obstacles, please enter 'none'");
							String[] line = sc.nextLine().split(",");
							if (line.length < 3) {
								System.out.println("Incorrect edge input");
							} else {
								graph.findEdge(start, end, Double.parseDouble(line[2]), line[1], line[0]);
							}
						}

						else if (innerChoice == 2) {

							System.out.println("Enter the edge start location");
							sc.nextLine();
							String start = sc.nextLine();
							System.out.println("Enter the destination of the edge");
							String end = sc.nextLine();
							System.out.println(
									"Enter the security level,obstacles, and distance of the edge separated by commas");
							System.out.println("If there is no security level or obstacles, please enter 'none'");
							String[] line = sc.nextLine().split(",");
							if (line.length < 3) {
								System.out.println("Incorrect edge input"); // adds edge to graph based on user input
							} else {

								graph.addEdge(Double.parseDouble(line[2]), start, end, ">", line[0], line[1]);
								System.out.println("Edge Inserted");
							}
						}

						else if (innerChoice == 3) {

							System.out.println("Enter the edge start location");
							sc.nextLine();
							String start = sc.nextLine();
							System.out.println("Enter the destination of the edge");
							String end = sc.nextLine();
							System.out.println(
									"Enter the security level,obstacles, and distance of the edge separated by commas");
							System.out.println("If there is no security level or obstacles, please enter 'none'");
							String[] line = sc.nextLine().split(",");
							if (line.length < 3) {
								System.out.println("Incorrect edge input");
							} else { // removes edge based on user input

								graph.removeEdge(start, end, Double.parseDouble(line[2]), line[1], line[0]);
							}

						} else if (innerChoice == 4) {
							System.out.println("Enter the edge start location");
							sc.nextLine();
							String start = sc.nextLine();
							System.out.println("Enter the destination of the edge");
							String end = sc.nextLine();
							System.out.println(
									"Enter the security level,obstacles, and distance of the edge separated by commas");
							System.out.println("If there is no security level or obstacles, please enter 'none'");
							String[] line = sc.nextLine().split(",");
							if (line.length < 3) {
								System.out.println("Incorrect edge input"); // changes edge information depending on
																			// user input
							}
							System.out.println(
									"Would you like to change the \n(1) Security level\n(2) Obstacles\n(3) Distance");
							int next = sc.nextInt();
							if (next == 1) {
								System.out.println("Enter new security level"); // changes security level
								sc.nextLine();
								String newSec = sc.nextLine();
								graph.setSecurity(start, end, Double.parseDouble(line[2]), line[1], line[0], newSec);
							} else if (next == 2) {
								System.out.println("Enter new Obstacle"); // changes the obstacle
								sc.nextLine();
								String newObst = sc.nextLine();
								graph.setObstacle(start, end, Double.parseDouble(line[2]), line[1], line[0], newObst);

							} else if (next == 3) {
								System.out.println("Enter new distance"); // changes distance
								sc.nextLine();
								String newDis = sc.nextLine();
								graph.setDis(start, end, Double.parseDouble(line[2]), line[1], line[0], Double.parseDouble(newDis));
							}
						}

					}

					else if (choice == 4) {
						System.out.println("Choose between the following units for the distance");
						System.out.println("(1) Kilometres\n(2) Metres (default unit)");

						int paramChoice = sc.nextInt();

						if (paramChoice == 1) {
							graph.convertKms(convCheck);
							convCheck = "km";
						} else if (paramChoice == 2) {
							graph.convertBack(convCheck); // parameter tweaks - changes distance between km and metres
							convCheck = "metres"; // convCheck string tells the function what the current unit is set to
						} else {
							System.out.println("Incorrect choice");
						}
					}

					else if (choice == 5) {
						sc.nextLine();
						System.out.println("Would you like to save (Y) or (N)");
						char saveChoice = sc.next().charAt(0);
						if (saveChoice == 'Y' || saveChoice == 'y') {
							System.out.println("Enter the name of the file you wish to save to");
							String file = sc.nextLine();
							sc.nextLine();
							graph.displayMatrix(file); // displays matrix, and saves it, depending on user input
						}
						graph.displayMatrix();
					}

					else if (choice == 6) {
						graph.displayWorld(); // displays every route in the map
					}

					else if (choice == 7) {
						System.out.println("Enter starting location");
						sc.nextLine();
						String startLoc = sc.nextLine();
						System.out.println("Enter destination"); // sets the journey preferences for the routes to be
																	// generated from
						String destination = sc.nextLine();
						System.out.println("Enter the obstacle, security level, and time separated by commas");
						System.out.println(
								"If there is no obstacles or security level please enter 'none' in place of them");
						String[] line = sc.nextLine().split(","); // splits on each comma
						if (line.length < 3 || line.length > 3) {
							System.out.println("Incorrect journey input"); // error checking
						} else {
							journey = new journeyClass(startLoc, destination, line[2], line[0], line[1]);
						}

					}

					else if (choice == 8) {

						list = graph.calcJourney(journey);
						rankArray = graph.sorter(list, 0); // sends journey to generate routes in 'calcjourney'
						if (list.getSize() == 0) {
							System.out.println("No routes generated"); // alerts user if no routes are made
						} else {
							System.out.println("Generated routes");
						}

					} else if (choice == 9) {

						System.out.println("Would you like to save the routes to a file? (Y)es or (N)o");
						char check = sc.next().charAt(0);
						if (check == 'Y' || check == 'y') {
							System.out.println("Please enter the file name"); // displays routes and saves them
																				// depending on user choice
							sc.nextLine();
							String fileName = sc.nextLine();
							File file = new File(fileName); // deletes any previous file with the name and remakes it,
															// so the save file will be new each time
							file.delete();
							rankArray = graph.sorter(list, 1);
							fileIO.writeFile(fileName, rankArray); // file writing function
						} else if (check == 'N' || check == 'n') {
							rankArray = graph.sorter(list, 1);
						}

						else {
							System.out.println("Incorrect input, choose between (Y)es or (N)o");
						}

					}

					else if (choice == 10) {
						System.out.println("Enter file name to save to");
						sc.nextLine();
						String fileName = sc.nextLine(); // saves all routes in the map to a file
						graph.displayWorld(fileName);
						System.out.println("World Saved");

					}

					else if (choice == 11) {
						loop = false; // exits program
					}

				}

				catch (InputMismatchException e) {
					System.out.println("Invalid input " + e); // catches any invalid input exceptions
					sc.nextLine();
				}
			}
		}

		else if (args[0].equals("-s")) {
			File file = new File(args[3]);
			file.delete(); // deletes savefile and remakes it
			LinkedList writeList = new LinkedList();
			fileIO.readFile(args[1], graph); // populates graph
			fileIO.readFile(args[2], journey); // populates journey
			list = graph.calcJourney(journey); // populates the linkedlist with all the routes in the graph
			String[] ranks = graph.sorter(list, 1); // fills array with all the valid routes and prints to user
													// if(ranks.length == 0)
			{
				System.out.println("No routes were generated");
			}
			fileIO.writeFile(args[3], ranks); // writes the array to the file specified by user

		}

	}
}
