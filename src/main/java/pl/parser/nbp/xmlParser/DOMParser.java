package pl.parser.nbp.xmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

  Logger logger = LoggerFactory.getLogger(DOMParser.class);

  public String[] getBuyAndSellRatesFromXmlFile(String path, String currency) {

    String[] buyAndSaleRate = new String[2];
    NodeList nodeList = getNodeListFromXmlFile(path);

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node nNode = nodeList.item(i);
      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) nNode;
        if (element.getElementsByTagName("kod_waluty").item(0).getTextContent().equals(currency)) {
          buyAndSaleRate[0] = element.getElementsByTagName("kurs_kupna").item(0).getTextContent();
          buyAndSaleRate[1] = element.getElementsByTagName("kurs_sprzedazy").item(0).getTextContent();
          break;
        }
      }
    }
    return buyAndSaleRate;
  }

  private NodeList getNodeListFromXmlFile(String path) {

    NodeList nodeList = null;

    try (InputStream input = new URL(path).openStream()) {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(input);
      document.getDocumentElement().normalize();

      nodeList = document.getElementsByTagName("pozycja");

    } catch (ParserConfigurationException ex) {
      logger.error("Parse configuration exception was throw.", ex);
    } catch (IOException ex) {
      logger.error("Input/Output exception was throw.", ex);
    } catch (SAXException ex) {
      logger.error("SAX exception was throw.", ex);
    }
    return nodeList;
  }
}
