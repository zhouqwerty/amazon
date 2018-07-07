Vue.component('brand-tip', function (resolve, reject) {
    GL.Http.load('./module/brandTip/brandTip.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                return {}
            },
            watch: {},
            created: function () {},
            methods: {}
        });
    });
});