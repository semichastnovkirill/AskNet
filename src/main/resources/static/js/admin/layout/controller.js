$(document).ready(function () {
	LayoutController.init();
});

var LayoutController = {
	configGridId: '#constructor-config',

	/**
	 * Инициализация функций.
	 */
	init: function () {
		LayoutController.draggable();
		LayoutController.interaction();
	},

	/**
	 * Получение сетки конфигурации.
	 */
	getConfigGrid: function () {
		return $(LayoutController.configGridId);
	},

	/**
	 * Расположение элементов в конфигурации.
	 */
	draggable: function () {
		var $container = LayoutController.getConfigGrid();

		$container.packery({
			itemSelector: '.item-constructor',
			columnWidth: '.item-sizer',
			gutter: '.item-gutter',
			percentPosition: true
		});

		// Делаем элементы перетаскиваемыми
		var $items = $container.find('.item-constructor').draggable();
		$container.packery('bindUIDraggableEvents', $items);
	},

	/**
	 * Взаимодействие.
	 */
	interaction: function () {
		$('.constructor-config-save').click(function () {
			var $container = LayoutController.getConfigGrid();
			var elems = $container.packery('getItemElements');
			console.info(elems);

			return false;
		});

		// Добавление элемента
		$('.item-constructor-action').click(function () {
			var $container = LayoutController.getConfigGrid();
			var item = $(this).parent();
			var icon = $(this).find('.material-icons');
			var type = icon.text();

			if (type === 'add') {
				// Обновление элементы конфигурации
				icon.text('remove');
				$container.append(item).packery('appended', item);

				// Делаем элемент перетаскиваемыми
				$container.packery('bindUIDraggableEvents', item.draggable()).packery('shiftLayout');
			}
			else if (type === 'remove') {
				// Обновление элементов источника
				var clone = item.clone(true).removeAttr('style');
				clone.find('.material-icons').text('add');
				clone.prependTo('.constructor-src');

				$container.packery('remove', item).packery('shiftLayout');
			}

			return false;
		});
	}

};