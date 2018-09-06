Vue.component('order-unit', function (resolve, reject) {
    GL.Http.load('./module/orderUnit/orderUnit.html', function (responseText) {
        resolve({
            template: responseText,
            props: {
                orderInfo:Object,
                numDisabled:{
                    type:Boolean,
                    default:false
                }
            },
            data: function () {
                return {
                }
            },
            computed:{
              orderCost:function () {
                  return this.orderInfo.count;
              }
            },
            watch: {},
            created: function () {},
            methods: {
                changeCount:function (count) {
                    console.log(count)
                }
            }
        });
    });
});