<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предложения</title>
</head>
<body>

<h2>${f:getMessage("page.offers.info")}</h2>

<sec:authorize access="isAuthenticated()">
  <div class="right">
    <label class="btn btn-form" for="modal-4">${f:getMessage("page.offers.add")}</label>
  </div>
</sec:authorize>

<c:if test="${offers.size() > 3}">
  <h2>${f:getMessage("page.offers.pop")}</h2>

  <p>adsdad</p>

  <p>weqweqw</p>

  <p>trtr</p>
</c:if>


<h2>${f:getMessage("page.offers.adding")}</h2>

<c:forEach items="${offers}" var="offer">
  <p>${offer.user.username} ${offer.message} <a href="/offer/increment?id=${offer.id}">^</a>${offer.getEvaluation()}<a href="/offer/decrement?id=${offer.id}">v</a> из ${offer.evaluationList.size()} голосов</p>
</c:forEach>




<div class="modal">
  <input type="checkbox" class="modal-open" id="modal-4" hidden/>

  <div class="modal-wrap" aria-hidden="true" role="dialog">
    <label for="modal-4" class="modal-overlay"></label>

    <div class="modal-dialog">
      <div class="modal-header">
        <h2>Предложить идею</h2>
        <label for="modal-4" class="btn-close" aria-hidden="true">×</label>
      </div>
      <div class="modal-body">
        <form action="/offer/add" method="post">
          <textarea name="message" placeholder="${f:getMessage("form.placeholder.game.headline")}" class="textbox" rows="4"></textarea>

          <p>${f:getMessage("form.createGame")}</p>
          <input name="submit" class="btn btn-form" type="submit" value="${f:getMessage('form.submit')}"/>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
