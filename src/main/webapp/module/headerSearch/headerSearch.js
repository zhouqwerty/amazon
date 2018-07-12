Vue.component('header-search', function (resolve, reject) {
    GL.Http.load('./module/headerSearch/headerSearch.html', function (responseText) {
        resolve({
            template: responseText,
            props: {
                cfirstshow:{
                    type: Boolean,
                    default: false
                }
            },
            data: function () {
                return {
                    category:$Global.category,
                    searchContent:'',
                    searchTip:'台式机',
                    categoryTips:[
                        {name:'数码电器'},
                        {name:'台式机'},
                        {name:'鲜花'},
                        {name:'书籍'},
                        {name:'时尚新品'},
                        {name:'海外代购'},
                        {name:'健身'}],
                    cFirstListVisible:'none',
                }
            },
            watch: {
                'category.changeFirstStatus':function (newVal,oldVal) {
                    if(newVal){
                        this.cfirstshow=false;
                        this.hideCategoryList();
                    }else{
                        this.cfirstshow=true;
                        this.showCategoryList();
                    }
                }
            },
            created: function () {
                if(this.cfirstshow&&$(window).width()>960){
                    this.cFirstListVisible='block'
                }
            },
            methods: {
                searchGoods:function (name) {
                    console.log(name)
                },
                showCategoryList:function (e) {
                    this.cFirstListVisible='block';
                    if(e&&e.target.className=='category_second'){
                        this.category.secondListVisible='block';
                    }
                },
                hideCategoryList:function (e) {
                    if(!this.cfirstshow||$(window).width()<960){
                        this.cFirstListVisible='none';
                    }
                    this.category.secondListVisible='none';
                }
            }
        });
    });
});