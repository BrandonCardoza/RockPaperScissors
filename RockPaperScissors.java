import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	private static int playerMove;
	private static int playerScore;
	private static int cpuScore;

	public static void main(String[] args) throws InterruptedException
	{
		Random rand = new Random();
		String playAgain = "y";

		System.out.print("You've been challenged to a game of rock paper scissors! Do you accept?" + 
				"(y or n): ");
		
		Scanner scan = new Scanner(System.in);
		String decision = scan.nextLine();
		while(!(decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("n")))
			{
				System.out.print("\nEnter a valid choice: ");
				decision = scan.next();
			}
		if(decision.equalsIgnoreCase("y"))
		{
			System.out.println("\nGood luck, I hear this guy's really good!");
		}
		else
		{
			System.out.println("\nChicken");
			playAgain = "n";
		}
		
		while(playAgain.equalsIgnoreCase("y"))
		{
			cpuScore = 0;
			playerScore = 0;
			System.out.println("\nWe'll do best 2 out of 3");
			while(cpuScore < 2 && playerScore < 2)
			{
				System.out.print("\nEnter your choice (Rock, Paper, Scissors):");
				String move = scan.next();
				
				switch(move.toLowerCase())
				{
					case("rock"):
					{
						playerMove = 0;
						break;
					}
					
					case("paper"):
					{
						playerMove = 1;
						break;
					}
					
					case("scissors"):
					{
						playerMove = 2;
						break;
					}
					default:
						playerMove = 3;
						System.out.print("\nEnter a valid move: ");
				}
				
				if(playerMove < 3)
				{
					int opponentMove = rand.nextInt(3);
					
					System.out.println();
					System.out.println("Rock!");
					Thread.sleep(500);
					System.out.println("Paper!");
					Thread.sleep(500);
					System.out.println("Scissors!");
					Thread.sleep(500);
					System.out.println("Shoot!");
					System.out.println();
					
					if(opponentMove == 0) 
					{
						if(playerMove == 0) 
						{	
							System.out.println("You both played rock");
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
						else if(playerMove == 1)
						{
							System.out.println("You played paper and your opponent played rock");
							playerScore++;
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
						else if(playerMove == 2)
						{
							System.out.println("You played scissors and your opponent played rock");
							cpuScore++;
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
					}
					else if(opponentMove == 1) 
					{
						if(playerMove == 1) 
						{
							System.out.println("You both played paper");
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
						else if(playerMove == 2)
						{
							System.out.println("You played scissors and your opponent played paper");
							playerScore++;
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
						else if(playerMove == 0)
						{
							System.out.println("You played rock and your opponent played paper");
							cpuScore++;
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
					}
					else if(opponentMove == 2) 
					{
						if(playerMove == 2) 
						{
							System.out.println("You both played scissors");
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
						else if(playerMove == 1)
						{
							System.out.println("You played paper and your opponent played scissors");
							cpuScore++;
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
						else if(playerMove == 0)
						{
							System.out.println("You played rock and your opponent played scissors");
							playerScore++;
							System.out.println("Current Score: You - " + playerScore + " Opponent - " + cpuScore);
						}
					}
				}
			}
			
			System.out.println();
			if(playerScore == 2)
			{
				System.out.println("You win, Congrats!");
			}
			else
			{
				System.out.println("You lost, try again :(");
			}
			
			System.out.print("Play again? (y or n): ");
			playAgain = scan.next();
			
			while(!(playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("n")))
			{
				System.out.print("\nEnter a valid choice (y or n): ");
				playAgain = scan.next();
			}
		}
		
		System.out.println("Good game!");
		scan.close();
	}

}
