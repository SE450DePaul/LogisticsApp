package logistics.utilities.loader;

import logistics.utilities.loader.XmlLoadable;
import logistics.utilities.loader.factory.XmlLoaderFactoryImpl;

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

	
	public XmlLoadable xmlload(String type, String path)
	{
		XmlLoadable loader = factory.build(type, path);
		return loader;
	}
	
	
}
