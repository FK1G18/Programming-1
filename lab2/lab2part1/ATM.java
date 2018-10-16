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
	}
}