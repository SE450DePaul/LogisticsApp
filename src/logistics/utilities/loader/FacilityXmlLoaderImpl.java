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

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.ItemFactory;
import logistics.itemservice.Itemable;

/**
 * 
 * @author David Olorundare
 *
 */
public class FacilityXmlLoaderImpl implements XmlLoadable
{

	 private String filepath;
	 public FacilityXmlLoaderImpl(String path)
	 {
	        filepath = path;
	 }
	
	    public ArrayList<Facilitable> load() throws LoaderFileNotFoundException 
	    {

	        ArrayList<Facilitable> facilities = new ArrayList<Facilitable>();

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

	            NodeList facilityEntries = documentElement.getChildNodes();
	            for (int i = 0; i < facilityEntries.getLength(); i++) 
	            {
	                Node node = facilityEntries.item(i);
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

	               /* NamedNodeMap attributes = node.getAttributes();
	                Node namedItem = attributes.getNamedItem("id");
	                String id = namedItem.getNodeValue();*/
	                
	                Element element = (Element) facilityEntries.item(i);
	                NodeList nameNode = element.getElementsByTagName("name");
	                NodeList rateNode = element.getElementsByTagName("rate");
	                NodeList costNode = element.getElementsByTagName("cost");
	                
	                String name = nameNode.item(0).getTextContent();
	                Double rate = Double.parseDouble(rateNode.item(0).getTextContent());
	                Double cost = Double.parseDouble(costNode.item(0).getTextContent());
	                
	                Facilitable facility = FacilityFactory.build(name, rate, cost);

	                System.out.println("Facility " + i + " : " + name + " Rate: " +  rate + " Cost: " + cost);
	                facilities.add(facility);
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

	        return facilities;
	    }



	    public static void main(String[] args){

	        FacilityXmlLoaderImpl xmlLoader =  new FacilityXmlLoaderImpl("src/data/facilities.xml");
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
