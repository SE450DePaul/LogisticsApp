package logistics.utilities.loader.factory;


import logistics.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.ItemXmlLoaderImpl;
import logistics.utilities.loader.XmlLoadable;

/**
 * Created by david
 */
public class XmlLoaderFactoryImpl implements LoaderFactory 
{

    public XmlLoadable build(String file_type, String filepath) 
    {
    	return new ItemXmlLoaderImpl(filepath);
    	/*
    	if (file_type.equals("xml"))
        {
            return new ItemXMLLoaderImpl(filepath);
        } */
    }
}
