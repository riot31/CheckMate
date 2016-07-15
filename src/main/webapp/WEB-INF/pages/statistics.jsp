<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Game List</title>
  <link rel="stylesheet" href="/resources/css/normalize.css"/>
  <link rel="stylesheet" href="/resources/css/table.css"/>
  <link rel="stylesheet" href="/resources/css/component.css"/>
</head>
<body>

<div class="container">
  <div class="component">
    <table>
      <thead>
      <tr>
        <th>${f:getMessage("user.name")}</th>
        <th>${f:getMessage("user.rang")}</th>
        <th>${f:getMessage("user.game")}</th>
        <th>${f:getMessage("user.win")}</th>
        <th>${f:getMessage("user.email")}</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${userList}" var="user">
        <tr>
          <td class="user-name">${user.username}</td>
          <td class="user-name">Новичёк</td>
          <td class="user-phone">${user.games}</td>
          <td class="user-mobile">${user.games - user.losses}</td>
          <td class="user-email">${user.email}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
<script src="/resources/js/jquery.stickyheader.js"></script>
<script>
  $('tr[data-href]').on("click", function() {
    document.location = $(this).data('href');
  });
</script>
</body>
</html>
