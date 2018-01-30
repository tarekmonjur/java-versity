package Admin.Models.Entities;

/**
 * Created by Tarek Monjur on 1/9/2018.
 */
public class LocationEntity {

    private int row;

    private Integer id;

    private String locationName;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
