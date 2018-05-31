// function GetRequest() {
//     var url = location.search; //获取url中"?"符后的字串
//     var theRequest = new Object();
//     if (url.indexOf("?") != -1) {
//         var str = url.substr(1);
//         strs = str.split("&");
//         for (var i = 0; i < strs.length; i++) {
//             theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
//         }
//     }
//     return theRequest;
// }



function check(data) {
    let tf= JSON.parse(data);
    if(tf.code == 200){
        return tf.data;
    }else{
        alert(tf.message)
        return null;
    }
}

function post(url,map,fun) {
    $.ajax({
        url:url,
        type:'post',
        data:{
            map
        },
        datatype:'json',
        success:function (data) {
            console.log(data)
            if(check(data))	{
                console.log('ok')
            }
            return check(data)
        },

        error:function () {

            console.log('失败')
            return null

            }
        })

}