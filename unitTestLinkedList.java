public class unitTestLinkedList
{
	public static void main (String[] args)
	{	int count = 0;		//keep track of tests passed	
		System.out.println("*************Testing constructors and methods*************\n\n");
		System.out.println("Testing default constructor");
		try
		{	//initial test: constructor
			LinkedList testList = new LinkedList();
			System.out.println("Passed constructor test\n");	//testing constructors
				count++;
		}
		catch(Exception e)
		{
			System.out.println("Failed test error: " + e);
		}
		LinkedList testList = new LinkedList();
		System.out.println("Testing insert and remove functions");
		System.out.println("Testing insertFirst");
		
		try
		{
			testList.insertFirst("insertFirstTest");
			if(testList.getSize() == 1)
			{
				System.out.println("Passed insertFirst\n");//inserting string into list
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed insertFirst");
			}
		}
		
		catch(Exception e)
		{
			System.out.println("Failed test. Error: " + e);
		}
		System.out.println("Testing insertLast");
		
		try
		{
			testList.insertLast("lastOne");//inserting 3 more strings into the bottom of the list
			testList.insertLast("lastTwo");
			testList.insertLast("lastThree");
			if(testList.getSize() == 4 )
			{
				System.out.println("Passed insertLast\n");//checking list size to ensure Strings have been inserted
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed insertLast");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		System.out.println("Testing removeFirst");
		try
		{
			String test = testList.removeFirst().toString();//testing removeFirst by checking if the removed object is the same as the first string inserted
			if(test.equals("insertFirstTest"))
			{
				System.out.println("Passed removeFirst test\n");
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed removeFirst test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing removeLast");
		try
		{
			String test = testList.removeLast().toString();//testing removeLast by checking if removed object is the same as last inserted String
			if(test.equals("lastThree"))
			{
				System.out.println("Passed removeLast test\n");
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed removeLast test\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Testing peekFirst method");
		try
		{
			String test = testList.peekFirst().toString();//testing to see if string at the 'top' of list is the new 'first' item
			if(test.equals("lastOne"))
			{
				System.out.println("Passed peekFirst test\n");
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed peekFirst test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error:"+e);
		}

		System.out.println("Testing peekLast method");
		try
		{
			String test = testList.peekLast().toString();
			if(test.equals("lastTwo"))
			{
				System.out.println("Passed peekLast test\n");
				count++;
			}		//testing peeklast by checking if last item in list is last inserted item
			else
			{
				throw new IllegalArgumentException("Failed peekLast test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}

		System.out.println("Removing all objects from list");
		try
		{
			testList.removeLast();
			testList.removeLast();//removing all objects to test isEmpty()
		}
		catch(Exception e)
		{
			System.out.println("Could not remove "+e);
		}

		System.out.println("Testing isEmpty");
		try
		{
			if(testList.isEmpty())
			{
				System.out.println("Passed isEmpty test\n");
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed isEmpty test");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}


		System.out.println("Inserting ints 1,2,3,4 using insertLast to test remaining functions");
		try
		{

			testList.insertLast(1);
			testList.insertLast(2);//inserting 4 ints
			testList.insertLast(3);
			testList.insertLast(4);
		}
		catch(Exception e)
		{
			System.out.println("Failed to insert "+e);
		}
		System.out.println("Testing 'specific' remove function");
		try
		{
			int test = (int)testList.remove(2);
			if(test == 2)//testing specific remove function, to see if list can remove a specific object
			{
				System.out.println("Passed 'specific' remove function\n");
				count++;
			}
			else
			{
				throw new IllegalArgumentException("Failed remove");
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed test. Error: "+e);
		}
		
		System.out.println("Passed "+count+"/9 tests");



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}






