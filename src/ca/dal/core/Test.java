package ca.dal.core;

import ca.dal.exceptions.ArgNotValidException;

public class Test {
	public static void isDigit(String str)throws ArgNotValidException
    {
		// convert string in to char array
        char num[] = str.toCharArray();
        for(int k = 0; k < num.length; k++)
        {
        	// check if input is valid
            if(!Character.isDigit(num[k]))
            {
                String message = "\n" + "Arguments are not valid!";
                throw new ArgNotValidException(message);
            }
        }
    }
}
