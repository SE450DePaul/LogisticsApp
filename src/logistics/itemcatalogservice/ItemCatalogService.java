package logistics.itemcatalogservice;

import logistics.itemcatalogservice.ItemDTO;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loaderservice.XmlLoadable;

import java.util.ArrayList;

/**
 * Created by david
 */
public final class ItemCatalogService 
{

    private volatile static ItemCatalogService instance;
    
    private ArrayList<Itemable> items = new ArrayList<Itemable>();
    
    private ItemCatalogService() 
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
    
    public static ItemCatalogService getInstance() 
    {
        if (instance == null)
        {
            synchronized (ItemCatalogService.class)
            {
                if (instance == null)
                {
                    instance = new ItemCatalogService();
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
