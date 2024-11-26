import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class DOMParser {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the name of the XML document:");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String fileName = input.readLine();
            File file = new File(fileName);

            if (file.exists()) {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    InputSource inputSource = new InputSource(fileName);
                    Document document = builder.parse(inputSource);
                    System.out.println(fileName + " is well-formed.");
                } catch (Exception e) {
                    System.out.println(fileName + " is not well-formed.");
                }
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input.");
        }
    }
}
