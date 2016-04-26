package logistics.facilityinventoryservice;

/**
 * @author David Olorundare
 */

//This class need a review to validate its usefulness
public class FacilityInventoryDTO 
{

    public String id;
    public Double price;

    public FacilityInventoryDTO(String id, Double price)
    {
        this.id = id;
        this.price = price;
    }
}
