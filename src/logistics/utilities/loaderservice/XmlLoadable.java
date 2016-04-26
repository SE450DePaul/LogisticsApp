package logistics.utilities.loaderservice;

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Itemable;

import java.util.ArrayList;

/**
 * @author David Olorundare
 */
public interface XmlLoadable 
{
    /*ArrayList<Itemable>*/public void load() throws LoaderFileNotFoundException;

}
