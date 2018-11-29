//Necessary imports
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
//Quiz class, 
public class Quiz 
{
	//ArrayList to hold
	private ArrayList<FlashCard> fcArray = new ArrayList<FlashCard>();
	//FlashCardReader to use
	private FlashCardReader fcReader;
	//boolean used to see whether or not the user has answered the current question correctly
	private boolean ansTrue = false;
	//Will be used to check whether or not the player will want to save their answers
	private static boolean beSaved = false;
	//Necessary to write to a txt file
	private PrintWriter savefile;
	//The guess provided by the user, is made class-wide because of the need for it in other methods other than play()
	private String guess;
	//Boolean used to determine whether or not the game is over
	private boolean finished = false;
	//Counter used to measure the amount of correct answers given by the player - it is a float due to it being used to calculate a percentage
	private Double counterAns = 0.0;
	//Counter used to measure the amount of questions tackled by a player - it is a float due to it being used to calculate a percentage
	private Double counterQue = 1.0;
	//Toolbox to be used later on
	private Toolbox toolbox;
	private boolean started = false;

	//Constructor | Input: void | Functionality: sets fcArray to the output of getFlashCards() defined in FlashCardReader.java
	public Quiz(String filename)
	{	
		
		fcReader = new FlashCardReader(filename);
		fcArray = fcReader.getFlashCards();
		toolbox = new Toolbox();
			try
			{
				savefile = new PrintWriter("save.txt");

			} catch(FileNotFoundException fnfe)
			{
				System.out.println("Could not save");
			}
		this.play();
	}
	//Quiz method | Input: void | output: void | Functionality: keep setting the first element in the fcArray to a temporary FlashCard, print question, get answer, 
	//compare with actual answer, if beSaved == true then save the answer, remove the first FlashCard in the array, continue while fcArray is not empty, else display result and close stream
	public void play()
	{	
		if(!started)
		{
			System.out.println("Want your answers saved? (Y/N)");	
			String ans = toolbox.readStringFromCmd();
			if(ans.equals("Y"))
			{
				beSaved = true;
			}			

			started = true;
		}


		//Get first question, print it and wait for input
		FlashCard flashCard = fcArray.get(0);
		System.out.println(flashCard.getQuestion());
		guess = toolbox.readStringFromCmd();

		//Compare input with answer
		if(guess.equals(flashCard.getAnswer()))
		{
			System.out.println("Right!");
			ansTrue = true;
			//increment the amount of correct answers given if correct
			counterAns = counterAns + 1;
		}
		else
		{
			System.out.println("Wrong!");
			System.out.println(flashCard.getAnswer());
			ansTrue = false;
		}
		//if the user has chosen to save the input then do so
		if(beSaved)
		{
			this.save();
		}
		//Remove the current flashcard so that the next one is tackled on the next iteration
		fcArray.remove(0);
		//While the arrayList is not empty, keep on recursively calling play() and increment the questions counter
		if(!fcArray.isEmpty())
		{
			counterQue = counterQue + 1;
			this.play();
		}
		//Otherwise, calculate and print out the results and close the stream
		else
		{
			finished = true;
			this.save();
			savefile.close();
		} 
	}

	//Quiz method | input: void | output: void | Functionality: if the quiz hasnt finished, save the current question, answer that was given and whether or not it was correct
	//Else, print out the Number of questions asked, the number of questions answered correctly, and the corresponding percentage score.
	public void save()
	{

		if(!finished)
		{
			FlashCard flashCard = fcArray.get(0);
			savefile.flush();
			savefile.write(flashCard.getQuestion());
			savefile.write(", ");
			savefile.write(guess);
			savefile.write(", ");
			savefile.write(Boolean.toString(ansTrue));
			savefile.println();
		}
		else
		{
			savefile.flush();
			Double percentage = ((counterAns / counterQue) * 100);
			savefile.print(counterAns);
			savefile.write(", ");
			savefile.print(counterQue);
			savefile.write(", ");
			savefile.print(percentage);
		}

	}
	//Ask the user if their answers want to be saved, change the beSaved variable to true if so and then go on to initialize and use play() on a quiz object
	public static void main(String[] args)
	{
		Quiz quiz1 = new Quiz("Questions.txt");
	}
}