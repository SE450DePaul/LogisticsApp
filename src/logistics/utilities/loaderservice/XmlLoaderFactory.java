package logistics.utilities.loaderservice;

/**
 * 
 * @author David Olorundare
 *
 */

// hopefully you do what I want !
public class XmlLoaderFactory 
{
	public static XmlLoadable buildLoader(String data)
	{
		if (data.equals("item"))
		{
			return new ItemXmlLoaderImpl();
		}
		else if (data.equals("facility"))
		{
			return new FacilityXmlLoaderImpl();
		}
		else if (data.equals("inventory"))
		{
			return new InventoryXmlLoaderImpl();
		}
		else
			return null; // dunno what this is
	}
}
