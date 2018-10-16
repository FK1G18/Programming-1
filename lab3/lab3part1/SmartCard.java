public class SmartCard
{
	//Initialize private variables that will return the name and
	// the property of the object
	private static String name;
	private static boolean isStaff;

	//Returns the boolean isStaff thus allowing access to a private boolean
	public static Boolean isStaff()
	{
		return isStaff;
	}

	//Changes the type of the object, thus modifying a private boolean
	public static void setStaff(boolean type)
	{
		isStaff = type;
	}

	//Returns the name of the object, thus allows access to a private string
	public static String getOwner()
	{
		return name;
	}
	// Constructor of the class
	public SmartCard(String ownerName)
	{
		//Set the constructor input as the name of the object
		name = ownerName;

	}

	public static void main(String[] args)
	{
		//Create a new smartcard object with the name "Filip"
		SmartCard mySmartCard = new SmartCard("Filip");

	}
}