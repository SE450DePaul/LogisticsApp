package logistics.facilityinvtservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityInvFactory 
{

    public static FacilityInventorable build(String id, Double price)
    {
        return new FacilityInvImpl(id, price);
    }
}
