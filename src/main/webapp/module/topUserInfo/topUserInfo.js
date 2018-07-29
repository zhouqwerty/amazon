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
                const validateRegisterCode =(rule,value,callback)=>{
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
                const validateLoginCode =(rule,value,callback)=>{
                    let val=value.trim();
                    if(val){
                        let params={};
                        params.validateCode=val;
                        callApi(this.interfaces.validValidateCode,params,(data)=> {
                            if(data=='1'){
                                callback();
                            }else{
                                callback(new Error("验证码错误"));
                            }
                        })
                    }else{
                        callback(new Error("验证码为空"))
                    }
                };
                return {
                    login:{
                        loginModal:false,
                        loginButtonFlag:false,
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
                                { validator: validateLoginCode,trigger:'blur'}
                            ]
                        },
                        validateCode:'',
                        loginResult:'',
                        loginSuccess:false,
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
                                { validator: validateRegisterCode}
                            ],

                        }
                    },
                    interfaces:{
                        login:'/core/user/login',
                        loginCheck:'/core/user/loginCheck',
                        register:'/core/user/register',
                        getValidateCode:'/core/user/getValidateCode',
                        validValidateCode:'/core/user/validValidateCode',
                        cancelLogin:'/core/user/cancelLogin',
                    },
                    userInfo:''
                }
            },
            watch: {},
            created: function () {
                callApi(this.interfaces.loginCheck,{},(data)=> {
                    if(data){
                        this.login.loginSuccess=true;
                        this.userInfo=data;
                    }
                })
            },
            methods: {
                refreshLoginCode:function () {
                    callApi(this.interfaces.getValidateCode,{}, (data)=> {
                        this.login.validateCode=data;
                        this.login.loginModal=true;
                    })
                },
                clickLogin:function () {
                    this.refreshLoginCode();
                },
                selectMyShop: function (name) {
                    console.log(name)
                },
                loginSubmit: function (name) {
                    this.$refs[name].validate((result)=> {
                        if(result){
                            this.login.loginButtonFlag = true;
                            let params={};
                            params.user={username:this.login.loginInfo.username,password:this.login.loginInfo.password};
                            params.validateCode=this.login.loginInfo.valid;
                            callApi(this.interfaces.login,params,(data)=> {
                                this.login.loginButtonFlag = false;
                                if(data=='codeError'){
                                    this.login.loginResult='验证码错误';
                                }else if(data){
                                    this.userInfo=data;
                                    this.login.loginSuccess=true;
                                    this.login.loginModal=false;
                                    this.$Message.success('登录成功');
                                }else{
                                    this.login.loginResult='账号密码不匹配';
                                }
                            })
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
                },
                cancelLogin:function () {
                    callApi(this.interfaces.cancelLogin,{},(data)=>{
                        if(data=='1'){
                            this.login.loginSuccess=false;
                        }
                    })
                }
            }
        });
    });
});

