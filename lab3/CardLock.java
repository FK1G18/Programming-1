public class CardLock
{
	private SmartCard lastCard;
	private boolean isUnlocked = false;
	private boolean allowStudents = false;
	public void swipeCard(SmartCard sc)
	{
		lastCard = sc;
		if(sc.isStaff())
		{
			isUnlocked = true;
		}
		else if (allowStudents) 
		{
			isUnlocked = true;
		}
	}
	public SmartCard getLastCardSeen()
	{
		return lastCard;
	}
	public void toggleStudentAccess()
	{
		allowStudents = !allowStudents;
	}
	public boolean isUnlocked()
	{
		return isUnlocked;
	}
}