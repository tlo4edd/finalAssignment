//SALMAN MAULAVIZADA 20604686
//fileIO.java file to handle fileIO functions
//DSA Assignment
import java.io.*;
import java.util.*;

public class fileIO {
	
	//Imports:String representing which file to read from, DSAGraph the graph which will be populated from the function
	//Exports:Integer representing file being read successfully
	public static int readFile(String pFileName, DSAGraph graph) {
		int cantFind = 0;
		int count = 0;
		String line;
		FileInputStream fileStream = null;
		InputStreamReader isr;
		BufferedReader bufRdr;
		try {
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream); // opens file and reads it into the graph or journey object
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine();

			while (line != null) {
				String[] processArr = new String[1]; //partial code taken from DSA practical 1 file io section
				processArr[0] = line;
				processLine(processArr, graph);		//reading in each line of the file until it is empty
				line = bufRdr.readLine();
			}

			fileStream.close();
		} catch (IOException e) {
			if (fileStream != null) {
				try {
					fileStream.close();
				} catch (IOException ex2) {
				}
			}
			cantFind = 1; // if file is read successfully, cantFind is 0, otherwise it is set as 1
			System.out.println("Error in fileProcessing: " + e.getMessage());// exception handling
		}
		return cantFind;
	}
	

	//Imports:String and journeyClass object for file to be read into the journeyClass object from the String file
	//Exports:Integer representing file being read in successfully
	public static int readFile(String pFileName, journeyClass journey) {
		int cantFind = 0;
		int count = 0;
		String line;
		FileInputStream fileStream = null;
		InputStreamReader isr;
		BufferedReader bufRdr;
		try {
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream); // opens file and reads it into the graph or journey object
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine();

			while (line != null) {
				String[] processArr = new String[1];
				processArr[0] = line;
				count++;		//count is used to tell the processJourney method which field of the object to fill
				processJourney(processArr, journey, count);//sends each line of the file to the processJourney method
				line = bufRdr.readLine();
			}

			fileStream.close();
		} catch (IOException e) {
			if (fileStream != null) { //partial code taken from DSA practical 1 file io section
				try {
					fileStream.close();
				} catch (IOException ex2) {
				}
			}
			cantFind = 1; // if file is read successfully, cantFind is 0, otherwise it is set as 1
			System.out.println("Error in fileProcessing: " + e.getMessage());// exception handling
		}
		return cantFind;
	}

	//Imports: String representing filename to write to, and String array holding information to write
	public static void writeFile(String pFileName, String[] array) {
		FileOutputStream fileStrm = null;
		PrintWriter pw;
		try {
			fileStrm = new FileOutputStream(pFileName, true);
			pw = new PrintWriter(fileStrm);
			{
				for (int i = 0; i < array.length; i++) { // writes file to user input file
					pw.println(array[i]);
				}							//partial code taken from DSA practical 1 file io section
				pw.close();
			}
		} catch (IOException e) {
			if (fileStrm != null) {
				try {
					fileStrm.close();
				} catch (IOException ex2) {	//exception handling
				}
			}
			System.out.println("Error in writing to file: " + e.getMessage());
		}
	}
	
	//Imports: String array to split, and DSAGraph to populate from the String array
	public static void processLine(String[] arr, DSAGraph graph) {
		if (arr[0].charAt(0) == '#') {
		} else {

			String array[] = arr[0].split("(?<=<)(?!>)|(?=<)|(?<=>)|((?<!<)(?=>))");// splits initial string into two
												// halves, beofre and after the <>

			String direction[] = array[1].split("(?<=\\W[<>])");// separates the >, <, or <> into its own array index

			String[] restData = array[2].split("[:|]|(?=\n)"); // splits the remaining string into the array
			graph.addVertex(array[0], null); // adds the locations as vertices
			graph.addVertex(restData[0], null);
			String check = "";
			if (restData.length == 6) { // checks if obstacles is empty, if so, sets it to 'none'
				check = "none";
			} else if (restData.length > 6) {
				check = restData[6];
			}
			if (restData[4].equals("")) {
				restData[4] = "none"; // checks if security is empty, if so, sets it to 'none'
			}
			if (direction[0].equals(">")) {
				// adds edges according to direction
				graph.addEdge(Double.parseDouble(restData[2]), array[0], restData[0], direction[0], restData[4], check);

			}

			else if (direction[0].equals("<")) {
				graph.addEdge(Double.parseDouble(restData[2]), restData[0], array[0], direction[0], restData[4], check);
			} else if (direction[0].equals("<>")) {
				// parses distance in as a double, so it can work with floats and ints
				graph.addEdge(Double.parseDouble(restData[2]), restData[0], array[0], direction[0], restData[4], check);
				graph.addEdge(Double.parseDouble(restData[2]), array[0], restData[0], direction[0], restData[4], check);
			}
		}
	}
	
	//Imports: String array to split and fill into journeyClass Object, int count to keep track of parameter 
	public static void processJourney(String[] arr, journeyClass journey, int count) {
		if (arr[0].charAt(0) == '#') {
		} else {
			String array[] = arr[0].split(" ");	//depending on the imported count variable, the method chooses which field of the object to set
			if (count == 6) {
				journey.setStart(array[1]);
			} else if (count == 7) {
				journey.setEnd(array[1]);
			} else if (count == 8) { // splits lines by " "
				if (array.length < 2) { // sets data into journey parameters using setter methods
					journey.setTime("");
				} else {
					journey.setTime(array[1]);
				}
			} else if (count == 9) {
				if (array.length < 2) {
					journey.setObstacles("noObstacles"); // if obstacles isnt there, sets it to 'noObstacles'
				} else {
					journey.setObstacles(array[1]);
				}
			} else if (count == 10) {
				if (array.length < 2) {
					journey.setSecurity(""); // if security isnt there, sets it to ""
				} else {
					journey.setSecurity(array[1]);
				}
			}

		}
	}
}
