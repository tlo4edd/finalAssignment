public class unitTestDSAGraph
{
	public static void main (String [] args)
	{
		int count = 0;
		System.out.println("************Testing constructor and methods*************");
		System.out.println("Testing default constructor");
		try
		{

			DSAGraph graph = new DSAGraph();
			System.out.println("Passed constructor test\n");		//testing constructors
			count++;
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		DSAGraph graph = new DSAGraph();
		System.out.println("Testing addVertex method");
		try
		{
		graph.addVertex("A",null);
		graph.addVertex("B",null);
		graph.addVertex("C",null);
		graph.addVertex("D",null);			//adding vertices to test
		
		if(graph.getVertexCount() == 4)
		{
			System.out.println("Passed addVertex test\n");
			count++;

		}
		else
		{
			throw new IllegalArgumentException("Failed addVertex");
		}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing adding edges between vertices");
		try
		{

			graph.addEdge(0.0,"A","B",">","none","none");
			graph.addEdge(0.0,"A","C",">","none","none");
			graph.addEdge(0.0,"A","D",">","none","none");//adding edges from each vertice to 'A'
			if(graph.getAdjacent("A").getSize() == 3)
			{
				System.out.println("Passed adding edge test\n");
			count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed addEdge test\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing updateNode");
		try
		{
			graph.updateNode("A","x");
			if(graph.hasVertex("x"))
			{
				System.out.println("Passed updateNode test\n");		//changing node 'A' to 'X'
			count++;
			}
			else 
			{
				throw new IllegalArgumentException("Failed updateNode test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing find edge");
		try
		{
			if(graph.findEdge("x","B",0.0,"none","none"))
			{
				System.out.println("Passed findEdge test\n");		//finding edge
			count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed findEdge test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		
		System.out.println("Testing removeVertex");
		try
		{
			graph.removeVertex("D");
			if(!graph.hasVertex("D"))
					{
						System.out.println("Passed removeVertex\n");		//removing vertex 'D'
			count++;
					}
			else
			{
				throw new IllegalArgumentException("Failed removeVertex");
			}

		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}


		System.out.println("Testing displayWorld printing to file testGraph.txt");
		try
		{
			graph.displayWorld("testGraph.txt");
			System.out.println("Passed displayWorld test\n");		//testing display world method by writing to testgraph.txt
			count++;
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing remove edge");
		try{
			graph.removeEdge("x","B",0.0,"none","none");
			System.out.println("Attempting to 'find' removed edge");
			if(!graph.findEdge("newNode","B",0.0,"none","none"))
			{
				System.out.println("Passed remove edge test\n");
			count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed removeEdge test");		//removing edges from 'X' to 'B'
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing hasVertex");
		try
		{
			if(graph.hasVertex("C"))
			{
				System.out.println("Passed hasVertex test\n");
			count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed hasVertex test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		
		System.out.println("Testing isAdjacent");

		try
		{
			if(graph.isAdjacent("x","C"))
			{
				System.out.println("Passed isAdjacent test\n");
			count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed isAdjacent test");		//testing isAdjecent methods
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Adding another edge to 'x' to test sorter method");
		try
		{
			graph.addEdge(25.0,"x","z",">","none","none");
			graph.addEdge(12.5,"x","z",">","none","none");
			graph.sorter(graph.getAdjacent("x"),1);
			System.out.println("Passed sorting test\n");
			count++;
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		System.out.println("Testing ConvertKms and ConvertBack methods");
	       try
	       {
			graph.convertKms("metres");	//testing to see if conversions between kms and metres happening properly
			if(graph.findEdge("x","z",0.0125,"none","none"))
			{

	 			graph.convertBack("km");
				if(graph.findEdge("x","z",12.5,"none","none"))
				{
					System.out.println("Passed conversion test\n");
			count++;
				}
			}
			else
			{
				throw new IllegalArgumentException("Failed conversion test");
			}
	       }
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}		

		System.out.println("Testing adjacency Matrix, printing to file 'matrix.txt'");
	
		try
		{
			graph.displayMatrix("matrix.txt");
			System.out.println("Passed adjacency matrix test\n");	//printing out adjacency matrix to 'matrix.txt'
			count++;												//Z and C should be the only remaining edges to X
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		System.out.println("****************Passed "+count+"/13 tests*****************");








	
	

















	}
}




