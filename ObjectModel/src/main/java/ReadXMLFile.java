import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface ReadXMLFile {

    default Map<Integer, Integer> readDataForSaladFromXMLFile(String fileName) {
        Map<Integer, Integer> keysFromXML = new HashMap<>();

        try {
        File file = new File(fileName);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();

        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        NodeList nodeLst = document.getElementsByTagName("ingredient");

        System.out.println("Information of all ingredients:");

        for (int s = 0; s < nodeLst.getLength(); s++) {

            Node fstNode = nodeLst.item(s);

            if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                Element fstElmnt = (Element) fstNode;
                NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("ingredientID");
                Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                NodeList fstNm = fstNmElmnt.getChildNodes();
                System.out.println("ingredientID : " + (fstNm.item(0)).getNodeValue());
                NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("weight");
                Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                NodeList lstNm = lstNmElmnt.getChildNodes();
                System.out.println("weight: " + (lstNm.item(0)).getNodeValue());

                int ingredientCode = Integer.parseInt((fstNm.item(0)).getNodeValue());
                int weight = Integer.parseInt((lstNm.item(0)).getNodeValue());

                keysFromXML.put(ingredientCode, weight);
            }
        }
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (org.xml.sax.SAXException e) {
            System.out.println(e.getMessage());
        }
        return keysFromXML;
    }
}

