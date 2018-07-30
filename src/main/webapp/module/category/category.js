Vue.component('qwe-category', function (resolve, reject) {
    GL.Http.load('./module/category/category.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                return {
                    category:$Global.category,
                    categories:[],
                    childCategories:[],
                    interfaces:{
                        getProductCategory:'/core/product/getProductCategory'
                    }
                }
            },
            watch: {

            },
            created: function () {
                callApi(this.interfaces.getProductCategory,{},(data)=> {
                    this.categories=data;
                })
            },
            methods: {
                selectCategory:function(item,event){
                    this.category.secondListVisible='block';
                    this.childCategories=item.children;
                    event.target.style.backgroundColor='rgba(58,174,224,0.3)';
                    event.target.style.color='rgb(51,167,255)';
                },
                unselectCategory:function(item,event){
                    event.target.style.backgroundColor='transparent';
                    event.target.style.color='black';
                },
                searchProductsByPcid:function (pcid) {
                    window.open("product.html?pcid="+pcid,"_blank");
                }
            }
        });
    });
});