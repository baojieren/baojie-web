<div>
    <nav class="navbar navbar-inverse rbj-bg-color">
        <div class="container">
        <#--手机可折叠-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            <#--Logo-->
                <span class="navbar-brand">
                    <img src="https://img.alicdn.com/tps/TB1BQh7LpXXXXcJXFXXXXXXXXXX-198-46.gif"
                         style="margin-top: -12px">
                </span>
            </div>

        <#--导航栏内容-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-retweet"> 服务治理</span></a></li>

                <#--登陆可见-->
                <#--<li class="dropdown">-->
                <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"-->
                <#--aria-expanded="false">-->
                <#--<img src="/img/userLogo.png" width="20"/>-->
                <#--<span class="caret"></span>-->
                <#--</a>-->
                <#--<ul class="dropdown-menu">-->
                <#--<li><a href="#"><span class="glyphicon glyphicon-user"> 个人信息</span></a></li>-->
                <#--<li role="separator" class="divider"></li>-->
                <#--<li><a href="#"><span class="glyphicon glyphicon-off"> 退出</span></a></li>-->
                <#--</ul>-->
                <#--</li>-->
                <#--请登陆-->
                    <li>
                        <#--<a data-toggle="modal" data-target="#rbj-sign-modal">-->
                        <a onclick="showRbjSignModal()">
                            <span class="glyphicon glyphicon-user"> 登陆</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>