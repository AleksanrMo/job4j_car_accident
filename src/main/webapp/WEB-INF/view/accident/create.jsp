<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>


<form:form action="save" modelAttribute="accident">
    id <form:input path = "id"/>
    <br>
    Заголовок <form:input path="name"/>
    <br>
    Описание <form:input path="text"/>
    <br>
    Адрес <form:input path="address"/>
    <br>
    <input type="submit" value="Зарегистрировать"/>
</form:form>
</body>
</html>