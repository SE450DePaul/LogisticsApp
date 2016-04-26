package logistics.facilityinventoryservice;

/**
 * @author David Olorundare
 */
public interface FacilityInventorable
{

    void setName(String name);
    String getName();
    void setItemId(String itemId);
    String getItemId();
    void setQuantity(int quantity);
    int getQuantity();

}
