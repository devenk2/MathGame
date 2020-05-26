import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				System.out.println("Hello! In this game you will have 30 seconds to answer as many math problems as you can");
				System.out.println("Ready to play? (yes/no)");
				Scanner initial = new Scanner(System.in);
				String ready = initial.next();
				if (ready.equals("yes")) {
					Runnable r = new Game();
					Thread t1 = new Thread(r);
					
					t1.start();
					
					Thread.sleep(30000);
					
					t1.interrupt();
					t1.join();
				}
				initial.close();
				System.out.println("Bye!");
				

	}

}
