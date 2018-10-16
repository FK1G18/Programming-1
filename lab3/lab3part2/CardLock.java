public class CardLock
{
	private SmartCard lastCard;
	private boolean locked = true;
	private boolean studentAccess = false;

	public void swipeCard(SmartCard sc)
	{
		lastCard = sc;
		if(sc.isStaff())
		{
			locked = false;
		}
	}

	public SmartCard getLastCardSeen()
	{
		return lastCard;
	}

	public boolean isUnlocked()
	{
		return !locked;
	}

	public void toggleStudentAccess()
	{
		studentAccess = !studentAccess;
	}
}