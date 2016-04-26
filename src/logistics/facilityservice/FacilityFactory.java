package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public class FacilityFactory 
{

    public static Facilitable build(String facilityName, Double facilityRate, Double facilityCost)
    {
        return new FacilityImpl(facilityName, facilityRate, facilityCost);
    }
}
