package Site.Models.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tarek Monjur on 1/9/2018.
 */
@Entity
@Table(name="companies")
public class PharmacyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_code")
    private String companyCode;
    @Column(name = "company_contact_email")
    private String CompanyContactEmail;
    @Column(name = "company_contact_mobile_no")
    private String CompanyContactMobileNo;
    @Column(name = "company_logo")
    private String CompanyLogo;
    @Column(name = "company_address")
    private String CompanyAddress;
    @Column(name = "company_status")
    private String CompanyStatus;

    @CreationTimestamp
    @Type(type = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",updatable = false)
    private Date CreatedAt;

    @UpdateTimestamp
    @Type(type="timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = false)
    private Date UpdatedAt;

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        Id = id;
//    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyContactEmail() {
        return CompanyContactEmail;
    }

    public void setCompanyContactEmail(String companyContactEmail) {
        CompanyContactEmail = companyContactEmail;
    }

    public String getCompanyContactMobileNo() {
        return CompanyContactMobileNo;
    }

    public void setCompanyContactMobileNo(String companyContactMobileNo) {
        CompanyContactMobileNo = companyContactMobileNo;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        CompanyLogo = companyLogo;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public String getCompanyStatus() {
        return CompanyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        CompanyStatus = companyStatus;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }
}
