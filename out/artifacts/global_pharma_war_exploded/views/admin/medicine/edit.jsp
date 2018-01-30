<%@ page import="Admin.Models.Entities.MedicineEntity" %><%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/27/2017
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    MedicineEntity medicine = (MedicineEntity) request.getAttribute("medicine");
%>
<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Edit Medicine </h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/medicine/view">View Medicines</a>
            </div>
            <form role="form" id="medicine_edit" action="${baseUrl}/medicine/edit/<%=medicine.getId()%>" method="post">
                <input type="hidden" value="<%=medicine.getCompanyId()%>" name="company_id">
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_code">Medicine Code <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_code" name="medicine_code" value="<%=medicine.getMedicineCode()%>" placeholder="Enter medicine code..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_name">Medicine Name <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_name" name="medicine_name" value="<%=medicine.getMedicineName()%>" placeholder="Enter medicine name..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_generic">Medicine Generic</label>
                                <input type="text" class="form-control" id="medicine_generic" name="medicine_generic" value="<%=medicine.getMedicineGeneric()%>" placeholder="Enter medicine generic..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_company">Medicine Company Name</label>
                                <input type="text" class="form-control" id="medicine_company" name="medicine_company" value="<%=medicine.getMedicineCompanyName()%>" placeholder="Enter medicine company name..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="medicine_type">Medicine Type <span class="text-danger">*</span></label>
                                <select class="form-control" name="medicine_type" id="medicine_type">
                                    <option value="">-- Select Medicine Type --</option>
                                    <option value="tab" <% if(medicine.getMedicineType() != null && medicine.getMedicineType().equals("tab")){%> selected <%}%>>Tab</option>
                                    <option value="capsule" <% if(medicine.getMedicineType() != null && medicine.getMedicineType().equals("capsule")){%> selected <%}%>>Capsule</option>
                                    <option value="syrup" <% if(medicine.getMedicineType() != null && medicine.getMedicineType().equals("syrup")){%> selected <%}%>>Syrup</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="medicine_size">Medicine Size <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_size" name="medicine_size" value="<%=medicine.getMedicineSize()%>" placeholder="Enter medicine size..">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="medicine_unit">Medicine Unit <span class="text-danger">*</span></label>
                                <select class="form-control" name="medicine_unit" id="medicine_unit">
                                    <option value="">-- Select Medicine Unit --</option>
                                    <option value="piece" <% if(medicine.getMedicineUnit() != null && medicine.getMedicineUnit().equals("piece")){%> selected <%}%>>Piece</option>
                                    <option value="leaf" <% if(medicine.getMedicineUnit() != null && medicine.getMedicineUnit().equals("leaf")){%> selected <%}%>>Leaf</option>
                                    <option value="box" <% if(medicine.getMedicineUnit() != null && medicine.getMedicineUnit().equals("box")){%> selected <%}%>>Box</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_price">Medicine Price <span class="text-danger">*</span></label>
                                <input type="number" class="form-control" id="medicine_price" name="medicine_price" value="<%=medicine.getMedicinePrice()%>" placeholder="Enter medicine price..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="photo">Medicine Photo</label>
                                <input type="file" class="form-control" id="photo" name="photo">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Update Medicine</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $("#medicine_edit").validate({
        rules: {
            medicine_code: {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            medicine_name: {
                required: true,
                minlength: 2,
                maxlength: 45
            },
            medicine_generic: {
                required: true,
                minlength: 2,
                maxlength: 45
            },
            medicine_type: {
                required: true
            },
            medicine_size: {
                required: true,
                minlength: 2,
                maxlength: 45
            },
            medicine_unit: {
                required: true
            },
            medicine_price: {
                required: true
            },
            medicine_company: {
                required: true,
                minlength: 6,
                maxlength: 45
            },
//            companyLogo: {
//                required: true,
//                extension: "jpeg|jpg|png"
//            }
        }
    });
</script>
