package logistics.utilities.loader.factory;

import java.util.ArrayList;

import logistics.utilities.loader.XmlLoadable;

/**
 * @author David Olorundare
 */
public interface LoaderFactory 
{
    ArrayList build(String file_type, String file_path, String data);
        
}
