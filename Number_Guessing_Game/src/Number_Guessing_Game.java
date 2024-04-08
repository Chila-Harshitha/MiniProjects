import java.util.Random;
import java.util.Scanner;
public class Number_Guessing_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = scan.nextLine();
    
    System.out.println("Well,H "+name+" I am thinking of a number between 1 and 20!");
    int myNumber= getRandomNumber(1,21);
    for(int i=0;i<6;i++) {
    	Scanner scan2=new Scanner(System.in);
    			System.out.println("Take a guess.");
    			int yourGuess=scan2.nextInt();
    			if(yourGuess == myNumber) {
    				System.out.println("You guessed correctly.");
    				break;
    			}
    			else if (yourGuess < myNumber) {
    				System.out.println("Your guess is too low.");
    			}
    			else if (yourGuess > myNumber) {
    				System.out.println("Your guess is too high.");
    			}
    			if (i>=5) {
    				//if the user guess the answer too many times
    				System.out.println();
    				System.out.println("Nope. The number I was thinking of was "+myNumber+"!");
                }
          }
	}
	
	
	public static int getRandomNumber(int min,int max) {
		Random rand=new Random();
		return rand.ints(min,max).findFirst().getAsInt();
	}

}

