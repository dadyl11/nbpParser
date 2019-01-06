package pl.parser.nbp.xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

  public String[] getBuyAndSellRatesFromXmlFile(String path, String currency) {
    String[] buyAndSaleRate = new String[2];
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try (InputStream input = new URL(path).openStream()) {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(input);
      document.getDocumentElement().normalize();

      NodeList nodeList = document.getElementsByTagName("pozycja");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Node nNode = nodeList.item(i);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) nNode;
          if (element.getElementsByTagName("kod_waluty").item(0).getTextContent().equals(currency)) {
            buyAndSaleRate[0] = element.getElementsByTagName("kurs_kupna").item(0).getTextContent();
            buyAndSaleRate[1] = element.getElementsByTagName("kurs_sprzedazy").item(0).getTextContent();
          }
        }
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (ParserConfigurationException ex) {
      ex.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
    return buyAndSaleRate;
  }
}
