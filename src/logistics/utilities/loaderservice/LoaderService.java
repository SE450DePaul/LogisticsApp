package logistics.utilities.loaderservice;

import logistics.utilities.loaderservice.XmlLoadable;

/**
 * 
 * @author David Olorundare
 *
 */
public class LoaderService 
{
	private volatile static LoaderService instance;
	
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

	
	public XmlLoadable xmlload(String data)
	{
		XmlLoadable loader = XmlLoaderFactory.buildLoader(data);
		return loader;
	}
	
	// Placeholder method
	public void returnLoadedData()
	{
		// method should return data/DTO to caller, this data could either be
		// assembled by either the xmlloader implementations or by a dedicated
		// DTO assembler pattern or factory.
	}
}
