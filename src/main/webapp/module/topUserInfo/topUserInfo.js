Vue.component('demo-item',{
    props:{
        unit:''
    },
    template:'<li>{{unit.type}}</li>'
});