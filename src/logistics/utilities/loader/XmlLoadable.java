package logistics.utilities.loader;

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Itemable;

import java.util.ArrayList;

/**
 * @author David Olorundare
 */
public interface XmlLoadable 
{
    ArrayList<Itemable> load() throws LoaderFileNotFoundException;

}
