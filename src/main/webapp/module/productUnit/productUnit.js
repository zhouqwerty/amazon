Vue.component('product-unit', function (resolve, reject) {
    GL.Http.load('./module/productUnit/productUnit.html', function (responseText) {
        resolve({
            template: responseText,
            props: {
                product:''
            },
            data: function () {
                return {
                    selectFlag:false,
                }
            },
            watch: {},
            created: function () {},
            methods: {
                showProductInfo:function () {
                    window.open("product.html?pid="+this.product.pid,"_blank");
                }
            }
        });
    });
});