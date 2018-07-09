Vue.component('index-carousel', function (resolve, reject) {
    GL.Http.load('./module/indexCarousel/indexCarousel.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                return {
                    category:$Global.category,
                }
            },
            watch: {
                'category.selectedFirstCategory':function (oldVal,newVal) {
                    // console.log(newVal);
                }
            },
            created: function () {},
            methods: {}
        });
    });
});