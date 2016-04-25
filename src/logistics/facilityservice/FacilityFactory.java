package logistics.facilityservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityFactory 
{

    public static Facilitable build(String facilityName, Double facilityRate, Double facilityCost)
    {
        return new FacilityImpl(facilityName, facilityRate, facilityCost);
    }
}
