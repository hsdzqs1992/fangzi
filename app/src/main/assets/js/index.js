//图片 1:1
function imgsize() {
  $(".wh-11").each(function () {
    var height = $(this).width();
    $(this).height(height);
  });
}
imgsize();

//标签页切换通用
$(".tab-menu").on("click", "a", function (e) {
  e.preventDefault();
  var tabid = $(this).attr("href");
  $(this).addClass("on").siblings().removeClass("on");
  $(".tab-content").find(tabid).show().siblings().hide();
});
//a标签href跳转
mui('.a-href').on('tap', 'a', function () {
  window.top.location.href = this.href;
});
mui('.aclick').on('tap', '.mui-slider-handle a', function () {
  window.top.location.href = this.href;
});
//推荐关键词选择
$(".tuijian").on("click", ".base-btn", function () {
  $(".searchgz input").val($(this).html()).focus().val($(this).html());
});
//筛选
mui(".list-sx").on("tap", ".main-sx", function () {
  $(".shaixuan-top").fadeOut("fast");
  $(this).find(".shaixuan-top").stop().fadeToggle("fast");
})

//弹窗打开
$(".modalbtn").click(function () {
  var id = $(this).attr("data-id");
  $(id).fadeIn("fast");
});
//弹窗关闭
$(".close-btn").click(function () {
  $(this).parents(".modal").fadeOut("fast");
});

//弹窗从下方弹出
mui(".shophome").on("tap",".modalbtn2",function () {
  $('html,body').addClass('overflow-h');
  var id = $(this).attr("data-id");
  $(id).fadeIn("fast");
  $(id).find(".modal-con").animate({
    bottom: 0
  })
});
//弹窗关闭
$(".close-btn2").click(function () {
  $('html,body').removeClass('overflow-h');
  $(this).parents(".modal").fadeOut("fast");
  $(this).parents(".modal").find(".modal-con").animate({bottom: '-100%'})
});

//    视频播放
mui(".zhibo").on("tap", ".icon-bofang", function () {
  var myVideo = this.previousElementSibling;
  if (myVideo.paused) {
    myVideo.play();
  } else {
    myVideo.pause();
  }
});

// //  计算视频时间
// function videoTime(){
//   setTimeout(function () {
//     var myvideo=$(".zhibodet .videobox");
//     console.log(myvideo)
//     var minute = parseInt(myvideo.duration / 60);
//     var second = parseInt(myvideo.duration % 60);
//     if (minute < 10) {
//       minute = '0' + minute;
//     }
//     if (second < 10) {
//       second = '0' + second;
//     }
//     var time = minute + ":" + second;
//     myvideo.siblings(".video-time").html(time);
//     myvideo.removeClass("notime");
//   }, 1000);
// }

//视频删除
mui(".zhibo").on("tap", ".shipindelbtn", function () {
  var btnArray = ['取消', '确认'],that=this;
  mui.confirm('确定删除？', ' ', btnArray, function (e) {
    if (e.index == 1) {
      $(that).parents("div.zhibo-item").remove();
    }
  });
});
