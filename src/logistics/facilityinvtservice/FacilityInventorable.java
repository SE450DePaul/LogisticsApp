package logistics.facilityinvtservice;

/**
 * Created by uchennafokoye on 4/22/16.
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
