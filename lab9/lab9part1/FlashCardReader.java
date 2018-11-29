//Necessary imports
import java.io.BufferedReader;
import java.io.FileReader;
//Import the exceptions thrown
import java.io.FileNotFoundException;
import java.io.IOException;
//Class FlashCardReader, BufferedReader reader, boolean isReady, String line, methods: Constructor, getLine(), fileIsReady()
public class FlashCardReader
{
	//reader to be used
	private BufferedReader reader;
	//boolean used to indicate whether or not the file is ready
	private boolean isReady;
	//String used to temporarily store readLine() output
	private String line = "";
	//boolean used to see if the file was found or not
	private boolean notFound = false;

	//FlashCardReader Constructor | Input: String filename | Functionality: sets a FileReader to a BufferedReader, catches FileNotFoundException
	public FlashCardReader(String filename)
	{	
		try
		{
			FileReader freader = new FileReader(filename);
			reader = new BufferedReader(freader);
		} catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found!");
			notFound = true;
		}
	}
	//FlashCardReader method | Input: void | Output: String | Functionality: stores the output from readLine() to line and returns it
	public String getLine()
	{
		try
		{
			line = reader.readLine();
		} catch (IOException ioe)
		{
			//
		}

		return line;
	}

	//FlashCardReader method | Input: void | Output: boolean | Functionality: stores the output from ready() to isReady and returns it
	public boolean fileIsReady()
	{
		try
		{

			if(notFound)
			{
				isReady = false;
			}
			else
			{
				isReady = reader.ready();
			}
			

		} catch (IOException ioe)
		{
			//
		}

		return isReady;
	}
}