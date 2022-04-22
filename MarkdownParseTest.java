import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks1() throws IOException {
      Path fileName = Path.of("test-file.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("https://something.com");
        add("some-thing.html");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void testGetLinks2() throws IOException {
      Path fileName = Path.of("test-file-2.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("hi.html");
        add("hi.html");
        add("hi.html");
        add("hi.html");
        add("hi.html");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void testGetLinks3() throws IOException {
      Path fileName = Path.of("buggy-test-file.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("1.html");
        add("2.html");
        add("3.html");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void testGetLinks4() throws IOException {
      Path fileName = Path.of("test-file-3.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("hi.html");
        add("bye.html");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test1() throws IOException {
      Path fileName = Path.of("tests/test-file.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("https://something.com");
        add("some-thing.html");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test2() throws IOException {
      Path fileName = Path.of("tests/test-file2.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("https://something.com");
        add("some-page.html");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test3() throws IOException {
      Path fileName = Path.of("tests/test-file3.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>();
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test4() throws IOException {
      Path fileName = Path.of("tests/test-file4.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>();
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test5() throws IOException {
      Path fileName = Path.of("tests/test-file5.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>(){{
        add("page.com");
      }};
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test6() throws IOException {
      Path fileName = Path.of("tests/test-file6.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>();
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test7() throws IOException {
      Path fileName = Path.of("tests/test-file7.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>();
      assertEquals(exp, MarkdownParse.getLinks(content));
    }

    @Test
    public void test8() throws IOException {
      Path fileName = Path.of("tests/test-file8.md");
      String content = Files.readString(fileName);
      ArrayList<String> exp = new ArrayList<>();
      assertEquals(exp, MarkdownParse.getLinks(content));
    }


}

