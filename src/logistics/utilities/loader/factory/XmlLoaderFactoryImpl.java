package logistics.utilities.loader.factory;


import java.util.ArrayList;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.FacilityXmlLoaderImpl;
import logistics.utilities.loader.InventoryXmlLoaderImpl;
import logistics.utilities.loader.ItemXmlLoaderImpl;
import logistics.utilities.loader.XmlLoadable;
import logistics.itemservice.Itemable;

/**
 * Created by david
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
