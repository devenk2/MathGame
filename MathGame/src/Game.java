import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Game implements Runnable {

	Integer score;
	
	public String[] getMathProblem() {
		char[] signs = {'+', '-', '*'};
		int num1 = (int) (Math.random() * 20);
		int num2 = (int) (Math.random() * 20);
		char sign = signs[(int) Math.floor(Math.random() * 3)];
		int answer = 0;
	    if (sign == '+') {
	        answer = num1 + num2;
	    }else if (sign == '-') {
	        answer = num1 - num2;
	    } else {
	        answer = num1 * num2;
	    }
	    String problem = Integer.toString(num1) + " " + sign + " " + Integer.toString(num2);
	    String[] result = {problem, Integer.toString(answer)};
	    return result;
	}
	
	
	public void run() {
		try {
			
			score = 0;
			System.out.println("Go!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Scanner scan = new Scanner(reader);
			while(!Thread.currentThread().isInterrupted()) {
				String[] set = getMathProblem();
				String problem = set[0];
				int answer = Integer.parseInt(set[1]);
				System.out.printf(problem + "%n");
				int guess = answer - 1;
				try {
					while(!reader.ready()) {
						Thread.sleep(100);
					}
					guess = scan.nextInt();
					if(Thread.currentThread().isInterrupted()) {
						scan.close();
						throw new InterruptedException();
					}
				} catch(InputMismatchException e) {
			        //executes when this exception occurs
			        System.out.println("Input has to be a number. ");
			        scan.next();
			        continue;
			    } catch (InterruptedException e) {
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(guess == answer) {
					System.out.println("Right!");
					score++;
				} else {
					System.out.println("Wrong! The answer was: " + answer);
				}
				
			}
			scan.close();
			throw new InterruptedException();
		} 
		catch(InterruptedException e) 
		{
			System.out.println('\n' + "Times Up!");
			System.out.println("You got " + score + " problem(s) correct!");
		}
	}


//	public void timeExpired() {
//		// TODO Auto-generated method stub
//		t1
//	}
}
	
