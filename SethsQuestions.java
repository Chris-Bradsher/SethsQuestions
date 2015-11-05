package sethsquestions;

import java.util.Scanner;

public class SethsQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean doMore=false;
		boolean validInput=false;
		
		Scanner switchscanner = new Scanner(System.in);
		int swtch=0;
		String doRepeat="";
		do {
		System.out.println("Enter 1-4 to execute the code for the respective challenge.");
		try {
		swtch = Integer.parseInt(switchscanner.nextLine());
		} catch (NumberFormatException e){
			swtch=0;
			System.out.println("Invalid input, type Y then put in 1-4.");
		}
		switch (swtch) {
		case 1:
			questionOne();
			break;
		case 2:
			questionTwo();
		break;
		case 3:
			questionThree();
		break;
		case 4:
			questionFour();
		break;
		default:
			//This gets called when the numberformatexception happens because swtch will be 0.
		break;
		}
		
		System.out.println("Do another challenge? Y/N");
		validInput=false;
		while (validInput==false){
			doRepeat = switchscanner.nextLine();
			if (doRepeat.equals("Y") || doRepeat.equals("y") || doRepeat.equals("Yes") || doRepeat.equals("yes") || doRepeat.equals("N") || doRepeat.equals("n") || doRepeat.equals("No") || doRepeat.equals("no")){
				validInput=true;
			} else {
				System.out.println("Please enter a valid input.");
			}
		}
		if (doRepeat.equals("Y") || doRepeat.equals("y") || doRepeat.equals("Yes") || doRepeat.equals("yes")){
			doMore=true;
		} else {
			doMore=false;
			System.out.println("Goodbye!");
		}
		} while (doMore==true);
		
		
	} //end main
	
	static void questionOne(){
		int posnumber=1;
		double temp=0;
		boolean isDivisible=false;
		do {
			if (posnumber%232792==0){ //Progress bar for the user
				if ((((double)posnumber/232792000)*100)%((double)2.5)==0){
					System.out.println(((double)posnumber/232792000) * 100 + "%");
				}
			}
			
			isDivisible=true; //set divisible to true
			for (int i=1; i<=20; i++){ //go through all the numbers 1-20
				if (posnumber%i !=0){ //if posNumber / i has a remainder that isn't zero
					isDivisible=false; //posNumber is not divisible by all the numbers 1-20.
				}
			}
			//At this point isDivisible is correct for posnumber. If isDivisible is true, none of the #s
			//1-20 failed to divide it, so the loop breaks when it reaches the while statement and 
			//posnumber is outputted.
			//If isDivisible is false, move to the next posNumber
			if (isDivisible==false){
				posnumber++;
			}
		} while (isDivisible==false);
		System.out.println("Answer = " + posnumber);
	}
	
	static void questionTwo() {
		int runningSum=0;
		int numberbeingTested=1;
		while (numberbeingTested<1000){
			if (numberbeingTested%5==0){ //If divisible by 5
				runningSum += numberbeingTested;
			} else if (numberbeingTested%3==0 && numberbeingTested%5!=0){ //If divisible by 3 and not 5
				runningSum += numberbeingTested;
			}
			numberbeingTested++;
		}
		System.out.println("Answer: " + runningSum);
	}
	
	static void questionThree() {
		Scanner q3 = new Scanner(System.in);
		boolean playAgain=false;
		boolean validInput=false;
		String usersChoice="";
		int userChoice=0;
		int compChoice=0;
		do {
			validInput=false; //reset booleans
			playAgain=false;
			System.out.println("Let's play! Which do you choose?");
			while (validInput==false){
				usersChoice = q3.nextLine();
				if (usersChoice.equals("Rock") || usersChoice.equals("rock")){
					validInput=true;
					userChoice=0;
				} else if (usersChoice.equals("Paper") || usersChoice.equals("paper")){
					validInput=true;
					userChoice=1;
				} else if (usersChoice.equals("Scissors") || usersChoice.equals("scissors")){
					validInput=true;
					userChoice=2;
				} else {
					System.out.println("Please enter a valid input");
				}
			}
			
			compChoice=(int)(Math.random()*3);
			switch (compChoice){
			case 0:
				System.out.println("I choose Rock!");
			break;
			case 1:
				System.out.println("I choose Paper!");
			break;
			case 2:
				System.out.println("I choose Scissors!");
			break;
			}

			if (compChoice==userChoice){ //tie
				System.out.println("A tie! We both picked " + usersChoice);
			} else if ((userChoice-1==compChoice) || (userChoice==0 && compChoice==2)){ //player win
				System.out.println("You have bested me! Such amazing rock-paper-scissors skill! How could you possible have out-randomed me?");
			} else {
				System.out.println("Fool human! You can never defeat me! My processor can pick random numbers far better than you!");
			}
			
			System.out.println("\n" + "Shall we play again? Y/N");
			validInput=false;
			while (validInput==false){
				usersChoice=q3.nextLine();
				if (usersChoice.equals("Y") || usersChoice.equals("y") || usersChoice.equals("Yes") || usersChoice.equals("yes") || usersChoice.equals("N") || usersChoice.equals("n") || usersChoice.equals("No") || usersChoice.equals("no")){
					validInput=true;
				} else {
					System.out.println("Please enter a valid input.");
				}
			}
			if (usersChoice.equals("Y") || usersChoice.equals("y") || usersChoice.equals("Yes") || usersChoice.equals("yes")){
				playAgain=true;
			} else {
				playAgain=false;
				System.out.println("Fleeing from my rock-paper-scissors prowess, eh? Coward!");
			}
		} while (playAgain==true);
	}

	static void questionFour() {
		boolean breakYet=false; //Makes sure we don't pass 4 million
		long result=0; //result
		int fibL=1, fibG=1, fibC=0; //FibL=lower of the two fibonacci numbers being remembered
		//FibG = greater of the two fibonacci numbers being remembered
		//FibC is a transfer variable
		while (breakYet==false){ //While not yet broken
			System.out.println("FibL: " + fibL + " FibG: " + fibG);
			//Move to the next set of fibonacci numbers
			fibC=fibG; //store the old value of FibG
			fibG=fibG+fibL; //set greater value to greater+lesser
			fibL=fibC; //set the lesser to the old FibG
			if (fibG%2==0){
				result+=fibG;
				System.out.println("Result is now " + result);
			}
			if (fibG>4000000){
				breakYet=true;
			}
		}
		System.out.println("Answer is: " + result);
	}
}
