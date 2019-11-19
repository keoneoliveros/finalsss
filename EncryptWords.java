import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;


public class EncryptWords 
{
	public static void main (String []args) throws IOException
	{
		Scanner nicsScanner = new Scanner(System.in);
		Base64.Encoder nicsEncode = Base64.getEncoder();
		ArrayList<String> nicsWords = new ArrayList<String>(); 
		String userWords;
		System.out.println("Do you want to create a new folder? Skip if already have existing one");
		System.out.println("Yes or No?");
		String userAnswer = nicsScanner.nextLine();
		
		if (userAnswer.equalsIgnoreCase("Yes"))
		{
			System.out.println("Please input folder name");
			String nicsFileName = nicsScanner.nextLine();
			File nicsfile = new File("C:\\" +nicsFileName);
		        if (!nicsfile.exists()) 
		        	{
		            if (nicsfile.mkdir()) 
		            {
		                System.out.println("Folder creation success");
		            } else 
		            {
		                System.out.println("Folder creation failure");
		            }
		        }
		}
		else
		{
			System.out.println("Skipped or Wrong input");
		}
		
		System.out.println("Welcome to Nicole Word To Number Encryptor please enter worded equation (Input :q to stop)" );
		boolean isSaving = false;
		String validation;
		String stringEncoded;
				 
		while(isSaving == false)
	    {
			validation = nicsScanner.nextLine();	  

				// if the user inputs the stop message it will terminate the loop
				if(validation.equals(":q"))
				{
					isSaving = true;
				}	
				// if the use hasn't put the stop message then the loop continues and add more words
				else
				{
				stringEncoded = nicsEncode.encodeToString(validation.getBytes());
				nicsWords.add(stringEncoded);
				System.out.println("Encoded: " +stringEncoded);
				}
				
	    }
		
		// Prompt the user if input or not
		System.out.println("Do you want to save your encrypted data to a file? Yes/No");
		String answer = nicsScanner.nextLine();
		
		// If yes continue
		if(answer.equalsIgnoreCase("Yes"))
		{
			System.out.println("Input folder name");
			String folderName = nicsScanner.nextLine();
			System.out.println("Input file name:");
			String fileName = nicsScanner.nextLine();
			Writer nicsWriter = new FileWriter("C:\\" +folderName +"\\"+fileName + ".txt");
		
			for(String listToWords: nicsWords)
		    {
		    nicsWriter.write(listToWords);
		    }
		    nicsWriter.close();
		}
		
		
		
	}
}
