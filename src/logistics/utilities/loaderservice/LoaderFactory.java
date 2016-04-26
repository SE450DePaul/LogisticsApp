package logistics.utilities.loaderservice;

import java.util.ArrayList;

/**
 * @author David Olorundare
 */
public interface LoaderFactory 
{
    ArrayList build(String file_type, String file_path, String data);
        
}
