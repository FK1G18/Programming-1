public class ATM
{
	public static void main(String[] args)
	{
		//Initiqalize ATM object and a Toolbox
		ATM myATM = new ATM();
		myATM.go();
	}		


	public static void go()
	{
		Toolbox myToolbox = new Toolbox();

		//Output welcoming message and ask for input
		System.out.print("Welcome to online ATM banking\n" + "How much do you want in your account?\n");
		int balance = myToolbox.readIntegerFromCmd();
		System.out.println(balance);
		System.out.println("What do you want to do?");
		System.out.println("1 : Withdraw");
		System.out.println("2 : Deposit");
		System.out.println("3 : Inquire");
		System.out.println("4 : Quit");
		int choice = myToolbox.readIntegerFromCmd();

		if(choice == 1)
		{
			//stars() is a function specifically designed to output the stars between outputs so as to not crowd the code
			stars();
			System.out.println("         Withdrawal");
			stars();
			System.out.println("How much would you like to withdraw?");
			int withdrawal = myToolbox.readIntegerFromCmd();

			//while the withdrawal is more than the balance or if it is invalid ask for input again
			while(withdrawal > balance || withdrawal < 0)
			{
				System.out.println("Invalid input, please try again!");
				withdrawal = myToolbox.readIntegerFromCmd();
			}
			//Subtract the withdrawal from the balance
			balance = balance - withdrawal;
			stars();
			//print the current balance
			System.out.println("      Your new balance is " + balance);
			stars();
		}

		if(choice == 2)
		{
			stars();
			System.out.println("         Deposit");
			stars();
			System.out.println("How much would you like to deposit?");
			int deposit = myToolbox.readIntegerFromCmd();

			//while the deposit is a negative number, ask for input again
			while(deposit < 0)
			{
				System.out.println("Invalid input, please try again!");
				deposit = myToolbox.readIntegerFromCmd();
			}
			balance = balance + deposit;
			stars();
			System.out.println("      Your new balance is " + balance);
			stars();
		}
		if(choice == 3)
		{
			stars();
			//Just print out the balance
			System.out.println("Your balance is " + balance);
			stars();
		}
		if(choice == 4)
		{
			stars();
			System.out.println("Goodbye!");
			stars();
			//Exit the program with a return value of 0
			System.exit(0);
		}

	}

	public static void stars()
	{
		System.out.println("*********************************");
	}
}
