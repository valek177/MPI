<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <title>Авторизация</title>
    </head>
    <body>
       
        <f:view>	
            <h:form>
                
                <div align="center">
                     <img src="img/header.jpg" align="middle"/>
                <h4>Введите логин и пароль</h4>
                <br>
                
                Логин:
                <h:inputText label="Login"
                             value="#{UserAuthController.curLogin}"                           
                             required="true">    
                </h:inputText>          
                &nbsp; Пароль:
                <h:inputText label="Password"
                             value="#{UserAuthController.curPassword}"                           
                             required="true">    
                </h:inputText>
                <br>
                 <br>
                <h:commandButton action="#{UserAuthController.check_user}"
                                 value="Войти"
                                 styleClass="btn btn-default"/>
                 <br>
                <h:messages errorClass="errorMessage"
                            globalOnly="true"/>
                </div>
                
            </h:form>
        </f:view>
    </body>
</html>