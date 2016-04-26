package logistics.utilities.loaderservice;

import java.util.ArrayList;

import logistics.utilities.loaderservice.XmlLoadable;

/**
 * 
 * @author David Olorundare
 *
 */
public class LoaderService 
{
	private volatile static LoaderService instance;
	private XmlLoaderFactoryImpl factory;
	
	private LoaderService()
	{
		
	}
	
	
	public static LoaderService getInstance() 
    {
        if (instance == null)
        {
            synchronized (LoaderService.class)
            {
                if (instance == null)
                {
                    instance = new LoaderService();
                }
            }
        }
        return instance;
    }

	
	public ArrayList xmlload(String type, String path, String data)
	{
		ArrayList loader = factory.build(type, path, data);
		return loader;
	}
	
	
}
