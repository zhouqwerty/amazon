Vue.component('step-header', function (resolve, reject) {
    GL.Http.load('./module/stepHeader/stepHeader.html', function (responseText) {
        resolve({
            template: responseText,
            props: {
                current:String
            },
            data: function () {
                return {}
            },
            watch: {},
            created: function () {},
            methods: {}
        });
    });
});