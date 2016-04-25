package logistics.utilities.loader.factory;

import logistics.utilities.loader.XmlLoadable;

/**
 * Created by david
 */
public interface LoaderFactory 
{
    XmlLoadable build(String file_type, String file_path);
        
}
