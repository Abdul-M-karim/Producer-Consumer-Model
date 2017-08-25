import java.utli.LinkedList;
public class Threads {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final producerConsumerClass produceConsume = new producerConsumerClass();// create a object for the class
	Thread Thread1 = new Thread( new Runnable(){ //  implement a version of run for runnable
		public void run(){ // had to use try catch would give error otherwise
			try {
				produceConsume.producer(); // produce
			} catch (InterruptedException e) { // or give error
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		});
	Thread Thread2 = new Thread( new Runnable(){ // implement a version of run for Runnable
			public void run(){
			try {
				produceConsume.consumer(); // consume
			} catch( InterruptedException e) { // or give error
				e.printStackTrace();
			}
			}
	});
	Thread1.start(); // required to actually create a new thread so that runnable run method is executed at the same time
	Thread2.start();// required to actually create a new thread so that runnable run method is executed at the same time
	
	// this means that thread1 will finish before thread2
	Thread1.join();
	Thread2.join();
	
	
}
}
