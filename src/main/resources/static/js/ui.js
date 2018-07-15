Vue.mixin({
    mounted: function () {
        $(".button-collapse").sideNav();
    }
});

Vue.component('modal-window', {
    data: function () {
        return {
            header: '',
            text: ''
        }
    },
    methods: {
        open: function (header, text) {
            $('#modal-window').modal('open');
            this.header = header;
            this.text = text;
        },
        close: function () {
            $('#modal-window').modal('close');
            this.text = '';
            this.header = '';
        }
    },
    template:
    '<div id="modal-window" class="modal">' +
    '   <div class="modal-content">' +
    '       <h4 v-show="header.length > 0">{{header}}</h4>' +
    '       <p>{{text}}</p>' +
    '   </div>' +
    '   <div class="modal-footer">' +
    '   <a v-on:click="close" class="modal-action modal-close waves-effect waves-light btn">Закрыть</a>' +
    '   </div>' +
    '</div>'
});

Vue.component('preloader', {
    props: ['visible'],
    template: '<div v-if="visible" v-cloak>' +
    '   <div class="preloader-wrapper big active">' +
    '        <div class="spinner-layer spinner-blue">' +
    '            <div class="circle-clipper left">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="gap-patch">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="circle-clipper right">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '        </div>' +
    '        <div class="spinner-layer spinner-red">' +
    '            <div class="circle-clipper left">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="gap-patch">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="circle-clipper right">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '        </div>' +
    '        <div class="spinner-layer spinner-yellow">' +
    '            <div class="circle-clipper left">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="gap-patch">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="circle-clipper right">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '        </div>' +
    '        <div class="spinner-layer spinner-green">' +
    '            <div class="circle-clipper left">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="gap-patch">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '            <div class="circle-clipper right">' +
    '                <div class="circle"></div>' +
    '            </div>' +
    '        </div>' +
    '    </div>' +
    '</div>'
});