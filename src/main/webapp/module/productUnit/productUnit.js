Vue.component('product-unit', function (resolve, reject) {
    GL.Http.load('./module/productUnit/productUnit.html', function (responseText) {
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