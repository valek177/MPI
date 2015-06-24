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
        <title>Назначение задач феям</title>
    </head>
    <body>
        <div>
            <h4 align="center">Назначение задач феям</h4>
        </div>
        <div>                                                  
        <f:view>	
            <h:form>
                <div align="right">
                    <h:commandButton value="Выйти" action="#{UserAuthController.unAuthorize}" styleClass="btn btn-primary"/>
                    <h:commandButton value="Редактировать профиль" action="#{UserAuthController.editProfile}" styleClass="btn btn-primary"/>
                </div>
                 <div align="right">
                    <h:commandButton value="Управление задачами" action="#{TaskToFairyController.adminTasks}" styleClass="btn btn-primary"/>
                </div>
                <div align="center">
                    <div>Выбор исполнителя</div>           
                    <table border="1">
                        <tr>
                            <td valign="top">
                                <div style="width: 100px">
                                <h:dataTable value="#{TaskToFairyController.fairyList}" var="fairy" >
                                <h:column>
                                <div align="center">
                                <h:commandButton value="#{fairy.name}" action="#{TaskToFairyController.retrieveFairy()}" styleClass="btn btn-default" style="width: 100px">
                                <f:param name="fairyId" value="#{fairy.id}" />
                                </h:commandButton>
                                </div>
                                </h:column>
                                </h:dataTable>
                                </div>
                            </td>
                            <td>
                                <div id="info" style="width: 500px">
                                    <img src="data:image/jpg;base64, ${TaskToFairyController.selectedFairy.photoContent}" width="100" height="100"/>  
                                    
                                    <br>
                                    Имя:
                                    <h:outputText value="#{TaskToFairyController.selectedFairy.name}"/>  
                                    <br>
                                    Опыт:
                                    <h:outputText value="#{TaskToFairyController.selectedFairy.skill}"/>  
                                    <br>
                                    Характер:
                                    <h:outputText value="#{TaskToFairyController.selectedFairy.сharacter}"/>  
                                    <br>
                                    Полученные деньги:
                                    <h:outputText value="#{TaskToFairyController.selectedFairy.totalMoney}"/>  
                                    <br>
                                    <div>Текущие задачи</div>
                                    <div>
                                        <h:dataTable value="#{TaskToFairyController.selectedFairy.tasks}" rendered="#{not empty TaskToFairyController.selectedFairy.tasks}" var="task" border="1" styleClass="table" width="300">
                                            <h:column>
                                                <f:facet name="header">  <h:outputText value="Имя"/>  </f:facet>    
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
                                                 <h:commandButton action="#{TaskToFairyController.unassignTask}" styleClass="btn btn-danger"
                                                         value="Отменить">
                                                        <f:param name="task" value="#{task.id}" />

                                                </h:commandButton>
                                            </h:column>
                                        </h:dataTable>
                                        <h:outputText value="Нет текущих задач" rendered="#{empty TaskToFairyController.selectedFairy.tasks}" />
                                    </div>
                                </div>       
                            </td>
                        </tr>
                    </table>
                </div>   
                 <div align="center">
                    <div>Нераспределенные задачи</div>
                    <div style="width: 800px">
                    <h:dataTable value="#{TaskToFairyController.tasksList}" rendered="#{not empty TaskToFairyController.tasksList}" var="task" border="1" styleClass="table">
                       <h:column>
                           <f:facet name="header">  <h:outputText value="Имя"/>  </f:facet>    
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
                            <h:commandButton action="#{TaskToFairyController.assignTask}" styleClass="btn btn-success"
                                    value="Назначить">
                                   <f:param name="task" value="#{task.id}" />

                           </h:commandButton>
                           </h:column>
                    </h:dataTable>
                    <h:outputText value="Нет задач" rendered="#{empty TaskToFairyController.tasksList}" />
                    </div>
                 </div>
            </h:form>
        </f:view>                              
        </div>
        
    </body>
</html>
