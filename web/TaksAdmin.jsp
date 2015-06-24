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

        <title>Управление задачами</title>
    </head>
    <body>
        <div class="container" align="center">
            <h4>Управление задачами</h4>
        </div>
        <div class="container" align="center">
        <f:view>	
            <h:form enctype="multipart/form-data">
                <div align="right">
                    <h:commandButton value="Выйти" action="#{UserAuthController.unAuthorize}" styleClass="btn btn-primary"/>
                    <h:commandButton value="Назад" action="#{TaskAdminController.GoBack}" styleClass="btn btn-primary"/>
                </div>
               
                <div>
                   <h:dataTable value="#{TaskAdminController.taskList}" var="task" border="1" styleClass="table">
                       <h:column>
                           <f:facet name="header">  <h:outputText value="Имя ребенка"/>  </f:facet>    
                           <h:outputText value="#{task.tooth.child.name}"/>  
                       </h:column>
                       <h:column>
                           <f:facet name="header">  <h:outputText value="Адрес"/>  </f:facet>    
                           <h:outputText value="#{task.tooth.child.parent.address}"/>  
                       </h:column>
                       <h:column>    				
                          <f:facet name="header">  <h:outputText value="Сложность"/>  </f:facet>    				
                          <h:outputText value="#{task.difficulty}"/>  
                       </h:column>
                       <h:column>
                          <f:facet name="header">  <h:outputText value="Крайний срок"/>  </f:facet>    
                           <h:outputText value="#{task.deadline}"/>  
                       </h:column>
                       <h:column>
                          <f:facet name="header">  <h:outputText value="Оценка"/>  </f:facet>    
                           <h:outputText value="#{task.tooth.cost}"/>  
                       </h:column>
                       <h:column>
                          <f:facet name="header">  <h:outputText value="Исполнитель"/>  </f:facet>    
                           <h:outputText value="#{task.fairyName}"/>  
                       </h:column>
                         <h:column>
                            <h:commandButton action="#{task.deleteFromDb}" styleClass="btn btn-danger"
                                    value="Удалить">
                                   <f:param name="task" value="#{task.id}" />

                           </h:commandButton>
                           </h:column>
                    </h:dataTable>
                </div>
             </div>        
            <h:messages id="errors" errorClass="errorMessage" globalOnly="true"/>
            </h:form>
        </f:view>   
        </div>
    </body>
</html>
