//FlashCard CLass, String question, String answer, Constructor
public class FlashCard
{
	//Will hold the question
	private String question;
	//Will hold the answer
	private String answer;
	//Constructor | Input: String q, String a | Output: void | Functionality: sets question to q and answer to a
	public FlashCard(String q, String a)
	{
		question = q;
		answer = a;
	}
	//FlashCard method | Input: void | Output: String | Functionality: returns private variable question
	public String getQuestion()
	{
		return question;
	}
	//FlashCard method | Input: void | Output: String | Functionality: returns private variable answer
	public String getAnswer()
	{
		return answer;
	}
}