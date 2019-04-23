package chat.model;

import java.util.ArrayList;

public class Chatbot
{

	public ArrayList<String> getResponseList()
	{
		return responseList;
	}

	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}
	public String getContent()
	{
		return content;
	}
	public String getCurrentUser()
	{
		return currentUser;
	}
	public String getJoke()
	{
		return joke;
	}
	public String getChatbot()
	{
		return Chatbot;
	}
	public String getSimplebot()
	{
		return simplebot;
	}
	
	
	
	private String content;

	private String currentUser;

	private String joke;
	
	private ArrayList<String> spookyList;
	
	private ArrayList<String> responseList;
	
	private String Chatbot;
	
	private String simplebot;
	
	

	public Chatbot()
	{
		this.joke = "me";
		this.content = new String("wiggle");
		this.currentUser = new String("wobble");

		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();

	}

	private void buildTheLists()
	{
		responseList.add("f");
		responseList.add("oof");
		responseList.add("k");
		responseList.add("yikes");

		spookyList.add("Holloween");
		spookyList.add("boo");
		spookyList.add("my grades");
		spookyList.add("Vlad Putin");
		spookyList.add("poor");
		spookyList.add("failure");
		spookyList.add("F");
		spookyList.add("lose");
	}

	public boolean legitimacyChecker(String input)

	{
		boolean isValid = true;
		if (input == null)
		{
			isValid = false;
		}
		else if (input.length()< 1)
		{
			isValid = false;
		}
		else if (input.contains("sdf") || input.contains("jkl"))
		{
			isValid = false;
		}

		return isValid;
	}

	public Boolean spookyChecker(String userText)
	{
		boolean isSpooky = true;
		
		
		for(String Phrase : SpookyList)
		{
			if (userText.contains(Phrase))
			{
				isSpooky = true;
			}
		}
		
		if (userText.contains("Halloween"))
		{
			isSpooky = true;
		}
		else if (userText.contains("Easter"))
		{
			isSpooky = false;
		}
		
		return isSpooky;
		
	}
	
	
	public String processText(String userText)
	{
		
	/**	
		userInput += "You said: " + userText;
		botAnswer += "Chatbot says: " + responseList;
				
		return userInput + botAnswer;
		**/
		
		String answer = "";
		if (userText == null)
		{
			answer += "Dont send null";
		}
		else 
		{
			answer += "You said: " + userText;
			
			if(contentChecker(userText))
			{
				answer += "You said the special words";
			}
		}
		int randomIndex = (int) (responseList.size() * Math.random());
		return answer += "Chatbot says: " + responseList.get(randomIndex);
	}

	public Chatbot(String string)
	{
		content = "sample content";
	}


}
	    
	

