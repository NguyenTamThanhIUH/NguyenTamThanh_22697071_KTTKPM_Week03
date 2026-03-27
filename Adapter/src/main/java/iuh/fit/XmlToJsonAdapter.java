package iuh.fit;

public class XmlToJsonAdapter implements JsonService {

    private XmlService xmlService;

    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void process(String json) {
        // convert JSON -> XML (giả lập)
        String xml = convertJsonToXml(json);
        xmlService.processXML(xml);
    }

    private String convertJsonToXml(String json) {
        // demo đơn giản (không cần thư viện)
        return "<xml>" + json.replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                + "</xml>";
    }
}