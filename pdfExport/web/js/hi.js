$(function(){


    $('li').bind('click',function(e){

        var value = $(e)[0].attr('value');
        debugger;
       layer.alert("HI" + value);

    })
})
