public class Demo
{
	public static void main(String[] args)
	{
		FlashCardReader fcr = new FlashCardReader("Questions.txt");
		System.out.println(fcr.getLine());
		System.out.println(fcr.fileIsReady());
	}
}