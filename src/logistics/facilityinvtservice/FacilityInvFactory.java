package logistics.facilityinvtservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityInvFactory 
{

    public static FacilityInventorable build(String name, String itemId, int quantity)
    {
        return new FacilityInvImpl(name, itemId, quantity);
    }
}
