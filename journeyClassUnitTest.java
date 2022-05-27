public class journeyClassUnitTest {
	public static void main(String[] args) {
		int count = 0;
		System.out.println("Testing constructor");
		try {
			journeyClass journey = new journeyClass("1", "2", "13:00", "none", "none");
			System.out.println("Journey test passed\n");
			count++; // creating constructor with parameters
		} catch (Exception e) {
			System.out.println("Constructor failed. Error: " + e);
		}

		journeyClass journey = new journeyClass("1", "2", "13:00", "none", "none");
		System.out.println("Testing toString method");
		try {
			String test = journey.toString();
			System.out.println(test);
			System.out.println("ToString passed test\n"); // tostring method
			count++;
		} catch (Exception e) {
			System.out.println("ToString failed. Error: " + e);
		}

		System.out.println("Testing calcJourney method from DSAGraph class");
		try {
			DSAGraph graph = new DSAGraph();
			fileIO.readFile("Map_int_314.txt", graph);
			LinkedList test = graph.calcJourney(journey); // reading in the 'Map_int_314.txt' file to the DSAGraph
															// object
			if (test.getSize() == 1) // using the calcjourney method with the journeyClass object to assess the valid
										// routes
			{ // according to the journey details, there should only be one valid route,
				// therefore the 'test' linkedlist size should be 1
				System.out.println("Passed calcjourney test\n");
				count++;
			} else {
				throw new IllegalArgumentException("calcJourney failed");
			}
		} catch (Exception e) {
			System.out.println("Failed test. Error: " + e);
		}

		System.out.println("*********Passed " + count + "/3 tests");

	}
}
