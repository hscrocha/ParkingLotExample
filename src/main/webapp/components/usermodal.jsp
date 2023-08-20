<%--
  Created by IntelliJ IDEA.
  User: Prof H Rocha
  Date: 8/18/23
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Since there are more than one page
to use User Modal for Creating/Updating, I moved here for easier reuse --%>
<!-- The Modal -->
<div class="modal" id="UserFormModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" id="UserModalTitle">User Form</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <form class="was-validated" method="post" action="/crudUserServlet">
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="container" id="UserMainForm">

                        <div class="row mb-2" id="div_form_id" style="display:flex;">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_id"> ID: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="text" name="txt_id" id="txt_id" autocomplete="off" readonly />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_name"> Name: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="text" name="txt_name" id="txt_name" required />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_login"> Login: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="email" name="txt_login" id="txt_login" required />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_pass"> Password: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="password" name="txt_pass" id="txt_pass" minlength="6" required />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_perm"> Permission: </label>
                            <div class="col-12 col-md">
                                <select class="form-select" name="txt_perm" id="txt_perm">
                                    <option value="2">Normal</option>
                                    <option value="1">Admin</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success me-2"> Save </button>
                    <button type="reset" class="btn btn-warning me-2" id="clear_button"> Clear </button>
                    <button type="button" class="btn btn-danger me-2" data-bs-dismiss="modal">Cancel</button>
                </div>
            </form>

        </div>
    </div>
</div>