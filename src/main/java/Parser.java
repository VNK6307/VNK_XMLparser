import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Employee> parseXML(Document doc) {
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        NodeList staff = doc.getElementsByTagName("employee");
        for (int i = 0; i < staff.getLength(); i++) {
            Node node = staff.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                employee = new Employee();
                employee.setId(Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent()));
                employee.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
                employee.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
                employee.setCountry(element.getElementsByTagName("country").item(0).getTextContent());
                employee.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
                employees.add(employee);
            }
        }
        return employees;
    }
}// class
