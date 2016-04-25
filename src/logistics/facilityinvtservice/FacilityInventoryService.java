package logistics.facilityinvtservice;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.XmlLoadable;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.itemservice.ItemDTO;
import logistics.utilities.loader.factory.XmlLoaderFactoryImpl;

import java.util.ArrayList;

/**
 * Created by david
 */
public final class FacilityInventoryService 
{

    private volatile static FacilityInventoryService instance;
    
    private ArrayList<FacilityInventorable> items = new ArrayList<FacilityInventorable>();
    
    private XmlLoaderFactoryImpl loader;
    private XmlLoadable file;

    private FacilityInventoryService() 
    {
          /*  loader = new XmlLoaderFactoryImpl();
    		
            
            try 
            {
                items = loader.load();
            } 
            catch (LoaderFileNotFoundException e) 
            {
                e.printStackTrace();
            }*/
    }

   /* public XmlLoadable xmlload(String filetype, String filepath) 
    {
    	
    }*/
    
    public static FacilityInventoryService getInstance() 
    {
        if (instance == null)
        {
            synchronized (FacilityInventoryService.class)
            {
                if (instance == null)
                {
                    instance = new FacilityInventoryService();
                }
            }
        }
        return instance;
    }


/*    public ItemDTO getItem(int i)
 * {
        Item item = items.get(i);
        if (item == null) return null;
        return new ItemDTO(item.getId(), item.getPrice());
    }

    public static void main(String[] args)
    {

        ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();
        ItemDTO itemDTO = itemCatalogService.getItem(0);
        System.out.println("Please get first item");
        System.out.println(" Item id: " + itemDTO.id + " Item price: " + itemDTO.price);

    }
*/
}
