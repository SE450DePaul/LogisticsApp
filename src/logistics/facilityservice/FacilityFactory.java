package logistics.facilityservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityFactory 
{

    public static Facilitable build(String id, Double price)
    {
        return new FacilityImpl(id, price);
    }
}
