Vue.component('qwe-news', function (resolve, reject) {
    GL.Http.load('./module/news/news.html', function (responseText) {
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