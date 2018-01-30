<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/17/2017
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String medicineType = (String) request.getAttribute("medicineType");
    String medicineUnit = (String) request.getAttribute("medicineUnit");
%>
<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Add New Medicine </h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/medicine/view">View Medicines</a>
            </div>
            <form role="form" id="medicine_add" action="${baseUrl}/medicine/add" method="post">
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_code">Medicine Code <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_code" name="medicine_code" value="${medicineCode}" placeholder="Enter medicine code..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_name">Medicine Name <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_name" name="medicine_name" value="${medicineName}" placeholder="Enter medicine name..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_generic">Medicine Generic <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_generic" name="medicine_generic" value="${medicineGeneric}" placeholder="Enter medicine generic..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_company">Medicine Company Name <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_company" name="medicine_company" value="${medicineCompany}" placeholder="Enter medicine company name..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="medicine_type">Medicine Type <span class="text-danger">*</span></label>
                                <select class="form-control" name="medicine_type" id="medicine_type">
                                    <option value="">-- Select Medicine Type --</option>
                                    <option value="tab" <% if(medicineType != null && medicineType.equals("tab")){%> selected <%}%>>Tab</option>
                                    <option value="capsule" <% if(medicineType != null && medicineType.equals("capsule")){%> selected <%}%>>Capsule</option>
                                    <option value="syrup" <% if(medicineType != null && medicineType.equals("syrup")){%> selected <%}%>>Syrup</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="medicine_size">Medicine Size <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="medicine_size" name="medicine_size" value="${medicineSize}" placeholder="Enter medicine size..">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="medicine_unit">Medicine Unit <span class="text-danger">*</span></label>
                                <select class="form-control" name="medicine_unit" id="medicine_unit">
                                    <option value="">-- Select Medicine Unit --</option>
                                    <option value="piece" <% if(medicineUnit != null && medicineUnit.equals("piece")){%> selected <%}%>>Piece</option>
                                    <option value="leaf" <% if(medicineUnit != null && medicineUnit.equals("leaf")){%> selected <%}%>>Leaf</option>
                                    <option value="box" <% if(medicineUnit != null && medicineUnit.equals("box")){%> selected <%}%>>Box</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="medicine_price">Medicine Price <span class="text-danger">*</span></label>
                                <input type="number" class="form-control" id="medicine_price" name="medicine_price" value="${medicinePrice}" placeholder="Enter medicine price..">
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
                    <button type="submit" class="btn btn-primary">Add Medicine</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $("#medicine_add").validate({
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
