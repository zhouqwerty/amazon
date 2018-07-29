Vue.component('top-user-info', function (resolve, reject) {
    GL.Http.load('./module/topUserInfo/topUserInfo.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                const validatePassword2 =(rule,value,callback)=>{
                    if(value!=this.register.registerInfo.password){
                        callback(new Error('两次密码不一致'))
                    }else{
                        callback();
                    }
                };
                const validateEmail =(rule,value,callback)=>{
                    let reg=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
                    if(reg.test(value)){
                        callback();
                    }else{
                        callback(new Error('邮箱格式错误'));
                    }
                };
                const validatePhone =(rule,value,callback)=>{
                    console.log(value)
                    let reg=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
                    if(reg.test(value)){
                        callback();
                    }else{
                        callback(new Error('手机格式错误'));
                    }
                };
                const validateCode =(rule,value,callback)=>{
                    //可以发送异步请求
                    setTimeout(()=>{
                        let i=Math.random();
                        if(i<0.5){
                            callback(new Error("验证码错误"))
                        }else{
                            callback();
                        }
                    },2000)
                };
                return {
                    login:{
                        loginModal:false,
                        loginFlag:false,
                        loginInfo:{
                            username:'',
                            password:'',
                            valid:''
                        },
                        loginRule:{
                            username: [
                                { required:true , message:'用户名不能为空'}
                            ],
                            password: [
                                { required:true , message:'密码不能为空'}
                            ],
                            valid: [
                                { required:true , message:'验证码不能为空'}
                            ]
                        },
                        validateCode:''
                    },
                    register:{
                        registerModal:false,
                        registerFlag:false,
                        registerInfo:{
                            username:'',
                            password:'',
                            password2:'',
                            email:'',
                            phone:'',
                            valid:''
                        },
                        validator:{

                        },
                        registerRule:{
                            username: [
                                { required:true , message:'用户名不能为空'}
                            ],
                            password: [
                                { required:true , message:'密码不能为空' }
                            ],
                            password2:[
                                { validator: validatePassword2}
                            ],
                            email:[
                                { validator: validateEmail}
                            ],
                            phone:[
                                { validator: validatePhone}
                            ],
                            valid: [
                                { validator: validateCode}
                            ],

                        }
                    },
                    interfaces:{
                        login:'/core/user/login',
                        register:'/core/user/register',
                        getValidateCode:'core/user/getValidateCode',
                        validValidateCode:'core/user/validValidateCode'
                    }
                }
            },
            watch: {},
            created: function () {},
            methods: {
                clickLogin:function () {
                    let $this=this;
                    var obj = {};
                    obj.time = new Date().getTime();
                    $.ajax({
                        type: 'post',
                        url: basePath+$this.interfaces.getValidateCode,
                        cache: false,
                        data: JSON.stringify(obj),
                        dataType: "json",
                        contentType: "application/json; charset=utf-8",
                        beforeSend: function (request) {
                            request.setRequestHeader("GaeaToken", sessionStorage.getItem("GaeaToken"));
                        },
                        success: function (data) {
                            callback(data.data);
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            if (callErrorBack instanceof Function) {
                                callErrorBack();
                            }
                            console.log('!!!error:' + errorThrown);
                        }
                    });
                },
                selectMyShop: function (name) {
                    console.log(name)
                },
                loginSubmit: function (name) {
                    this.$refs[name].validate((result)=> {
                        if(result){
                            this.login.loginFlag = true;
                            setTimeout(() => {
                                this.login.loginModal = false;
                                this.login.loginFlag = false;
                                this.$Message.success('登录成功');
                                this.lrReset("loginInfo");
                            }, 2000);
                        }
                    });
                },
                registerSubmit:function (name) {
                    this.$refs[name].validate((result)=> {
                        if(result){
                            this.register.registerFlag = true;
                            setTimeout(() => {
                                this.register.registerModal = false;
                                this.register.registerFlag = false;
                                this.$Message.success('注册成功');
                                this.lrReset("registerInfo");
                            }, 2000);
                        }
                    });
                },
                lrReset:function(name){
                    this.$refs[name].resetFields();
                },
                lrEnd:function (name) {
                    this.$refs[name].resetFields();
                }
            }
        });
    });
});

