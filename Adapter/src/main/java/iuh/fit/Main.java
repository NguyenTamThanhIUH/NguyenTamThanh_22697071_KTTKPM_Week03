package iuh.fit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String jsonData = "{ \"name\": \"Thanh\", \"age\": 22 }";

        XmlService xmlService = new XmlService();

        JsonService adapter = new XmlToJsonAdapter(xmlService);

        adapter.process(jsonData);
    }
}