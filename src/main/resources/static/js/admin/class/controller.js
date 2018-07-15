$(document).ready(function () {
    $("#data-card-form").ajaxForm({
        url: contextRoot + "admin/class",
        method: $("#data-card-form").attr("method"),
        success: function () {
            CallbackUtil.redirect("admin/class");
        },
        error: CallbackUtil.errorResponse
    });

    ClassController.id = $("#id").val();

    $( "#sortable1, #sortable2" ).sortable({
        connectWith: ".field-list-sortable",
        update: function( event, ui ) {
            var itemsCount = $('.field-list-col--selected li').length;
            $('.field-list-action--count').text(itemsCount ? itemsCount + ' выбрано' : 'нет выбранных полей');
        }
    }).disableSelection();
});

ClassController = {};


ClassController.saveClass = function () {
    var data = {
        id: $("#data-card-form > #id").val(),
        title: $("#data-card-form #attr-title").val()
    };

    $("#data-card-form #sortable2 > li").each(function (index) {
        data["fields["+index+"].id"] = $(this).attr('id_field');
      });

    $.ajax({
        method: $("#data-card-form").attr("method"),
        url: contextRoot + "admin/class",
        data: data,
        success: function () {
            CallbackUtil.redirect("admin/class");
        },
        error: CallbackUtil.errorResponse
    });
};