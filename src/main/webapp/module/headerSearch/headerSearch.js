Vue.component('header-search', function (resolve, reject) {
    GL.Http.load('./module/headerSearch/headerSearch.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                return {
                    searchContent:'',
                    searchTip:'台式机',
                    categoryTips:[
                        {name:'数码电器'},
                        {name:'台式机'},
                        {name:'鲜花'},
                        {name:'书籍'},
                        {name:'时尚新品'},
                        {name:'海外代购'}],
                    cFirstListVisible:'none',
                }
            },
            watch: {},
            created: function () {},
            methods: {
                searchGoods:function (name) {
                    console.log(name)
                },
                hideCategoryList:function (e) {
                   if(e.target.tagName!='LI'){
                       this.cFirstListVisible='none';
                       $Global.category.secondListVisible='none';
                   }else{
                       this.cFirstListVisible='none';
                   }
                }
            }
        });
    });
});