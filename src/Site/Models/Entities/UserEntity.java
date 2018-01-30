package Site.Models.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tarek Monjur on 1/6/2018.
 */

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    private int id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="full_name")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="mobile_no")
    private String mobileNo;
    @Column(name="gender")
    private String gender;
    @Column(name="photo")
    private String photo;
    @Column(name="verify_status")
    private int verifyStatus;
    @Column(name="status")
    private int status;
    @Column(name="token")
    private String token;
    @Column(name="created_by")
    private int createdBy;
    @Column(name="updatedBy")
    private int updated_by;

    @CreationTimestamp
    @Type(type = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Type(type = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", insertable = false)
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(int verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
