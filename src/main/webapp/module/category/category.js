Vue.component('qwe-category', function (resolve, reject) {
    GL.Http.load('./module/category/category.html', function (responseText) {
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