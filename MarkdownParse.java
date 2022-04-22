//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        boolean checkFirst = false;
        int firstVal = -1;
        while(currentIndex < markdown.length()) {
            int exclamation = markdown.indexOf("!", currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", currentIndex);
            int closeParen = markdown.indexOf(")", openParen);
            
            // Break if it's an image (!()[]) format
            if (openBracket - exclamation == 1 && exclamation != -1) {
                break;
            }

            // Break if a bracket or paren is missing
            if (openBracket == -1 || openParen == -1 || openParen == -1 || closeParen == -1) {
                break;
            }
            currentIndex = closeParen + 1;

            // Break if loop repeats over the MD file
            if (currentIndex == firstVal) {
                break;
            }
            
            if (markdown.substring(openParen + 1, closeParen).contains(".")) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            if (!checkFirst) {
                firstVal = currentIndex;
                checkFirst = true;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);

    }
}
