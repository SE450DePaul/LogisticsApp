package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public class FacilityImpl implements Facilitable
{
    private String facilityName;
    private Double facilityRate;
    private Double facilityCost;

    public FacilityImpl(String name, Double rate, Double cost)
    {
        setName(name);
        setRate(rate);
        setCost(cost);
    }

	public void setName(String name) 
	{
		facilityName = name;
	}

	public String getName() 
	{
		return facilityName;
	}

	public void setRate(Double rate) 
	{
		facilityRate = rate;
	}

	public Double getRate() 
	{
		return facilityRate;
	}
	
	public void setCost(Double cost) 
	{
		facilityCost = cost;
	}

	public Double getCost() 
	{
		return facilityCost;
	}
}
