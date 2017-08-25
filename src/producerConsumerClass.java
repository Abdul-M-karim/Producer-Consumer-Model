import java.util.LinkedList;
public  class producerConsumerClass {
	LinkedList<Character> listOfJobs = new LinkedList<>(); // use a linkedList to hold the list of jobs 
	int MAX_SIZE = 5; // there can be a max of 5 jobs 
	
	public void producer() throws InterruptedException{
		char val = 'A'; // starts with character A 
		while (true) { // infinite while loop
			synchronized (this)// no more than one thread may access this block of code
			{
				while (listOfJobs.size() == MAX_SIZE) // while the list of jobs is full
					wait(); // wait while the list of jobs is full
				System.out.println("produced :" + val); // or if you produced just go ahead and print produced val
				listOfJobs.add(val++);// add the printed value onto the list of jobs linkedList
				notify(); // notify is a function that notifys the waiting thread to wake once called
				Thread.sleep(1000); // slow this down a bit to see this sucker working 
			}
		}
	}

public void consumer() throws InterruptedException {
	while ( true ){ // infinite while loop
		synchronized ( this) // no more than one thread may access this block of code
		{
			while ( listOfJobs.size() < 5 ) // while the linkedList of jobs is empty 
				wait();// wait if list of jobs is not less than 5 
			char val = listOfJobs.removeFirst();// remove the job if full
			System.out.println( "Consumed:" + val ); // print out what we just consumed
			notify(); // notify the other thread to wake.. and produced
			Thread.sleep(1000); // slow this sucker down a bit to see it working
				
		}
}
}
}

