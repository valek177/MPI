<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Зуб добавлен!</title>
    </head>
    <body>
        <h1>Зуб успешно добавлен в систему!</h1>
        <f:view>	
            <h:form>
            <h:commandButton action="main.jsp"
                                 value="Перейти на главную страницу"
                                 styleClass="buttonCheck"/>
             </h:form>
        </f:view>
        
    </body>
</html>
