Vue.component('demo', function (resolve, reject) {
    GL.Http.load('./module/topUserInfo/topUserInfo.html', function (responseText) {
        resolve({
            template: responseText,
            props: {
                left: {
                    type: Number,
                    default: 0
                },
                right: {
                    type: Number,
                    default: 0
                }
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

