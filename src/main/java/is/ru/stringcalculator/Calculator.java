package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		String criteria = "/" + "/";
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains(criteria)){
			String delimiter = text.valueOf(2);
			String sub = text.substring(4);
			for(int i = 0; i < sub.length(); i++)
			{
				char c = sub.charAt(i);
				String c2 = Character.toString(c);
				if(delimiter.equals(c2))
				{
					sub = sub.replace(delimiter, ",");
				}
			}
			 return sum(splitNumbers(sub));
		}
		else
			return 1;
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



}
