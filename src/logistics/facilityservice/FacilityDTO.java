package logistics.facilityservice;

/**
 * @author David Olorundare
 */

// This class need a review to validate its usefulness
public class FacilityDTO 
{

    public String id;
    public Double price;

    public FacilityDTO(String id, Double price)
    {
        this.id = id;
        this.price = price;
    }
}
