<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Boots</title>
  <link rel="stylesheet" href="/resources/css/normalize.css"/>
  <link rel="stylesheet" href="/resources/css/table.css"/>
  <link rel="stylesheet" href="/resources/css/component.css"/>

</head>
<body>
<%--TODO ROLE_ADMIN--%>
<sec:authorize access="hasRole('ROLE_USER')">
  <div class="right">
    <label class="btn btn-form" for="modal-scramble">Натравить их друг на друга</label>
  </div>
</sec:authorize>

<div class="container">
  <div class="component">
    <p>
      ${f:getMessage("page.boots.info")}
    </p>

    <table>
      <thead>
      <tr>
        <th>${f:getMessage("page.boots.name")}</th>
        <th>${f:getMessage("page.boots.description")}</th>
        <th>${f:getMessage("page.boots.timeStroke")}</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${boots}" var="boot">
        <tr data-href="${boot.url}">
          <td class="user-name">${boot.bootName}</td>
          <td class="user-email">${boot.description}</td>
          <td class="user-email">${boot.timeStroke}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>
</div>


<div class="modal">
  <input type="checkbox" class="modal-open" id="modal-scramble" hidden/>

  <div class="modal-wrap" aria-hidden="true" role="dialog">
    <label for="modal-scramble" class="modal-overlay"></label>

    <div class="modal-dialog">
      <div class="modal-header">
        <h2>CXBATKA </h2>
        <label for="modal-scramble" class="btn-close" aria-hidden="true">×</label>
      </div>
      <div class="modal-body">
        <form action="/boot/create" method="post">
          <input name="member1" placeholder="${f:getMessage("form.placeholder.username")}" class="textbox"
                 required/>
          <input name="member2" placeholder="${f:getMessage("form.placeholder.username")}" class="textbox"
                 required/>
          <input name="submit" class="btn btn-form" type="submit" id="create-scramble" value="${f:getMessage("form.submit")}"/>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
<script src="/resources/js/jquery.stickyheader.js"></script>
<script>
  $('tr[data-href]').on("click", function () {
    document.location = $(this).data('href');
  });

  document.getElementById("create-scramble").addEventListener("click", gameScramble, false);
  function gameScramble() {
    $('#modal-scramble').click();
  }

</script>

</body>
</html>
