Vue.component('index-carousel', function (resolve, reject) {
    GL.Http.load('./module/indexCarousel/indexCarousel.html', function (responseText) {
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