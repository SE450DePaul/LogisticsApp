package logistics.facilityinventoryservice;

/**
 * @author David Olorundare
 */

//This class need a review to validate its usefulness
public class FacilityInvDTO 
{

    public String id;
    public Double price;

    public FacilityInvDTO(String id, Double price)
    {
        this.id = id;
        this.price = price;
    }
}
