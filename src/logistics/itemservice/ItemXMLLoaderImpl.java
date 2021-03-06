package logistics.itemservice;


import logistics.exceptions.LoaderFileNotFoundException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class ItemXMLLoaderImpl implements ItemLoader{

    private String filepath;
    public ItemXMLLoaderImpl(String filepath){
        this.filepath = filepath;
    }

    public Item[] load() throws LoaderFileNotFoundException {

        ArrayList<Item> items = new ArrayList<Item>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            File xml = new File(filepath);
            if (!xml.exists()) {
                throw new LoaderFileNotFoundException();
            }

            Document doc = db.parse(xml);
            Element documentElement = doc.getDocumentElement();
            documentElement.normalize();

            NodeList itemEntries = documentElement.getChildNodes();
            for (int i = 0; i < itemEntries.getLength(); i++) {
                Node node = itemEntries.item(i);
                if (node.getNodeType() == Node.TEXT_NODE) {
                    continue;
                }

                String entryName = node.getNodeName();
                if (!entryName.equals("item")) {
                    continue;
//                    Or perhaps throw an error
                }

                NamedNodeMap attributes = node.getAttributes();
                Node namedItem = attributes.getNamedItem("id");
                String id = namedItem.getNodeValue();
                Element element = (Element) itemEntries.item(i);
                NodeList priceNode = element.getElementsByTagName("price");
                String price = priceNode.item(0).getTextContent();
//
//                Item item = new ItemImpl();
//                item.setPrice(price);
//                item.setId(id);

                System.out.println("No " + i + ": Item price: " + price + " Item Id: " + id);
//                items.add(item);

            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Item[10];
    }



    public static void main(String[] args){

        ItemXMLLoaderImpl xmlLoader =  new ItemXMLLoaderImpl("data/item_catalog.xml");
        try {
            xmlLoader.load();
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
