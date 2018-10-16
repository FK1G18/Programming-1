public class ATM
{
	public static void main(String[] args)
	{
		ATM myATM = new ATM();
		Toolbox myToolbox = new Toolbox();
		System.out.println("Welcome to online ATM banking");
		System.out.println("How much do you want in your account?");
		int balance = myToolbox.readIntegerFromCmd();
		while(balance < 0)
		{
			System.out.println("Invalid input, please try again!");
			balance = myToolbox.readIntegerFromCmd();
		}
		myATM.go(balance);
	}

	public static void go(int balance)
	{
		Toolbox myToolbox = new Toolbox();
		System.out.println("What do you want to do?");
		System.out.println("1 : Withdraw");
		System.out.println("2 : Deposit");
		System.out.println("3 : Inquire");
		System.out.println("4 : Quit");
		int choice = myToolbox.readIntegerFromCmd();

		if(choice == 1)
		{
			stars();
			System.out.println("         Withdrawal");
			stars();
			System.out.println("How much would you like to withdraw?");
			int withdrawal = myToolbox.readIntegerFromCmd();
			while(withdrawal > balance || withdrawal < 0)
			{
				System.out.println("Invalid input, please try again!");
				withdrawal = myToolbox.readIntegerFromCmd();
			}
			balance = balance - withdrawal;
			stars();
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
			System.out.println("Your balance is " + balance);
			stars();
		}
		if(choice == 4)
		{
			stars();
			System.out.println("Goodbye!");
			stars();
			System.exit(0);
		}

		go(balance);

	}

	public static void stars()
	{
		System.out.println("*********************************");
	}
}