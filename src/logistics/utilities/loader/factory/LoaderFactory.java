package logistics.utilities.loader.factory;

import java.util.ArrayList;

import logistics.utilities.loader.XmlLoadable;

/**
 * Created by david
 */
public interface LoaderFactory 
{
    ArrayList build(String file_type, String file_path, String data);
        
}
