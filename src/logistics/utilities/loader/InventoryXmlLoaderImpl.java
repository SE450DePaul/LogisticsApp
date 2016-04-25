package logistics.utilities.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.ItemFactory;
import logistics.itemservice.Itemable;

public class InventoryXmlLoaderImpl implements XmlLoadable
{

	 private String filepath;
	 public InventoryXmlLoaderImpl(String path)
	 {
	        filepath = path;
	 }
	
	    public ArrayList<Itemable> load() throws LoaderFileNotFoundException 
	    {

	        ArrayList<Itemable> items = new ArrayList<Itemable>();

	        try 
	        {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();

	            File xml = new File(filepath);
	            if (!xml.exists()) 
	            {
	                /*System.out.println("File does not exist")*/throw new LoaderFileNotFoundException();
	            }

	            Document doc = db.parse(xml);
	            Element documentElement = doc.getDocumentElement();
	            documentElement.normalize();

	            NodeList facilityInvEntries = documentElement.getChildNodes();
	            for (int i = 0; i < facilityInvEntries.getLength(); i++) 
	            {
	                Node node = facilityInvEntries.item(i);
	                if (node.getNodeType() == Node.TEXT_NODE) 
	                {
	                    continue;
	                }

	                String entryName = node.getNodeName();
	                if (!entryName.equals("facility")) 
	                {
	                    continue;
	                    //Or perhaps throw an error
	                }

	                NamedNodeMap attributes = node.getAttributes();
	                Node namedItem = attributes.getNamedItem("id");
	                String id = namedItem.getNodeValue();
	                Element element = (Element) facilityInvEntries.item(i);
	                NodeList nameNode = element.getElementsByTagName("name");
	              //  Double price = Double.parseDouble(priceNode.item(0).getTextContent());
	                
	             // Get all nodes named "Item" - there can be 0 or more
	                ArrayList<String> itemDescriptions = new ArrayList<>();
	                NodeList itemList = element.getElementsByTagName("item");
	                for (int j = 0; j < itemList.getLength(); j++) 
	                {
	                    if (itemList.item(j).getNodeType() == Node.TEXT_NODE) 
	                    {
	                        continue;
	                    }

	                    entryName = itemList.item(j).getNodeName();
	                    if (!entryName.equals("item")) 
	                    {
	                        System.err.println("Unexpected node found: " + entryName);
	                        
	                    }

	                    // Get some named nodes
	                    element = (Element) itemList.item(j);
	                    String itemId = element.getElementsByTagName("id").item(0).getTextContent();
	                    String itemQuantity = element.getElementsByTagName("quantity").item(0).getTextContent();
	                    
	                 // Create a string summary of the item
	                    itemDescriptions.add(itemId + "with Quantity " + itemQuantity);
	                }    
	                
	                
	                

	                Itemable item = ItemFactory.build(id, price);

	                System.out.println("No " + i + ": Item price: " + price + " Item Id: " + id);
	                items.add(item);
	            }
	        } 
	        catch (ParserConfigurationException e) 
	        {
	            e.printStackTrace();
	        } 
	        catch (SAXException e) 
	        {
	            e.printStackTrace();
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }

	        return items;
	    }



	    public static void main(String[] args){

	        InventoryXmlLoaderImpl xmlLoader =  new InventoryXmlLoaderImpl("src/data/facilty_inventory.xml");
	        try 
	        {
	            xmlLoader.load();
	        } 
	        catch (LoaderFileNotFoundException e) 
	        {
	            e.printStackTrace();
	        }
	    }

}
