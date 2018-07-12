$Global={
    category:{
        secondListVisible:'none',
        changeFirstStatus: false
    }
}
$(window).resize(function () {
    let w=$(window).width();
    if(w<960){
        $Global.category.changeFirstStatus=true;
    }else {
        $Global.category.changeFirstStatus=false;
    }
});