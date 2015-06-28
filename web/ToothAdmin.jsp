<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.css">	
        <link rel="stylesheet" type="text/css" href="bootstrap-theme.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

        <title>Управление зубами</title>
    </head>
    <body>
       <div class="container" align="center">
            <h4>Управление зубами</h4>
        </div>
        <div class="container" align="center">
        <f:view>	
            <h:form enctype="multipart/form-data">
                 <div align="right">
                    Текущий пользователь: <h:outputLabel value="#{UserAuthController.currentUser.name}"/>
                </div>
                <div align="right">
                    <h:commandButton value="Выйти" action="#{UserAuthController.unAuthorize}" styleClass="btn btn-primary"/>
                    <h:commandButton value="Назад" action="#{ToothAdminController.GoBack}" styleClass="btn btn-primary"/>
                </div>
               
                <div>
                    <h:dataTable value="#{ToothAdminController.toothList}" var="tooth" border="1" styleClass="table">
                        <h:column>
                            <f:facet name="header">  <h:outputText value="Номер зуба"/>  </f:facet>    
                            <h:outputText value="#{tooth.position}"/>  
                        </h:column>
                        <h:column>
                            <f:facet name="header">  <h:outputText value="Имя ребенка"/>  </f:facet>    
                            <h:outputText value="#{tooth.childName}"/>  
                        </h:column>
                         <h:column>
                            <f:facet name="header">  <h:outputText value="Дата выпадения"/>  </f:facet>    
                            <h:outputText value="#{tooth.lossDate}"/>  
                        </h:column>
                         <h:column>
                            <f:facet name="header">  <h:outputText value="Оценка"/>  </f:facet>    
                            <h:outputText value="#{tooth.cost}"/>  
                        </h:column>
                         <h:column>
                            <f:facet name="header">  <h:outputText value="Фото"/>  </f:facet>    
                            <h:graphicImage value="#{tooth.photoContent}" width="100" height="100"/>  
                        </h:column>
                         <h:column>
                            <f:facet name="header">  <h:outputText value=""/>  </f:facet>    
                            <h:commandButton action="#{tooth.DeleteFromDb}" styleClass="btn btn-danger"
                                value="Удалить">
                               

                            </h:commandButton>
                        </h:column>
                    </h:dataTable>
                </div>
             </div>        
            <h:messages id="errors" errorClass="errorMessage" globalOnly="true"/>
            <div align="center">
                <h:commandButton value="Сохранить" action="#{EditProfileController.updateProfile}" styleClass="btn btn-success"/>  
            </div>
            </h:form>
        </f:view>   
        </div>
    </body>
</html>
