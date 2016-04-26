package logistics.utilities.loaderservice;


import java.util.ArrayList;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Itemable;

/**
 * @author David Olorundare
 */
public class XmlLoaderFactoryImpl implements LoaderFactory 
{
		
	public ArrayList build(String file_type, String filepath, String data)  
    {
		try {
			return new ItemXmlLoaderImpl(filepath).load();
		} catch (LoaderFileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	/*	if (file_type.equals("xml") && (data.equals("item")))
    	{
			
    	}
		
		
    	
 /*   	if (file_type.equals("xml"))
    	{
    		return new ItemXmlLoaderImpl(filepath);
    	}
    	else if (file_type.equals("facility"))
    	{
    		return new FacilityXmlLoaderImpl();
    	}
    	else if (file_type.equals("inventory"))
    	{
    		return new InventoryXmlLoaderImpl();
    	}*/
    }
}