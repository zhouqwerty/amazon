Vue.component('top-user-info', function (resolve, reject) {
    GL.Http.load('./module/topUserInfo/topUserInfo.html', function (responseText) {
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

