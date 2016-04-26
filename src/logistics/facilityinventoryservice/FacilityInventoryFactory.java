package logistics.facilityinventoryservice;

/**
 * @author David Olorundare
 */
public class FacilityInventoryFactory 
{

    public static FacilityInventorable build(String name, String itemId, int quantity)
    {
        return new FacilityInventoryImpl(name, itemId, quantity);
    }
}
