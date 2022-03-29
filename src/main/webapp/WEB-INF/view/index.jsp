<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

    <title>Accident</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">

            <div class="card-header">
                Строки
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Строка</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="value">
                        <c:url var = "updateButton" value="/updateInfo">
                            <c:param name = "empId" value = "${value.id}"/>
                        </c:url>
                        <tr>
                            <td>
                                <c:out value="${value.accidentType}"/>
                            </td>
                            <td>
                                <c:out value="${value.rules}"/>
                            </td>
                            <td>
                                <c:out value="${value.id}"/>
                            </td>
                            <td>
                                <c:out value="${value.name}"/>
                            </td>
                            <td>
                                <c:out value="${value.text}"/>
                            </td>
                            <td>
                                <c:out value="${value.address}"/>

                            </td>
                            <td><input type="button" value="update" onclick="window.location.href='${updateButton}'"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <a href="<c:url value='/create'/>">Добавить инцидент</a>
    </div>
</div>

</body>
</html>