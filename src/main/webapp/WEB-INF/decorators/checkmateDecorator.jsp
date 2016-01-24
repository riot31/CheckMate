<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<html>
<head>

  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>

  <title><sitemesh:write property="title"/></title>
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <link rel="stylesheet" href="/resources/css/style.css"/>

</head>
<body>

<sitemesh:write property="body"/>
<div class="footer">
 ${f:getMessage("footer.message")}
</div>
</body>
</html>
