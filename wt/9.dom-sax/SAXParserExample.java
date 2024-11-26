import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the name of the XML document:");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String fileName = input.readLine();
            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
                try {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser saxParser = factory.newSAXParser();
                    DefaultHandler handler = new DefaultHandler() {
                        @Override
                        public void startDocument() {
                            System.out.println("Start of document");
                        }
                        @Override
                        public void endDocument() {
                            System.out.println("End of document");
                        }
                        @Override
                        public void startElement(String uri, String localName, String qName, Attributes attributes) {
                            System.out.println("Start element: " + qName);

                            for (int i = 0; i < attributes.getLength(); i++) {
                                System.out.println("    Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
                            }
                        }
                        @Override
                        public void endElement(String uri, String localName, String qName) {
                            System.out.println("End element: " + qName);
                        }
                        @Override
                        public void characters(char[] ch, int start, int length) {
                            String text = new String(ch, start, length).trim();
                            if (!text.isEmpty()) { // Ignore whitespace
                                System.out.println("Text content: " + text);
                            }
                        }
                    };
                    saxParser.parse(file, handler);
                    System.out.println(fileName + " is well-formed.");
                } catch (SAXException e) {
                    System.out.println(fileName + " is not well-formed. Error: " + e.getMessage());
                } catch (ParserConfigurationException | IOException e) {
                    System.out.println("Error processing the XML file: " + e.getMessage());
                }
            } else {
                System.out.println("File does not exist or is not a valid file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
