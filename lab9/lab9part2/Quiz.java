//Necessary imports
import java.util.ArrayList;

//Quiz class, Constructor, play(), main()
public class Quiz 
{
	//ArrayList to hold
	private ArrayList<FlashCard> fcArray = new ArrayList<FlashCard>();
	//FlashCardReader to use
	private FlashCardReader fcReader;
	//Constructor | Input: void | Functionality: sets fcArray to the output of getFlashCards() defined in FlashCardReader.java
	private Toolbox toolbox;
	public Quiz(String filename)
	{
		fcReader = new FlashCardReader(filename);
		fcArray = fcReader.getFlashCards();
		toolbox = new Toolbox();
		this.play();
	}
	//Quiz method | Input: void | output: void | Functionality: keep setting the first element in the fcArray to a temporary FlashCard, print question, get answer, 
	//compare with actual answer, remove the first FlashCard in the array, continue while fcArray is not empty
	public void play()
	{
		FlashCard flashCard = fcArray.get(0);
		System.out.println	(flashCard.getQuestion());
		String guess = toolbox.readStringFromCmd();
		if(guess.equals(flashCard.getAnswer()))
		{
			System.out.println("Right!");
		}
		else
		{
			System.out.println("Wrong!");
			System.out.println(flashCard.getAnswer());
		}	
		fcArray.remove(0);
		if(!fcArray.isEmpty())
		{
			this.play();
		}
	}
	//Initialize a quiz object and do quiz.play()
	public static void main(String[] args)
	{
		Quiz quiz = new Quiz("Questions.txt");
	}
}