Vue.component('qwe-category', function (resolve, reject) {
    GL.Http.load('./module/category/category.html', function (responseText) {
        resolve({
            template: responseText,
            props: {},
            data: function () {
                return {
                    selected:'',
                    category:$Global.category,
                    categories:[
                        {id:'1', name:'11/11/11'},
                        {id:'2', name:'22/22/22',},
                        {id:'3', name:'33/33/33',},
                        {id:'4', name:'44/44/44',},
                        {id:'5', name:'55/55/55',},
                        {id:'6', name:'66/66/66',},
                        {id:'7', name:'77/77/77',},
                    ]
                }
            },
            watch: {

            },
            created: function () {},
            methods: {
                selectCategory:function(item,event){
                    this.category.selectedFirstCategory=item.id;
                    this.category.isSelected='block';
                    event.target.style.backgroundColor='rgba(58,174,224,0.6)';
                },
                unselectCategory:function(item,event){
                    this.category.isSelected='none';
                    event.target.style.backgroundColor='transparent';
                }
            }
        });
    });
});