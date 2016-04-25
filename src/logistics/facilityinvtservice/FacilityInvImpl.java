package logistics.facilityinvtservice;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class FacilityInvImpl implements Itemable
{
    private String id;
    private Double price;

    public FacilityInvImpl(String id, Double price)
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
