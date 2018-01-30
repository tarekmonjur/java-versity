package Admin.Models.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tarek Monjur on 12/27/2017.
 */
@Entity
@Table(name = "medicines")
public class MedicineEntity {

    public static int pageSize = 20;

    @Id
    protected int id;
    private int company_id;
    private String medicine_code;
    private String medicine_name;
    private String medicine_generic;
    private String medicine_company_name;
    private String medicine_type;
    private String medicine_size;
    private String medicine_unit;
    private float medicine_price;
    private String medicine_photo;
    private String medicine_status;
    private int created_by;
    private int updated_by;

    @CreationTimestamp
    @Type(type = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Type(type="timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = false)
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return company_id;
    }

    public void setCompanyId(int company_id) {
        this.company_id = company_id;
    }

    public String getMedicineCode() {
        return medicine_code;
    }

    public void setMedicineCode(String medicine_code) {
        this.medicine_code = medicine_code;
    }

    public String getMedicineName() {
        return medicine_name;
    }

    public void setMedicineName(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicineGeneric() {
        return medicine_generic;
    }

    public void setMedicineGeneric(String medicine_generic) {
        this.medicine_generic = medicine_generic;
    }

    public String getMedicineCompanyName() {
        return medicine_company_name;
    }

    public void setMedicineCompanyName(String medicine_company_name) {
        this.medicine_company_name = medicine_company_name;
    }

    public String getMedicineType() {
        return medicine_type;
    }

    public void setMedicineType(String medicine_type) {
        this.medicine_type = medicine_type;
    }

    public String getMedicineSize() {
        return medicine_size;
    }

    public void setMedicineSize(String medicine_size) {
        this.medicine_size = medicine_size;
    }

    public String getMedicineUnit() {
        return medicine_unit;
    }

    public void setMedicineUnit(String medicine_unit) {
        this.medicine_unit = medicine_unit;
    }

    public float getMedicinePrice() {
        return medicine_price;
    }

    public void setMedicinePrice(float medicine_price) {
        this.medicine_price = medicine_price;
    }

    public String getMedicinePhoto() {
        return medicine_photo;
    }

    public void setMedicinePhoto(String medicine_photo) {
        this.medicine_photo = medicine_photo;
    }

    public String getMedicineStatus() {
        return medicine_status;
    }

    public void setMedicine_status(String medicine_status) {
        this.medicine_status = medicine_status;
    }

    public int getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(int created_by) {
        this.created_by = created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdatedBy(int updated_by) {
        this.updated_by = updated_by;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }
}
