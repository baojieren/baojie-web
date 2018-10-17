<!DOCTYPE html>
<html>
<head>
    <meta name="baidu-site-verification" content="fXnSkPBzlh" />
    <meta charset="UTF-8">
    <title>vip视频解析,爱奇艺,优酷,腾讯视频</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta content="vip视频解析,爱奇艺,优酷,腾讯视频" name="keywords">
    <meta content="vip视频解析,爱奇艺,优酷,腾讯视频" name="description">
    <meta content="baojie" name="author">
    <link rel="icon" href="/img/logo.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/img/logo.ico" type="image/x-icon"/>
    <link rel="bookmark" href="/img/logo.ico" type="image/x-icon"/>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/sweetalert2.all.min.js"></script>
    <style>
        .rbj-bg-color{
            background-color: rgb(40, 40, 40, 0.6);
            font-weight: bold;
            color: black;
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
<body class="img-responsive" style="background-color: #2b2b2b">
<#include "page/top.ftl">
<div id="rbj-search" class="container-fluid">
    <div class="row">
        <div class="col-xs-8 col-sm-6 col-md-4 col-lg-4 col-xs-offset-2 col-sm-offset-3 col-md-offset-4 col-lg-offset-4">
            <div style="float: left">
                <select id="apiType" class="form-control" style="max-width: 150px;border: none;background-color: #5cb85c;font-weight: bold"></select>
            </div>
            <div class="input-group">
                <input id="videoUrlInput" type="text" class="form-control rbj-bg-color" placeholder="视频地址粘贴进来即可">
                <span class="input-group-btn">
                    <button class="btn btn-success" type="button" id="doPlay">免费播放</button>
                </span>
            </div>
        </div>
    </div>
</div>
<br>

<div id="rbj-support-type" style="text-align: center;color: white;font-weight: bold;font-size: 24px" hidden><br>
    <span class="label label-danger">基本主流视频网站都支持</span><br><br><br>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-3">
                <img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3802719212,804960187&fm=26&gp=0.jpg"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
            <div class="col-md-3 col-lg-3">
                <img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2577259750,1150388651&fm=58&s=2124D41287E16D014ECD49C6000010B3"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
            <div class="col-md-3 col-lg-3">
                <img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3648390168,1713673067&fm=58&s=6BC28852DD305C0354F4835E02001073&bpow=121&bpoh=75"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
            <div class="col-md-3 col-lg-3">
                <img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1570004253,204663066&fm=58&bpow=640&bpoh=480"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
        </div>
        <br><br>
        <div class="row">
            <div class="col-md-3 col-lg-3">
                <img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3865467473,993803154&fm=58&s=77F62972CDA06C01187402EC0200E036&bpow=121&bpoh=75"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
            <div class="col-md-3 col-lg-3">
                <img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2552131531,889738107&fm=58&s=CC87C712CDB7EE114E6B8546020070BB&bpow=121&bpoh=75"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
            <div class="col-md-3 col-lg-3">
                <img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4278866917,2478953267&fm=58&s=0DE6CD1393B06D805451B0D6000080B1&bpow=121&bpoh=75"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
            <div class="col-md-3 col-lg-3">
                <img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=592793815,3099896906&fm=58&s=FEC7E91ED4B1F9821E7D8CC400009031&bpow=121&bpoh=75"
                     style="width: 120px; height: 75px;" class="img-rounded">
            </div>
        </div>
    </div>
</div>

<div id="rbj-video" style="text-align: center" hidden>
    <iframe id="iframe" src="" width="60%" height="650px" frameborder="0"></iframe>
</div>
<#--bing-->
<div id="rbj-bing-title" style="position: fixed; bottom: 30px">
    <div class="container-fluid">
        <div class="col-md-12 col-sm-12">
            <h3 style="color: white"></h3>
            <#--<a onclick="switchBingImg(1)" style="font-size: 30px;color: white; text-decoration: none">-->
                <#--<i class="glyphicon glyphicon-chevron-left"></i>-->
            <#--</a>&nbsp;&nbsp;-->
            <#--<a onclick="switchBingImg(-1)" style="font-size: 30px;color: white; text-decoration: none">-->
                <#--<i class="glyphicon glyphicon-chevron-right"></i>-->
            <#--</a>&nbsp;&nbsp;-->
            <#--<a id="downLoadImg" style="font-size: 30px;color: white">-->
                <#--<i class="glyphicon glyphicon-download-alt"></i>-->
            <#--</a>-->
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
<#--video-->
<script>
    var vipVideoUrlArr = [];
    $(function () {
        var videoUrlInput = $("#videoUrlInput").val();
        if (videoUrlInput) {
            $("#rbj-video").show();
            var apiType = $("#apiType").val();
            $("#iframe").attr({src: apiType + videoUrlInput + ""});
        }else {
            $("#rbj-support-type").show();
        }

        $.ajax({
            type: "POST",
            url: "/vipVideoUrl/vipVideoUrlList.html",
            dataType: "json",
            async: true,
            success: function (dat) {
                if(dat.data!= null) {
                    for (var idx = 1; idx <= dat.data.length; idx++) {
                        vipVideoUrlArr.push(dat.data[idx].url);
                        $("#apiType").append('<option value="'+idx+'">'+dat.data[idx].mark+'</option>')
                    }
                }
            }
        });

    });

    $("#doPlay").click(function () {
        var videoUrlInput = $("#videoUrlInput").val();
        if (videoUrlInput) {
            $("#rbj-support-type").hide();
            $("#rbj-video").show();
            var apiType = $("#apiType").val();
            var a = vipVideoUrlArr[apiType];
            $("#iframe").attr({src: vipVideoUrlArr[apiType]+"" + videoUrlInput + ""});
        }
    })
</script>
<#--Bing-->
<script>
    var bingArray;
    var index = 1;
    $(function () {
        var piexl='';
        if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
            piexl='240x400';
        } else {
            piexl='1920x1080';
        }
        $.ajax({
            type: "POST",
            url: "/getBingImgJson.html?piexl="+piexl,
            dataType: "json",
            async: true,
            success: function (dat) {
                bingArray = dat;
                $("#rbj-bing-title h3").text(bingArray[index].copyright);
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
        $("#rbj-bing-title h3").text(bingArray[index].copyright);
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