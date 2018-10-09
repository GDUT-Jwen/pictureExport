$(function(){


    $('.pic-content').bind('click',function(){

        var value = $(this).children('span')[0].innerHTML;

        layer.open({
            type: 2,
            title: 'layer mobile页',
            shadeClose: true,
            shade: 0.8,
            area: ['380px', '90%'],
            content: 'upload.do?pic=' + value
        });

    })
})
