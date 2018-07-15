$(document).ready(function () {
    // create the editor
    var container = document.getElementById("editor_div");

    var options = {
        modes: ['tree', 'code'], // allowed modes
        templates: [
            {
                text: 'Panel',
                title: 'Insert a Container Node',
                className: 'jsoneditor-type-object',
                field: 'ContainerTemplate',
                value: {
                    'type': 'Container',
                    'format': 'Panel',
                    'layout': 'Grid',
                    'items': {}
                }
            },
            {
                text: 'TextBox',
                title: 'Insert a TextBox Node',
                field: 'TextBoxTemplate',
                value: {
                    'type': 'Component',
                    'format': 'TextBox',
                    'title': 'TextBox',
                    'dataSource': ''
                }
            },
            {
                text: 'ComboBox',
                title: 'Insert a ComboBox Node',
                field: 'ComboBoxTemplate',
                value: {
                    'type': 'Component',
                    'format': 'ComboBox',
                    'title': 'ComboBox',
                    'dataSource': ''
                }
            },
            {
                text: 'CheckBox',
                title: 'Insert a CheckBox Node',
                field: 'CheckBoxTemplate',
                value: {
                    'type': 'Component',
                    'format': 'CheckBox',
                    'title': 'CheckBox',
                    'dataSource': ''
                }
            },
            {
                text: 'Button',
                title: 'Insert a Button Node',
                field: 'ButtonTemplate',
                value: {
                    'type': 'Component',
                    'format': 'Button',
                    'title': 'Button',
                    'icon': '',
                    'action': ''
                }
            }
        ]
    };

    var json = [
        {
          firstName: 'John',
          lastName: 'Doe',
          age: 28
        }
    ];

//    var editor = new JSONEditor(container, options);
//    editor.set(json);
//    var json = editor.get();

var docSpec={
    onchange: function(){
        console.log("I been changed now!")
    },
    validate: function(obj){
        console.log("I be validatin' now!")
    },
    elements: {
        "container": {
            menu: [{
            caption: "Append container",
            action: Xonomy.newElementChild,
            actionParameter: "<container/>"
            }]
        },
        "item": {
            menu: [{
                caption: "Add @title",
                action: Xonomy.newAttribute,
                actionParameter: {name: "title", value: ""},
                hideIf: function(jsElement){
                return jsElement.hasAttribute("title");
                }
            }, {
                caption: "Delete this <component>",
                action: Xonomy.deleteElement
            }, {
                caption: "New <component> before this",
                action: Xonomy.newElementBefore,
                actionParameter: "<component/>"
            }, {
                caption: "New <component> after this",
                action: Xonomy.newElementAfter,
                actionParameter: "<component/>"
            }],
            canDropTo: ["container"],
            attributes: {
                "icon": {
                    asker: Xonomy.askString,
                    menu: [{
                        caption: "Delete this @icon",
                        action: Xonomy.deleteAttribute
                    }]
                },
                "action": {
                    asker: Xonomy.askString,
                    menu: [{
                        caption: "Delete this @action",
                        action: Xonomy.deleteAttribute
                    }]
                },
                "format": {
                    asker: Xonomy.askPicklist,
                    askerParameter: [
                        {value: "TextBox", caption: "Element for string"},
                        {value: "ComboBox", caption: "Element for list"},
                        {value: "CheckBox", caption: "Element for boolean"},
                        {value: "DataPicker", caption: "Element for date"},
                        {value: "TimePicker", caption: "Element for time"},
                        {value: "TextArea", caption: "Element for multi-string"},
                        {value: "Button", caption: "Element for action button"},
                        {value: "Link", caption: "Element for action link"}
                    ]
                },
                "layout": {
                    asker: Xonomy.askPicklist,
                    askerParameter: [
                        {value: "Grid", caption: "Grid layout"},
                        {value: "Row", caption: "One row layout"},
                        {value: "Column", caption: "One column layout"}
                    ]
                }
            }
        }
    }
};

    var xml="<container layout='Row'> <component format='TextBox' title='ФИО:'/> <component format='ComboBox' title='Телефон:'/> <component format='Button' title='Применить:' icon='' action=''/> </container>";

    if($("#card").val().length > 0) {
        xml = $("#card").val();
    }

    Xonomy.render(xml, container, docSpec);

    $("#data-card-form").ajaxForm({
        url: contextRoot + "view",
        data: {
            card : Xonomy.harvest(),
            id : $("#id").val(),
            title : $("#title").val()
        },
        method: $("#data-card-form").attr("method"),
        success: function () {
            CallbackUtil.redirect("view");
        },
        error: CallbackUtil.errorResponse
    });

    FieldController.id = $("#id").val();
});

FieldController = {};
