public class GuessingGame
{
	public static void main(String[] args)
	{
		//Prompt the user for input
		System.out.print("Hello there! Gimme a number from 1 to 10! \n");
		Toolbox myToolbox = new Toolbox();
		//Generate a random integer from 1 to 10
		int numberToGuess = myToolbox.getRandomInteger(10);
		int guessedNumber = myToolbox.readIntegerFromCmd();

		//if the guess is correct then output you're right
		if(guessedNumber == numberToGuess)
		{
			System.out.print("You're right!\n");
		}
		//if the guess is too low, inform the user
		if(guessedNumber < numberToGuess)
		{
			System.out.print("Too low!\n");
		}
		//if the guess is too high, inform the user
		if(guessedNumber > numberToGuess)
		{
			System.out.print("Too high!\n");
		}
	}

}