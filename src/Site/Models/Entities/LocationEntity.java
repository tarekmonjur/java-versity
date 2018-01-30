package Site.Models.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Tarek Monjur on 1/28/2018.
 */

@Entity
@Table(name="locations")
public class LocationEntity {

    @Id
    private Integer id;
    @Column(name = "location_name")
    private String locationName;

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
