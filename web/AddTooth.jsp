<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
             <link rel="stylesheet" type="text/css" href="bootstrap.css">	
        <link rel="stylesheet" type="text/css" href="bootstrap-theme.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

        <title>Добавление зуба</title>
    </head>
    <body>
        <div class="container" align="center">
            <h4>Добавление зуба в СУЗ</h4>
        </div>
        <div class="container" align="center">
                                                        
        <f:view>	
            <h:form enctype="multipart/form-data">
                <div align="right">
<h:commandButton value="Выйти" action="#{UserAuthController.unAuthorize}" styleClass="btn btn-primary"/>
<h:commandButton value="Редактировать профиль" action="#{UserAuthController.editProfile}" styleClass="btn btn-primary"/>
</div>
                <table>
                <tr>
                    <td align="right" valign="top">
                        Форма 
                        <h:selectOneMenu value="#{AddToothController.selectedShape}" styleClass="dropdown-toggle">
                                 <f:selectItem itemValue="Конический" />
                                 <f:selectItem itemValue="Цилиндрический" />
                                 <f:selectItem itemValue="Эллиптический" />
                        </h:selectOneMenu>
                        <br>
                         <br>
                         Фактура 
                         <h:selectOneMenu value="#{AddToothController.selectedTexture}" styleClass="dropdown-toggle">
                                <f:selectItem itemValue="Матовый шершавый" />
                                 <f:selectItem itemValue="Матовый гладкий" />
                                 <f:selectItem itemValue="Глянцевый" />
                        </h:selectOneMenu>
                        <br>    
                         <br>
                         Повреждения
                         <h:selectOneMenu value="#{AddToothController.selectedDefect}" styleClass="dropdown-toggle">
                                 <f:selectItem itemValue="Без дефектов" />
                                 <f:selectItem itemValue="С трещиной" />
                                 <f:selectItem itemValue="Со сколом" />
                                  <f:selectItem itemValue="Разрушенный" />
                        </h:selectOneMenu>
                         <br>  
                          <br>
                        Длина(см)
                         <h:inputText id="Size" label="..." value="#{AddToothController.size}">
                            <f:validateLongRange minimum="0" maximum="10" />
                         </h:inputText>
                         <h:message for="Size" style="errorMessage" />
                         <br>  
                          <br>
                         Когда выпал
                         <h:inputText value="#{AddToothController.lossDate}">  
                            <f:convertDateTime pattern="yyyy-MM-dd"/>  
                         </h:inputText>
                         <br>  
                          <br>
                         Номер зуба
                         <h:selectOneMenu value="#{AddToothController.selectedPosition}" styleClass="dropdown-toggle ">
                                 <f:selectItem itemValue="1П" />
                                 <f:selectItem itemValue="2П" />
                                 <f:selectItem itemValue="3П" />
                                 <f:selectItem itemValue="4П" />
                                 <f:selectItem itemValue="5П" />
                                 <f:selectItem itemValue="6П" />
                                 <f:selectItem itemValue="1Л" />
                                 <f:selectItem itemValue="2Л" />
                                 <f:selectItem itemValue="3Л" />
                                 <f:selectItem itemValue="4Л" />
                                 <f:selectItem itemValue="5Л" />
                                 <f:selectItem itemValue="6Л" />
                        </h:selectOneMenu>
                    </td>
                    <td>&nbsp;</td>
                    <td align="center">
                        <div align="center">Описание</div>   
                        <h:inputTextarea value="#{AddToothController.description}" rows="5">  
                        </h:inputTextarea>
                        <br>
                         <br>
                        <div>
                            <h:inputFile value="#{AddToothController.photo}" validator="#{AddToothController.validateFile}" styleClass="btn btn-default"/>
                            <h:commandButton value="Загрузить фотографию"   action="#{AddToothController.upload()}" styleClass="btn btn-primary"/>       

                            <div>
                                <img src="data:image/jpg;base64, ${AddToothController.photoContent}" width="100" height="100"/>  
                            </div>
                        </div>
                    </td>
                </tr>
                 </table>
                        
                <h:messages id="errors" errorClass="errorMessage" globalOnly="true"/>
                <div align="center">
                    <h:commandButton value="Послать" action="#{AddToothController.addTooth()}" styleClass="btn btn-success"/>  
                </div>
            </h:form>
        </f:view>   
        </div>
        <img src="img/1.jpg" align="right" height="200" width="200" />
    </body>
</html>
