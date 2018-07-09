Vue.component('product-unit', function (resolve, reject) {
    GL.Http.load('', function (responseText) {
        resolve({
            template: responseText,
            props: {
                product:''
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