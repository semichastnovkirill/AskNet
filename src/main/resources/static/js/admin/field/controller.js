$(document).ready(function () {
    $("#data-card-form").ajaxForm({
        url: contextRoot + "admin/field",
        method: $("#data-card-form").attr("method"),
        success: function () {
            CallbackUtil.redirect("admin/field");
        },
        error: CallbackUtil.errorResponse
    });

    FieldController.id = $("#id").val();
});

FieldController = {};