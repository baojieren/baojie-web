<div>
    <nav class="navbar navbar-inverse" style="background-color: rgb(0, 0, 0, 0); border: 0px">
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
            <div class="collapse navbar-collapse" id="rbj-nav-content">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="http://www.foreach.com.cn:8080/dubbo/" target="_blank"><span class="glyphicon glyphicon-retweet"> 服务治理</span></a></li>
                <#--登陆可见-->
                    <#if Session["userInfo"]?exists>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <img src="/img/userLogo.png" width="20"/>
                                ${userInfo.username}
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" style="background-color: rgb(0, 0, 0, 0)">
                                <li><a href="#"><span class="glyphicon glyphicon-user"> 个人信息</span></a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/logout.html"><span class="glyphicon glyphicon-off"> 退出</span></a></li>
                            </ul>
                        </li>
                    <#else >
                    <#--请登陆-->
                        <li>
                            <a onclick="showRbjSignModal()">
                                <span class="glyphicon glyphicon-user"> 登陆</span>
                            </a>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</div>