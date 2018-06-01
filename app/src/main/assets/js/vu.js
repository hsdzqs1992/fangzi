new Vue({
    el:"#app1",
    data:{
        //index.php/app/house/cf_detail
        base:'',
        url:'http://192.168.1.12/jdhouse/index.php/app/house/cf_detail',
        img:'http://192.168.1.12/jdhouse/attachs/',
        dat:Object,
        loupan:Object,
        id:1,
        ju:'http://192.168.1.12/jdhouse/index.php/app/index/report',
        token:'aaa'
    },



    filters:{

        // df:function (value,ss) {
        // console.log(value,ss)
        // }
    },


    methods:{
        chat:function(){
            java.chat(dat.user_id)
        },


        close:function(){
            $(".report_cover").hide();

        },


        phone:function(){
            java.callphone(dat.mobile)
        },


        shoucang:function(){
            java.shoucang()
        },

        share:function(){
            java.share()
        },

        jubao:function(){
            $(".report_cover").show();

            $(".report_lists > p").click(function () {
                //alert($(this).text())
                $(this).first().attr("color","red")
                //console.log($(this))

                jubao(base,token,id,$(this).text())
            })


            //jubao


            //java.jubao()

            // var that = this
            // $.ajax({
            // 	url:that.url,
            // 	type:'post',
            // 	data:{
            //        "life_id": that.id,
            //        "token":that.token
            // 	},
            // 	datatype:'json',
            // 	success:function (data) {
            // 		console.log(data)
            // 	    if(check(data))	{
            // 		    console.log('ok')
            // 		}
            //
            //    },
            //
            // 	error:function () {
            //
            //    }
            // })

        },

        getData:function (id) {
            console.log(id)
            var that = this
            $.ajax({
                url: that.url,
                type: "post",
                data: {
                    "life_id": id,
                    "token":"sdfasd"
                },
                datatype: "json",
                success: function (data) {
                    console.log(that.url)


                    var temp = JSON.parse(data)
                    console.log(temp.data)
                    that.dat = temp.data
                    // var time = new Date()
                    //
                    // //console.log(time.getMilliseconds())
                    // // console.log(time.getMinutes())
                    // // console.log(time.getSeconds())
                    // // console.log(time.getTime())
                    // //this.cur = time.getMilliseconds()
                    // //console.log(time.getMilliseconds())
                    // //console.log(typeof temp.data)
                    // console.log(data)

                },
                error: function () {
                    console.log("shiba")
                }
            })
        }
    },

    created:function () {
        id = java.getId();
        base = java.getBase()
        token = java.getToken1()
        //
        // var id ='89'
        this.getData(id)
    },


})