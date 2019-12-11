<%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/6
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>携程旅游</title>
    <link rel="stylesheet" type="text/css" href= "zhuye.css"/>
</head>
<!--加-->
<body id="top">

<div class="a">
    <div class="a1">
        <ul>
            <li><a href="" id="s1">首页</a>|</li>
            <li><a href="hotel.jsp">酒店</a>|</li>
            <li><a href="travel.jsp">旅游</a>|</li>

            <li><a href="bus.jsp">公交车</a>|</li>
            <li><a href="question.jsp">常见问题</a>|</li>

        </ul>
    </div>
    <div class="a2">
        <%
            Cookie[] cookie=request.getCookies();
            if(cookie!=null){
                for(Cookie c:cookie){
                    if(c.getName().equals("username")) {
                        out.print("<a href=# id=a1 target=_blank>" + c.getValue() + "</a><br>");
                    }
                    out.print("<a id=a3 href=http://localhost:8080/tourist_project_war_exploded/ExitSelvelt>退出账号</a>");
                }
            }else {
                out.print("<a href=动态效果/Untitled-3.html id=a1 target=_blank>登入</a>|<a id=a2 href=register.html>注册</a>");
            }
        %>



        <div class="a21">
            <p class="a211"><a href="动态效果/11/投诉建议子页.html" target="_blank">投诉建议</a></p>
            <p><a href="">全部订单</a></p>
            <p><a href="">手机号查订单</a></p>
        </div>
    </div>
    <div class="a3">
        <ul>
            <li><a href="#j1">国内游</a></li>
            <li><a href=" #j2">出境游</a></li>
            <li><a href=" #j3">周边游</a></li>
            <li><a href=" #j4">其他服务</a></li>
            <li><a href=" #j5">诚信网站</a></li>
        </ul>
    </div>
    <div class="a4">
        <script language =javascript >
            var curIndex=0;
            //时间间隔(单位毫秒)，每3秒钟显示一张，数组共有20张图片放在Photos文件夹下。
            var timeInterval=1500;
            var arr=new Array();
            arr[0]="../img/1.jpg";
            arr[1]="../img/2.jpg";
            arr[2]="../img/3.jpg";
            arr[3]="../img/4.jpg";
            arr[4]="../img/5.jpg";
            arr[5]="../img/6.jpg";
            arr[6]="../img/7.jpg";
            arr[7]="../img/8.jpg";
            arr[8]="../img/9.jpg";
            arr[9]="../img/10.jpg";
            arr[10]="../img/11.jpg";
            arr[11]="../img/12.jpg";
            arr[12]="../img/13.jpg";
            arr[13]="../img/14.jpg";
            arr[14]="../img/15.jpg";
            arr[15]="../img/16.jpg";
            arr[16]="../img/17.jpg";
            arr[17]="../img/18.jpg";
            arr[18]="../img/19.jpg";
            arr[19]="../img/20.jpg";
            setInterval(changeImg,timeInterval);
            function changeImg()
            {
                var obj=document.getElementById("jpg");
                if (curIndex==arr.length-1)
                {
                    curIndex=0;
                }
                else
                {
                    curIndex+=1;
                }
                obj.src=arr[curIndex];
            }
        </script>
        <img src="../img/1.jpg" alt="" id="jpg" />
    </div>
</div>
<div class="b">
    <p><span class="b1" id="j1">国内游</span><span class="b2">行千山万水中，足迹遍布中国</span><a href="if1.html" target="iframe1">跟团游</a><a href="if12.html" target="iframe1">自由行</a><a href="if13.html" target="iframe1">手机专享</a>
    </p>
    <iframe name="iframe1" width="870px" height="740px" src="if1.html"></iframe>
</div>
<div class="c">
    <p><span class="c1" id="j2">出境游</span><span class="c2">行千山万水中，足迹遍布中国</span><a href="if2.html" target="iframe2">跟团游</a><a href="if22.html" target="iframe2">自由行</a><a href="if23.html" target="iframe2">手机专享</a><a href=" #top">返回</a>
    </p>
    <iframe src="if2.html" name="iframe2" width="870px" height="730px"></iframe>
</div>
<div class="d">
    <p><span class="d1" id="j3">周边游</span><span class="d2">行千山万水中，足迹遍布中国</span><a href="if3.html" target="iframe3">跟团游</a><a href="if32.html" target="iframe3">自由行</a><a href="if33.html" target="iframe3">手机专享</a><a href=" #top">返回</a>
    </p>
    <iframe name="iframe3" src="if3.html" width="870px" height="730px"></iframe>
</div>
<div>
    <a href="UTF8/index.html">登录管理系统</a>
</div>
</body>
</html>

