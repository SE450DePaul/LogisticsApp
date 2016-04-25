package logistics.facilityinvtservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityInvFactory 
{

    public static Itemable build(String id, Double price)
    {
        return new FacilityInvImpl(id, price);
    }
}
