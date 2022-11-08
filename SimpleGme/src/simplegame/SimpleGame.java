package simplegame;
import java.util.Scanner;

/**
 * In this assignment, you will implement a simple game.  This game has 2 options for the user playing.  Based on user input, the 
 * user can choose to either convert time, from seconds to hours, minutes, and seconds, or calculate the sum of all digits in an integer.  
 * 
 * At the beginning of the game, the user will be prompted to input either 1 or 2, to indicate which option of the game they want 
 * to play.  1 will indicate converting time, and 2 will indicate calculating the sum of digits in an integer.
 * 
 * For converting time, the user will be prompted to input a number of seconds (as an int) and the program will call a method that 
 * will convert the seconds to time, in the format hours:minutes:seconds, and print the result.  For example, if the user enters 6734, 
 * the program will print the time, 1:52:14. As another example, if the user enters 10,000, the program should print 2:46:39.
 * 
 * For calculating the sum of digits in an integer, the user will be prompted to input a number (as a non-negative int) and the program will 
 * call a method to calculate the sum of the digits in that number, and print the result.  For example, if the user enters 321, 
 * the program will print the sum, 6, because the individual digits in the number add up to 6.  3 + 2 + 1 = 6.
 * 
 * Each method has been defined for you, but without the code. See the javadoc for each method for instructions on what the method 
 * is supposed to do and how to write the code. It should be clear enough.  In some cases, we have provided hints to help you get started.
 * 
*/


public class SimpleGame {

	/**
	 * Write a method to convert the given seconds to hours:minutes:seconds.
	 * @param seconds to convert
	 * @return string for the converted seconds in the format: 23:59:59
	 * 
	 * Example(s): 
	 * - If input seconds is 1432, print and return output in the format: 0:23:52
	 * - If input seconds is 0, print and return output in the format: 0:0:0
	 * - If input seconds is not valid (negative), print and return: -1:-1:-1.  
	 *   So if input seconds is -2, print and return: -1:-1:-1 
	 *   If input seconds is -3214, likewise print and return: -1:-1:-1
	 */
	
	public String convertTime(int seconds) {
		String time;
		if (seconds < 0){
			time = "-1:-1:-1";
		}else
			{
			if (seconds == 0){
				time = "0:0:0";
			}else
				{
				int m = 0;
				int h = 0;
				int s = 0;
				
				while(seconds > 59) {
					seconds -= 60; 
					m += 1;
					if (m == 60) {
						h += 1;
						m = 0;
					}
				}
				time = h + ":" + m + ":" + seconds;				
			}	 
		}
		return time;
	}
	
	
	/**
	 * Write a method that adds all the digits in the given non-negative integer.
	 * @param integer to add digits
	 * @return integer in which all the digits in the given non-negative integer are added.
	 * 
	 * Example(s): 
	 * - If input is 565, print and return 16.
	 * - If input is 7, print and return 7.
	 * - If input is 0, print and return 0.
	 */
	
	//String str = "cit";
	//char firstChar = str.charAt(0); //firstChar is ‘c’
	
	public int digitsSum(int input) throws Exception {
		if (input < 0){
			throw new Exception("The input is negative");
		}else{
			String str = Integer.toString(input);
			int cont = 0;
			int num;
			for(int k=0;k<str.length();k++){
				char Char = str.charAt(k);
				num = Integer.parseInt(String.valueOf(Char));
				cont += num;
			}
		
		return cont;
	
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Create an instance of the SimpleGame class.
		SimpleGame simplegame = new SimpleGame();
			
		Scanner sc = new Scanner(System.in);
				
		// Ask the user which game to play.
		System.out.println("Whichs game would you like to play? \n 1 will indicate converting time \n 2 will indicate calculating the sum of digits in an integer.");
			
		// Then ask the user for input and pass the value to the corresponding method.
		int number = sc.nextInt();
				
		// If the user enters 1, ask for an integer to convert and call the convertTime method.
		// If the user enters 2, ask for an integer and call the digitsSum method.

		if (number == 1) {
			System.out.println("Type an integer to convert");
			int input1 = sc.nextInt();
			String value1 = simplegame.convertTime(input1);
			System.out.println(value1);
		}else{
			System.out.println("Type an integer to sum its digits");
			int input2 = sc.nextInt();
			int value2 = simplegame.digitsSum(input2);
			System.out.println(value2);
		}
					
		sc.close();
	}

}
