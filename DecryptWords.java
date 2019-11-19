import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DecryptWords 
{
	
	public static void main(String []args) throws ScriptException, IOException
	{	  
		    
		    double result = 0;
		    double finalResult = 0;	
		    int Counter = -1;
		    int Ignore = 0;
		    
		    String finalOutput = "";
		   
		    boolean isGoing = false;
		    boolean isIgnore = true;
		    
		    Scanner nicsInput = new Scanner(System.in); // initiliaze Scanner
    		Base64.Decoder nicoleDecoder = Base64.getDecoder();
    		String fldName;
    		String userChoice;
    		// Constructs New Scanner
    		
    		System.out.println("Please open the folder or directory");
    		System.out.print("Enter Folder Name :");
    		fldName = nicsInput.nextLine(); // This is the input where folder name is get.
    		System.out.println("What do you want to do ? Type 'Read' to read files , Type 'Delete' to delete files , Type 'Decrypt' to decrypt files");
    		userChoice = nicsInput.nextLine();
    		String fileName;
         
    		
    		// To read the content on the files when Read is satisfied
            if (userChoice.equalsIgnoreCase("Read"))
            {
            	try (Stream<Path> paths = Files.walk(Paths.get("C:\\" +fldName))) // With C the default directory plus the folder you want to read
            	{
            	    paths
            	        .filter(Files::isRegularFile)
            	        .forEach(System.out::println);
            	} 	
            }
            
            // To delete files when Delete is satisfied
            else if(userChoice.equalsIgnoreCase("Delete"))
            {        	
            	System.out.println("Please enter the name of the file you want to delete");
            	fileName = nicsInput.nextLine();
            	Files.deleteIfExists(Paths.get("C:\\" +fldName + "\\" + fileName + ".txt")); 
            }
            
            // to decrypt when user inputs Decrypt
            else if (userChoice.equalsIgnoreCase("Decrypt"))
            {
            // Construct and Reads file with the extension
            File nicsFile = new File("C:\\" +fldName + "\\" +nicsInput.nextLine()+".txt");
            nicsInput = new Scanner(nicsFile); 
                       
            
            // Gets the encrypted message then decodes it then print
            String nicoleList = nicsInput.nextLine();
            String decodedString = new String(nicoleDecoder.decode(nicoleList));
            System.out.println(decodedString); // this is the Base 64 printed 
            
           	// close the file writer
            nicsInput.close();    
            
            // For making the input into arrays and splitting them with space
            String strS = decodedString; 
		 	String[] arrOfStr = strS.split(" "); 
		    
		 	// To Determine the limit
		 	int limit = arrOfStr.length;
		 	String input = "";
		   
		    while(isGoing==false)
		    {	  
		    Counter++;
		    	if (Counter != limit)
		    	{
		    		input=arrOfStr[Counter];	
		    		
		    	}
		    	else
		    	{
		    		// To end the while loop I use the engine to evaluate with MDAS
		    		isGoing = true;
		    		ScriptEngineManager manager = new ScriptEngineManager();
			        ScriptEngine engine = manager.getEngineByName("js");
			        Object resultS = engine.eval(finalOutput);
			        System.out.println(finalOutput + " = " + resultS);
			    	System.out.println("END OF PROCESSING!");
			    	
		    		
		    	}
		    	// Ignore determines if the value is a number not an operator
		    	Ignore=1;
		    	
		    	// The algorithm I used here is when the words is detected the result is concatenated and then stored individually to a new string
		    	input = input.replaceAll("-", " ");
		    	input = input.toLowerCase().replaceAll(" and", " ");
		        String[] splittedParts = input.trim().split("\\s+");

		            for(String str : splittedParts)
		            {
			                if(str.equalsIgnoreCase("zero")) {
			                    result += 0;		                   
			                }
			                else if(str.equalsIgnoreCase("one")) {
			                    result += 1;
			                }
			                else if(str.equalsIgnoreCase("two")) {
			                    result += 2;
			                }
			                else if(str.equalsIgnoreCase("three")) {
			                    result += 3;
			                }
			                else if(str.equalsIgnoreCase("four")) {
			                    result += 4;
			                }
			                else if(str.equalsIgnoreCase("five")) {
			                    result += 5;
			                }
			                else if(str.equalsIgnoreCase("six")) {
			                    result += 6;
			                }
			                else if(str.equalsIgnoreCase("seven")) {
			                    result += 7;
			                }
			                else if(str.equalsIgnoreCase("eight")) {
			                    result += 8;
			                }
			                else if(str.equalsIgnoreCase("nine")) {
			                    result += 9;
			                }
			                else if(str.equalsIgnoreCase("ten")) {
			                    result += 10;
			                }
			                else if(str.equalsIgnoreCase("eleven")) {
			                    result += 11;
			                }
			                else if(str.equalsIgnoreCase("twelve")) {
			                    result += 12;
			                }
			                else if(str.equalsIgnoreCase("thirteen")) {
			                    result += 13;
			                }
			                else if(str.equalsIgnoreCase("fourteen")) {
			                    result += 14;
			                }
			                else if(str.equalsIgnoreCase("fifteen")) {
			                    result += 15;
			                }
			                else if(str.equalsIgnoreCase("sixteen")) {
			                    result += 16;
			                }
			                else if(str.equalsIgnoreCase("seventeen")) {
			                    result += 17;
			                }
			                else if(str.equalsIgnoreCase("eighteen")) {
			                    result += 18;
			                }
			                else if(str.equalsIgnoreCase("nineteen")) {
			                    result += 19;
			                }
			                else if(str.equalsIgnoreCase("twenty")) {
			                    result += 20;
			                }
			                else if(str.equalsIgnoreCase("thirty")) {
			                    result += 30;
			                }
			                else if(str.equalsIgnoreCase("forty")) {
			                    result += 40;
			                }
			                else if(str.equalsIgnoreCase("fifty")) {
			                    result += 50;
			                }
			                else if(str.equalsIgnoreCase("sixty")) {
			                    result += 60;
			                }
			                else if(str.equalsIgnoreCase("seventy")) {
			                    result += 70;
			                }
			                else if(str.equalsIgnoreCase("eighty")) {
			                    result += 80;
			                }
			                else if(str.equalsIgnoreCase("ninety")) {
			                    result += 90;
			                }
			                else if(str.equalsIgnoreCase("hundred")) {
			                    result *= 100;
			                }
			                else if(str.equalsIgnoreCase("thousand")) {
			                    result *= 1000;
			                    finalResult += result;
			                    result=0;
			                }
			                else if (str.equalsIgnoreCase("plus")){      	
			                	finalOutput += "+";    
			                	isIgnore=false;
			                }
			                else if (str.equalsIgnoreCase("minus")){      	
			                	finalOutput += "-";  
			                	isIgnore=false;	
			                }
			                else if (str.equalsIgnoreCase("times")){      	
			                	finalOutput += "*";  
			                	isIgnore=false;	
			                }
			                else if (str.equalsIgnoreCase("divide")){      	
			                	finalOutput += "/";  
			                	isIgnore=false;	
			                }
			            }
		         
		            		// when true adds the result
				            if (isIgnore==true)
				            {		            	
				            	finalOutput += result;
				            	finalResult += result;        
						        result=0; 						      						        
				            }
				            
				            // when false ignore the result but plus the operator
				            else
				            {
				            	isIgnore=true;				           
				            }    
				            
		            }        
            }
            // Prints if user inputs wrong command
            else
            {
            	System.out.println("WRONG INPUT!!!");
            	
            }
	}
}
	

