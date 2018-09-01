<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>A&nbsp;O</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta content="宝杰任" name="keywords">
    <meta content="宝杰任" name="description">
    <meta content="宝杰任" name="author">
    <link rel="icon" href="/img/logo.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/img/logo.ico" type="image/x-icon"/>
    <link rel="bookmark" href="/img/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.1/sweetalert2.all.min.js"></script>
    <style>
        .rbj-bg-color{
            background-color: rgb(40, 40, 40, 0.6)
        }
        #rbj-nav-content a{
            color: white;
            font-weight: bolder;
            cursor: pointer;
            background-color: rgb(0, 0, 0, 0);
        }
        #rbj-nav-content a:hover{
            color: #5eb257;
            background-color: rgb(0, 0, 0, 0);
        }
    </style>
</head>
<body class="img-responsive">
<#include "page/top.ftl">
<#--bing-->
<div id="rbj-bing" style="position: fixed; bottom: 30px">
    <div class="container-fluid">
        <div class="col-md-12 col-sm-12">
            <h3 style="color: white"></h3>
            <a onclick="switchBingImg(1)" style="font-size: 30px;color: white; text-decoration: none">
                <i class="glyphicon glyphicon-hand-left"></i>
            </a>&nbsp;&nbsp;
            <a onclick="switchBingImg(-1)" style="font-size: 30px;color: white; text-decoration: none">
                <i class="glyphicon glyphicon-hand-right"></i>
            </a>&nbsp;&nbsp;
            <a id="downLoadImg" style="font-size: 30px;color: white">
                <i class="glyphicon glyphicon-hand-down"></i>
            </a>
            <#--<button id="" type="button" class="btn btn-warning">保存到本地</button>&nbsp;-->
            <#--<button id="" type="button" class="btn btn-danger">保存到服务器</button>-->
        </div>
    </div>
</div>
<a href="http://www.miitbeian.gov.cn" style="position: fixed;bottom: 2px;right: 2px;color: white"
   target="_blank">黔ICP备18008276号</a>
<#--登陆注册modal-->
<div class="modal fade" id="rbj-sign-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content rbj-bg-color">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span style="color: white">&times;</span>
                </button>
                <h4 id="rbj-sign-modal-title" style="color: white" class="modal-title">登陆</h4>
            </div>

            <div class="modal-body">
                <form id="rbj-sign-form">
                    <input name="username" type="text" class="form-control" placeholder="用户名"><br>
                    <input name="password" type="password" class="form-control" placeholder="密码" ><br>
                    <input name="email" type="email" class="form-control" placeholder="邮箱" style="display: none">
                    <p id="rbj-sign-tip" class="pull-right" style="color: white">没有账户?
                        <a onclick="switch2SignUp()" style="color: #5eb257">注册</a>
                    </p><br>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-warning" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-success" id="rbj-sign-btn">登陆</button>
            </div>
        </div>
    </div>
</div>
</body>
<#--Bing-->
<script>
    var bingArray;
    var index = 1;
    $(function () {
        $.ajax({
            type: "POST",
            url: "/getBingImgJson.html",
            dataType: "json",
            async: true,
            success: function (dat) {
                bingArray = dat;
                $("#rbj-bing h3").text(bingArray[index].copyright);
                $("body").css({
                    "background": "url(" + bingArray[index].url + ")",
                    "backgroundAttachment": "fixed"
                });
            }
        });
    });

    // 切换图片
    function switchBingImg(count) {
        if (index === 7 && count === 1) {
            swal({
                title: '<p style="color: white">过去的就让它过去</p>',
                html: '<p style="color: white">成为远远的远</p>',
                //warning，error，success，info和question
                type: 'info',
                background: 'rgb(40, 40, 40, 0.6)',
                animation: true,
                showConfirmButton: false,
                timer: 2000
            });
            return;
        }
        if (index === 0 && count === -1) {
            swal({
                title: '<p style="color: white">明天很美</p>',
                html: '<p style="color: white">但愿后天也是</p>',
                type: 'info',
                background: 'rgb(40, 40, 40, 0.6)',
                animation: true,
                showConfirmButton: false,
                timer: 2000
            });
            return;
        }

        index = index + count;
        $("#rbj-bing h3").text(bingArray[index].copyright);
        $("body").css({
            "background": "url(" + bingArray[index].url + ")",
            "backgroundAttachment": "fixed"
        });
    }

    // 下载图片
    $("#downLoadImg").click(function () {
        window.location.href = '/downLoadImg.html?imgUrl=' + bingArray[index].url + '&imgName=' + bingArray[index].copyright;
    })
</script>
<#--登陆modal-->
<script>
    // 手动开启modal
    function showRbjSignModal() {
        $("#rbj-sign-modal-title,#rbj-sign-btn").html("登陆");
        $("[name='email']").hide();
        $("#rbj-sign-tip").show();
        $("#rbj-sign-modal").modal('toggle');
    }
    // 注册
    function switch2SignUp() {
        $("#rbj-sign-modal-title,#rbj-sign-btn").html("注册");
        $("[name='email']").show();
        $("#rbj-sign-tip").hide();
    }

    // 登陆注册
    $("#rbj-sign-btn").click(function () {
        $.ajax({
            type: "POST",
            url: $(this).html() == "登陆" ? "/user/signIn.html" : "/user/signUp.html",
            data: $("#rbj-sign-form").serialize(),
            dataType: "json",
            async: false,
            success: function (dat) {
                if (dat.state == 1) {
                    if (null == dat.id) {
                        location.reload();
                    } else {
                        swal({
                            title: '<p style="color: white">注册成功</p>',
                            html: '<p style="color: white">已自动登陆</p>',
                            //warning，error，success，info和question
                            type: 'success',
                            background: 'rgb(40, 40, 40, 0.6)',
                            animation: true,
                            showConfirmButton: false,
                            timer: 2000
                        });
                        setTimeout(function () {
                            location.reload();
                        }, 2000);
                    }
                } else {
                    swal({
                        title: '<p style="color: white">登陆失败</p>',
                        html: '<p style="color: white">' + dat.message + '</p>',
                        //warning，error，success，info和question
                        type: 'error',
                        background: 'rgb(40, 40, 40, 0.6)',
                        animation: true,
                        showConfirmButton: false,
                        timer: 2000
                    });
                }
            }
        });
    })
</script>
</html>