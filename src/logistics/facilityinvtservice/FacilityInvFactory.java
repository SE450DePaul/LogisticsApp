package logistics.facilityinvtservice;

/**
 * @author David Olorundare
 */
public class FacilityInvFactory 
{

    public static FacilityInventorable build(String name, String itemId, int quantity)
    {
        return new FacilityInvImpl(name, itemId, quantity);
    }
}
