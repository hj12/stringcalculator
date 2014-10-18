package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

		String criteria = "/" + "/";
		try
        	{
        		checkForNegatives(text);
        	}

    		catch (IllegalArgumentException e)
    		{
    			System.out.println(e.toString());
    		}

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains(criteria)){
			char delimiter = text.charAt(2);
	                String d = Character.toString(delimiter);
			
			String sub = text.substring(4);
			for(int i = 0; i < sub.length(); i++)
			{
				char c = sub.charAt(i);
				String c2 = Character.toString(c);
				if(d.equals(c2))
				{
					sub = sub.replace(d, ",");
				}
			}
			 return sum(splitNumbers(sub));
		}
		else
			return 1;
	}

	public static boolean hasOverThousand(String text){
	int counter = 0;
	for(int i = 0; i < text.length(); i++)
	{
		char c = text.charAt(i);
		if(Character.isDigit(c))
		{
			counter++;
		}
		else
		{
			counter = 0;
		}
		if(counter >= 4)
		{
			return true;
		}
	}
	
	return false;
}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");
	}

    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

	private static boolean checkForNegatives(String text)
{
	if(text.contains("-"))
	{
		String outcome = "";
		for(int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			String s = Character.toString(c);
			if(s.equals("-"))
			{
				char c2 = text.charAt(i + 1);
				String s2 = Character.toString(c2);
				outcome = outcome + "-" + s2 + " ";
			}
		}
		
		throw new IllegalArgumentException("Negatives not allowed:" + outcome);
		
	}

	return false;
}

}
