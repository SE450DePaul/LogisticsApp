package logistics.facilityservice;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class FacilityImpl implements Facilitable
{
    private String id;
    private Double price;

    public FacilityImpl(String id, Double price)
    {
        setId(id);
        setPrice(price);
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
}
