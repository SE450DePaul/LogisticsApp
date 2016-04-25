package logistics.utilities.loader;

import logistics.exceptions.LoaderFileNotFoundException;

import java.util.ArrayList;

/**
 * Created by david
 */
public interface XmlLoadable 
{
    ArrayList load() throws LoaderFileNotFoundException;

}
