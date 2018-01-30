package Admin.Models.Entities;

/**
 * Created by Tarek Monjur on 1/3/2018.
 */
public class CompanyEntity {

    private int row, id;

    private String companyName, companyCode, CompanyContactEmail, CompanyContactMobileNo, CompanyLogo, CompanyAddress, CompanyStatus, CreatedAt, UpdatedAt;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }
}
