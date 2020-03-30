package coburn_problem1;

import java.io.*;
import java.util.*;

public class DuplicateRemover {
	
	private List<String> uniqueWords = new ArrayList<String>();
	
	public void remove(String dataFile)
	{
		try(Scanner in = new Scanner(new File(dataFile)))
		{
			String word;
			while((word = in.next()) != null)
				if(!isDuplicate(word))
					uniqueWords.add(word);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isDuplicate(String word)
	{
		if(uniqueWords.isEmpty())
			return false;
		
		int wordCount = uniqueWords.size();
		
		for(int i = 0; i<wordCount; i++)
		{
			if(word.equals(uniqueWords.get(i)))
				return true;
		}
		
		return false;
	}
	 
	public void write(String outputFile)
	{
		try(FileOutputStream out = new FileOutputStream(outputFile))
		{
			int wordCount = uniqueWords.size();
			
			for(int i = 0; i<wordCount; i++)
				out.write(uniqueWords.get(i).getBytes());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
