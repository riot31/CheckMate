<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>
  <tr>
    <td>name</td>
    <td>${user.username}</td>
  </tr>

  <tr>
    <td>email</td>
    <td>${user.email}</td>
  </tr>

  <tr>
    <td>games</td>
    <td>${user.games}</td>
  </tr>

  <tr>
    <td>Win</td>
    <td>${user.games - user.losses}</td>
  </tr>
</table>

</body>
</html>
