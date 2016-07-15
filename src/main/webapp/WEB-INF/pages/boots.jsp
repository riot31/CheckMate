<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Boots</title>
  <link rel="stylesheet" href="/resources/css/normalize.css"/>
  <link rel="stylesheet" href="/resources/css/table.css"/>
  <link rel="stylesheet" href="/resources/css/component.css"/>

</head>
<body>
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

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
<script src="/resources/js/jquery.stickyheader.js"></script>
<script>
  $('tr[data-href]').on("click", function () {
    document.location = $(this).data('href');
  });
</script>

</body>
</html>
