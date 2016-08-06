package test;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class PairParentheses {
	
	public static void main(String[] args) {
        String userInputPattern = new String("(1+2) * (2+3))");
        try {
            Pattern.compile(userInputPattern);
        } catch (PatternSyntaxException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }
        System.out.println("Syntax is ok.");
    	
	}


}
