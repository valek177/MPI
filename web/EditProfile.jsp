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

        <title>Редактирование профиля</title>
    </head>
     <body>
        <div class="container" align="center">
            <h4>Редактирование профиля</h4>
        </div>
        <div class="container" align="center">
                                                        
        <f:view>	
            <h:form enctype="multipart/form-data">
                <div align="right">
                    <h:commandButton value="Выйти" action="#{UserAuthController.unAuthorize}" styleClass="btn btn-primary"/>
                    <h:commandButton value="Назад" action="#{EditProfileController.GoBack}" styleClass="btn btn-primary"/>
                </div>
                <table>
                <tr>
                    <td align="center">
                        <div align="center">Описание</div>   
                        ФИО: <h:inputText value="#{EditProfileController.FIO}" >  
                        </h:inputText>
                        <br>
                        E-mail: <h:inputText value="#{EditProfileController.email}" >  
                        </h:inputText>

                    </td>
                </tr>
                 </table>
                
                    <h:panelGrid rendered="#{UserAuthController.userType == 1}">
                    <div>Подчиненные феи</div>
                    <div>
                        <h:dataTable value="#{EditProfileController.fairyList}" var="fairy" border="1" styleClass="table">
                            <h:column>
                                <f:facet name="header">  <h:outputText value="Имя"/>  </f:facet>    
                                <h:outputText value="#{fairy.name}"/>  
                            </h:column>
                            <h:column>
                                <f:facet name="header">  <h:outputText value="Опыт"/>  </f:facet>    
                                <h:outputText value="#{fairy.skill}"/>  
                            </h:column>
                             <h:column>
                                <f:facet name="header">  <h:outputText value="Выбрана"/>  </f:facet>    
                                <h:selectBooleanCheckbox styleClass="btn btn-danger" value="#{fairy.assignedToFairy}"/>
                            </h:column>
                        </h:dataTable>
                    </div>
                    </h:panelGrid>
                    <h:panelGrid rendered="#{UserAuthController.userType == 4}">
                    <div>Дети</div>
                    <div>
                        <h:dataTable value="#{EditProfileController.childList}" var="child" border="1" styleClass="table">
                            <h:column>
                                <f:facet name="header">  <h:outputText value="Имя"/>  </f:facet>    
                                <h:outputText value="#{child.name}"/>  
                            </h:column>
                            <h:column>
                                <f:facet name="header">  <h:outputText value="Сон"/>  </f:facet>    
                                <h:outputText value="#{child.sleepInfo}"/>  
                            </h:column>
                            
                        </h:dataTable>
                    </div>
                    </h:panelGrid>
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
