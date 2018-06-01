


function jubao(url,token,life_id,report) {
    $(".shoucang").click(function () {
        //java.shoucang()
        // mui.toast("haoke")
        $.ajax({
            url:url,
            type:'post',
            data:{
                "report":report,
                "life_id":life_id,
                "token":token
            },
            datatype:'json',
            success:function (data) {
                console.log(data)
                if(check(data))	{
                    mui.toast("举报成功")
                    $(".shoucang").attr("src","images/shouf9.png")
                }
                mui.toast("举报失败")
            },

            error:function () {
                mui.toast("举报失败")
                //console.log('失败')
                return null
            }
        })
    })

}