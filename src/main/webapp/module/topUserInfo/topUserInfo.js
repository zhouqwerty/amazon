Vue.component('top-user-info', function (resolve, reject) {
    GL.Http.load('./module/topUserInfo/topUserInfo.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                return {
                    loginModal:false,
                    loginFlag:false,
                    loginInfo:{
                        username:'',
                        password:'',
                        vaild:''
                    },
                    loginRule:''
                }
            },
            watch: {},
            created: function () {},
            methods: {
                selectMyShop:function (name) {
                    console.log(name)
                },
                login:function () {
                    console.log("正在登录")
                    this.loginFlag= true;
                    setTimeout(() => {
                        this.loginModal = false;
                        this.loginFlag= false;
                        this.$Message.success('登录成功');
                    }, 2000);
                },
                showLogin:function () {
                    this.loginModal=true;
                }
            }
        });
    });
});

