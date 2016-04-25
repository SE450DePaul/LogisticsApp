package logistics.facilityinvtservice;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class FacilityInvImpl implements FacilityInventable
{
    private String facilityName;
    private String inventoryId;
    private Integer inventoryQuantity;

    public FacilityInvImpl(String name, String invenId, Integer invenQuantity)
    {
        setName(name);
        setItemId(invenId);
        setQuantity(invenQuantity);
    }

  
	public void setName(String name) 
	{
		facilityName = name;
		
	}

	public String getName() 
	{
		return facilityName;
	}

	public void setQuantity(Integer quantity) 
	{
		inventoryQuantity = quantity;
		
	}

	public Integer getQuantity() 
	{
		return inventoryQuantity;
	}

	public void setItemId(String itemId) 
	{
		inventoryId = itemId;
		
	}

	public String getItemId() 
	{
		return inventoryId;
	}
}
