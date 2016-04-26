package logistics.utilities.loaderservice;

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

import logistics.facilityinventoryservice.FacilityInventoryFactory;
import logistics.facilityinventoryservice.FacilityInventorable;
import logistics.utilities.exceptions.LoaderFileNotFoundException;

/**
 * 
 * @author David Olorundare
 *
 */

public class InventoryXmlLoaderImpl implements XmlLoadable
{

	 private String name;
	 private String itemId;
	 private int itemQty;
	 private String filepath;
	 private String itemQuantity;
	 
	 public InventoryXmlLoaderImpl() //String path)
	 {
	        filepath = "src/logistics/xmldata/facility_inventory.xml";
	 }
	
	    public void /*ArrayList<FacilityInventorable>*/ load() throws logistics.utilities.exceptions.LoaderFileNotFoundException 
	    {

	        ArrayList<FacilityInventorable> facilityinvs = new ArrayList<FacilityInventorable>();

	        try 
	        {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();

	            File xml = new File(filepath);
	            if (!xml.exists()) 
	            {
	                System.out.println("File does not exist"); /*throw new LoaderFileNotFoundException();*/
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
	             /*
	               NamedNodeMap attributes = node.getAttributes();
	              Node namedItem = attributes.getNamedItem("id");
	               String id = namedItem.getNodeValue();
	               */
	               
	             // Get a named nodes
	                Element element = (Element) facilityInvEntries.item(i);
	                NodeList nameNode = element.getElementsByTagName("name");
	                name = nameNode.item(0).getTextContent();
	                
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
	                    itemId = element.getElementsByTagName("id").item(0).getTextContent();
	                    itemQuantity = element.getElementsByTagName("quantity").item(0).getTextContent();
	                    itemQty = Integer.parseInt(itemQuantity);
	                    
	                 // Create a string summary of the item
	                    itemDescriptions.add(" " + itemId + "|Quantity: " + itemQuantity);
	                }    
	                
	                FacilityInventorable facilityinv = FacilityInventoryFactory.build(name, itemId, itemQty );

	                System.out.println("Facility " + i + ": " + name + "  Facility Items: " + itemDescriptions + "\n"); //" Facility Items: " + itemId + ", Quantity: " + itemQty + "\n");
	                facilityinvs.add(facilityinv);
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

	        //return facilityinvs;
	    }



	    public static void main(String[] args){

	        InventoryXmlLoaderImpl xmlLoader =  new InventoryXmlLoaderImpl();//"src/logistics/data/facility_inventory.xml");
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
