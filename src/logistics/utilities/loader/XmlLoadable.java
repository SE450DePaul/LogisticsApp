package logistics.utilities.loader;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Itemable;

import java.util.ArrayList;

/**
 * Created by david
 */
public interface XmlLoadable 
{
    ArrayList<Itemable> load() throws LoaderFileNotFoundException;

}
