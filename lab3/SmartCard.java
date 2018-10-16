public class SmartCard
{
	private static String name;
	private static boolean isStaff;
	public static Boolean isStaff()
	{
		return isStaff;
	}
	public static void setStaff(boolean type)
	{
		isStaff = type;
	}
	public static String getOwner()
	{
		return name;
	}
	public SmartCard(String ownerName, boolean type)
	{
		name = ownerName;
		isStaff = type;

	}

	public static void main(String[] args)
	{
		SmartCard mySmartCard = new SmartCard("Filip", false);
		/*
		System.out.println(getOwner());
		System.out.println(isStaff());
		CardLock myCardLock = new CardLock();
		myCardLock.swipeCard(mySmartCard);
		System.out.println(myCardLock.getLastCardSeen());
		System.out.println(myCardLock.isUnlocked());
		myCardLock.toggleStudentAccess();
		myCardLock.swipeCard(mySmartCard);
		System.out.println(myCardLock.getLastCardSeen());
		System.out.println(myCardLock.isUnlocked());
		mySmartCard.setStaff(true);
		myCardLock.swipeCard(mySmartCard);
		System.out.println(myCardLock.getLastCardSeen());
		System.out.println(myCardLock.isUnlocked());
		*/

		Door door1 = new Door();
		door1.setRoomName("Research Labs");
		CardLock cd1 = new CardLock();
		cd1.toggleStudentAccess();
		door1.attachLock(cd1);
		cd1.swipeCard(mySmartCard);
		door1.openDoor();
		mySmartCard.setStaff(true);
		cd1.swipeCard(mySmartCard);
		door1.openDoor();


	}
}