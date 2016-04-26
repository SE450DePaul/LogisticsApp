package logistics.facilityinvtservice;

/**
 * @author David Olorundare
 */
public class FacilityInvImpl implements FacilityInventorable
{
    private String facilityName;
    private String inventoryId;
    private int inventoryQuantity;

    public FacilityInvImpl(String name, String invenId, int invenQuantity)
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

	public void setQuantity(int quantity) 
	{
		inventoryQuantity = quantity;
		
	}

	public int getQuantity() 
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
