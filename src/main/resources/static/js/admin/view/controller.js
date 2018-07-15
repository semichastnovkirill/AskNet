$(document).ready(function () {
		$( "#sortable1, #sortable2" ).sortable({
			connectWith: ".field-list-sortable",
			update: function( event, ui ) {
			    var itemsCount = $('.field-list-col--selected li').length;
			    $('.field-list-action--count').text(itemsCount ? itemsCount + ' выбрано' : 'нет выбранных полей');
            }
		}).disableSelection();

});

ViewController = {};
