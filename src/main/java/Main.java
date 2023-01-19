import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.xml";
        Document doc = createDoc(filePath);

        Parser parser = new Parser();
        List<Employee> employees = parser.parseXML(doc);
        employees.forEach(System.out::println);

        String jsonString = JsonConverter.listToJson(employees);
        System.out.println(jsonString);

        String jsonFile = "data2.json";
        JsonConverter.createJson(jsonString, jsonFile);
    }// main

    public static Document createDoc(String file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(file));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}// class