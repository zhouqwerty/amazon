Vue.component('order-header', function (resolve, reject) {
    GL.Http.load('./module/orderHeader/orderHeader.html', function (responseText) {
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