import static org.junit.Assert.*;// to import Assert methods
import org.junit.*;// to import JUnit
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {// to create class called MarkdownParseTest
    
    @Test// annotation to indicate a junit test
    public void addition(){//to create method called subtraction
        assertEquals(2,1+1);// to verify if 1+1 equals 2
    }//end Test

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(links, List.of("https://something.com","some-thing.html"));
    }//end Test

}//end class
