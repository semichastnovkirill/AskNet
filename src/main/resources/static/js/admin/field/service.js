ConfigureService = {};

ConfigureService.buildView = function(data, success) {
    $.ajax({
        method: "POST",
        data: data,
//        contentType: "application/json",
        url: contextRoot + "admin/configure/build_view",
        success: success,
        error: CallbackUtil.errorResponse
    })
};