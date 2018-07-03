Vue.component('header-search', function (resolve, reject) {
    GL.Http.load('./module/headerSearch/headerSearch.html', function (responseText) {
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