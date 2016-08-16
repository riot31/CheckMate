<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>

    <title><sitemesh:write property="title"/></title>
    <link rel="stylesheet" href="/resources/css/style.css"/>

    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="/resources/js/prefixfree.min.js"></script>
    <sitemesh:write property='head'/>
</head>
<body>

<nav id="menu-wrap">
    <ul id="menu">
        <li><a href="/">${f:getMessage('navigation.home')}</a></li>

        <li>
            <a href="/game/show">${f:getMessage("navigation.game")}</a>
            <ul>
                <li id="createGame">
                    <label for="modal-3">${f:getMessage("navigation.game.create")}</label>
                </li>
                <li>
                    <a href="/game/show">${f:getMessage("navigation.game.show")}</a>
                </li>

                <li>
                    <a href="/boots">${f:getMessage("navigation.game.boot")}</a>
                </li>
                <li>
                    <a href="#">${f:getMessage("navigation.game.task")}</a>
                </li>
            </ul>
        </li>

        <li>
            <a href="#">${f:getMessage("navigation.about")}</a>
            <ul>
                <li><a href="/regulations">${f:getMessage("navigation.regulations")}</a></li>
                <li><a href="/statistics">${f:getMessage("navigation.statistics")}</a></li>
                <li><a href="/game/findAll">${f:getMessage("navigation.games")}</a></li>
                <li><a href="#">${f:getMessage("navigation.forum")}</a></li>
            </ul>
        </li>

        <li><a href="/offer/show">${f:getMessage("navigation.offers")}</a></li>
        <sec:authorize access="isAnonymous()">
            <li><label class="btn-label" for="modal-1" id="sign-label">Вход</label></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li>
                <a href="/user/statistics" id="username">${username}</a>
                <ul>

                    <li>
                        <a href="/user/statistics">${f:getMessage("navigation.user.home")}</a>

                    </li>
                    <li>
                        <a href="/game/byUser">${f:getMessage("navigation.user.games")}</a>

                    </li>
                    <li>
                        <a href="/logout">${f:getMessage("navigation.logout")}</a>

                    </li>
                </ul>
            </li>
        </sec:authorize>

    </ul>
</nav>

<sitemesh:write property="body"/>
<div class="footer">
    ${f:getMessage("footer.message")}
</div>

<sec:authorize access="isAnonymous()">

    <div class="modal">
        <input type="checkbox" class="modal-open" id="modal-1" hidden/>

        <div class="modal-wrap" aria-hidden="true" role="dialog">
            <label for="modal-1" class="modal-overlay"></label>

            <div class="modal-dialog">
                <div class="modal-header">
                    <h2>Войдите или <label id="reg-label" class="btn-label" for="modal-2">зарегистрируйтесь</label></h2>
                    <label for="modal-1" class="btn-close" aria-hidden="true">×</label>
                </div>
                <div class="modal-body">
                    <form action="/login" method="post">
                        <input name="username" placeholder="${f:getMessage("form.placeholder.username")}" class="textbox"
                               required/>
                        <input name="password" placeholder="${f:getMessage("form.placeholder.password")}" class="textbox"
                               type="password" required/>
                        <input name="remember-me" id="check" type="checkbox" checked="checked"/>
                        <label for="check">${f:getMessage("form.remember")}</label>

                        <input name="submit" class="btn btn-form" type="submit" value="${f:getMessage("form.submit")}"/>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <div class="modal">
        <input type="checkbox" class="modal-open" id="modal-2" hidden/>

        <div class="modal-wrap" aria-hidden="true" role="dialog">
            <label for="modal-2" class="modal-overlay"></label>

            <div class="modal-dialog">
                <div class="modal-header">
                    <h2>Регистрация</h2>
                    <label for="modal-2" class="btn-close" aria-hidden="true">×</label>
                </div>
                <div class="modal-body">
                    <form action="/user/add" method="post">
                        <input name="username" placeholder="${f:getMessage("form.placeholder.username")}" class="textbox"
                               required/>
                        <input name="email" placeholder="${f:getMessage("form.placeholder.email")}" class="textbox"
                               type="email" required/>
                        <input name="password" placeholder="${f:getMessage("form.placeholder.password")}" class="textbox"
                               type="password" required/>
                        <input name="submit" class="btn btn-form" type="submit" value="${f:getMessage('form.submit')}"/>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.getElementById("sign-label").addEventListener("click", setSelected, false);
        document.getElementById("reg-label").addEventListener("click", setSelected, false);

        function setSelected(evt) {
            if (evt.target.id == "sign-label") {
                document.querySelector("form[action='/login'] input[name='username']").select();
            }
            if (evt.target.id == "reg-label") {
                document.querySelector("form[action='/user/add'] input[name='username']").select();
            }
        }

    </script>
</sec:authorize>


<div class="modal">
    <input type="checkbox" class="modal-open" id="modal-3" hidden/>

    <div class="modal-wrap" aria-hidden="true" role="dialog">
        <label for="modal-3" class="modal-overlay"></label>

        <div class="modal-dialog">
            <div class="modal-header">
                <h2>Создать игру</h2>
                <label for="modal-3" class="btn-close" aria-hidden="true">×</label>
            </div>
            <div class="modal-body">
                <form action="/game/create" method="post">
                    <input name="headline" placeholder="${f:getMessage("form.placeholder.game.headline")}" type="text" class="textbox"/>
                    <input type="hidden" name="member1" value="${username}"/>
                    <input list="rivals" placeholder="${f:getMessage("form.placeholder.member2")}" name="member2" class="textbox"/>
                    <datalist id="rivals">
                    </datalist>

                    <p>${f:getMessage("form.createGame")}</p>
                    <input name="submit" class="btn btn-form" type="submit" value="${f:getMessage('form.submit')}"/>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/main.js"></script>

</body>
</html>
