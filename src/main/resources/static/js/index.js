$(document).ready(function(){
  $('.banner').each(function() {
  var $showPic =$(this).find('.bannerxList li');
  var $btonBox=$(this).find('.bannerxBton');
  var _n=0;
  var _vt=5000;
  var _vf=2000;
  var timer;
  //生成角标
  for(i=1;i<=$showPic.length;i++){
    $btonBox.append('<li>'+'<img />'+'</li>');
  }
  var $btonList=$btonBox.children('li');
  //鼠标事件
  $btonList.each(function(e){
      $(this).hover(function(){
        clearInterval(timer);
        showImg(e);
        _n=e;
      },function(){
        timer = setInterval(auto,_vt);
      });
    });
  //图片轮换
  var showImg= function(n){
    $showPic.eq(n).fadeIn(_vf).siblings().fadeOut();
    $btonList.eq(n).addClass('up').siblings().removeClass('up');
    
  }
  //自动播放
  var auto=function(){
    showImg(_n);
    _n++
    if(_n == $showPic.length){_n=0;}
  }
  timer = setInterval(auto,_vt);
  showImg(_n);
  _n++;
  });
});

$(function(){
          var wid=$(window).width();
          var he=wid/1920*642;
          $(".bannerx").css("height",he);
          $(".bannerxBox").css("height",he);
          $(".bannerxBox").css("width",wid);
          $(".bannerxBox").css("margin","0 auto");
          $(".bannerxList li a img").css("width",wid);
          $(".bannerxList li a img").css("height",he);
          //alert(wid);
        });
	
function setTab(name,cursel,n)
{
	for(i=1;i<=n;i++)
	{
		var menu=document.getElementById(name+i);
		var con=document.getElementById("con_"+name+"_"+i);
		menu.className=i==cursel?"hover":"";
		con.style.display=i==cursel?"block":"none";
	}
};

//加入收藏
 
        function AddFavorite(sURL, sTitle) {
 
            sURL = encodeURI(sURL); 
        try{   
 
            window.external.addFavorite(sURL, sTitle);   
 
        }catch(e) {   
 
            try{   
 
                window.sidebar.addPanel(sTitle, sURL, "");   
 
            }catch (e) {   
 
                alert("加入收藏失败，请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");
 
            }   
 
        }
 
    }
 
    //设为首页
 
    function SetHome(url){
 
        if (document.all) {
 
            document.body.style.behavior='url(#default#homepage)';
 
               document.body.setHomePage(url);
 
        }else{
 
            alert("您好,您的浏览器不支持自动设置页面为首页功能,请您手动在浏览器里设置该页面为首页!");
 
        }
 

    }
   //首页产品切换
   //
$(function(){
   $(".abc:eq(0)").css("display","block");
})
function yishang(id){
  $(".abc").hide();
  $(".abc"+id).show();
}
$(function(){
    //rencai
     $(".rencai .list ul li:eq(0)").addClass("active");
     $(".rencai .list ul li").mouseover(function() {
            var i = $(this).index();
            $(this).addClass("active").siblings().removeClass("active");
            $(".rencai_bot .abc").each(function() {
                $(this).hide();
            });     
      $(".rencai_bot .abc").eq(i).show();
  
        });
  //荣誉
      $(".hor .hor_top ul li:eq(0)").addClass("active");
     $(".hor .hor_top ul li").mouseover(function() {
            var i = $(this).index();
            $(this).addClass("active").siblings().removeClass("active");
            $(".hor_bot ul").each(function() {
                $(this).hide();
            });     
      $(".hor_bot ul").eq(i).show();
  
        });
     //荣誉
    $(".dq .t1 .list ul li:eq(0)").addClass("active");
     $(".dq .t1 .list ul li").mouseover(function() {
            var i = $(this).index();
            $(this).addClass("active").siblings().removeClass("active");
            $(".dq_bot ul").each(function() {
                $(this).hide();
            });     
      $(".dq_bot ul").eq(i).show();
  
        });
        //新闻
      $(".new .news .list ul li:eq(0)").addClass("active");
     $(".new .news .list ul li").mouseover(function() {
            var i = $(this).index();
            $(this).addClass("active").siblings().removeClass("active");
            $(".news_bot ul").each(function() {
                $(this).hide();
            });     
      $(".news_bot ul").eq(i).show();
  
        });

});
 