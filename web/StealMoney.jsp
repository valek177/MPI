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
        <title>Похищение денег</title>
    </head>
    <body>
        <div align="center">
            <h4>Похищение денег</h4>
        </div>
        <div>                                                  
            <f:view>	
            <h:form enctype="multipart/form-data">
                 <div align="right">
                    Текущий пользователь: <h:outputLabel value="#{UserAuthController.currentUser.name}"/>
                </div>
                <div align="right">
<h:commandButton value="Выйти" action="#{UserAuthController.unAuthorize}" styleClass="btn btn-primary"/>
<h:commandButton value="Редактировать профиль" action="#{UserAuthController.editProfile}" styleClass="btn btn-primary"/>
</div>
                <h:panelGroup rendered="#{StealMoneyController.isListView}" id="pTasks"> 
                    <div>Текущие задачи</div>
                    <h:dataTable value="#{StealMoneyController.currentFairy.tasks}" rendered="#{not empty StealMoneyController.currentFairy.tasks}" var="task" styleClass="table" border="1">
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
                              <h:commandButton action="#{StealMoneyController.selectTask}" styleClass="btn btn-default"
                                     value="Выбрать">
                                    <f:param name="task" value="#{task.id}" />

                            </h:commandButton>
                            </h:column>
                            
                    </h:dataTable>
                </h:panelGroup>
                    <h:outputText value="Нет текущих задач" rendered="#{empty StealMoneyController.currentFairy.tasks}" />
                    <h:panelGroup rendered="#{!StealMoneyController.isListView}" id="pTask" >
                    <div align="center">
                        <h5>Задача</h5>
                        <br>
                         <br>
                         <h:outputText value="Имя: "/>
                         <h:outputText value="#{StealMoneyController.selectedTask.tooth.child.name}"/>  
                         <br>
                          <br>
                         <h:outputText value="Адрес: "/>
                         <h:outputText value="#{StealMoneyController.selectedTask.tooth.child.parent.address}"/>
                         <br>
                          <br>
                         <h:outputText value="Крайний срок: "/>
                         <h:outputText value="#{StealMoneyController.selectedTask.deadline}"/>
                           <br>
                            <br>
                         <h:outputText value="Деньги: "/>
                         <h:outputText value="#{StealMoneyController.selectedTask.tooth.cost}"/>  
                           <br>
                            <br>
                         <h:outputText value="Получится забрать: "/>
                         <h:outputText value="#{StealMoneyController.selectedTask.fairyMoney}"/>  
                           <br>
                            <br>
                         <h:outputText value="Вероятность успеха: "/>
                         <h:outputText value="#{StealMoneyController.selectedTask.probability}"/>  
                           <br>
                            <br>

                            <h:commandButton action="#{StealMoneyController.selectedTask.executeTask}"
                                         value="Украсть" styleClass="btn btn-warning">
                                </h:commandButton>
                           <br>
                            <br>
                           <h:outputText value="Других задач: "/>
                           <b><h:outputText value="#{StealMoneyController.taskCount}"/></b>
                         <br>
                          <br>
                         <h:commandButton action="#{StealMoneyController.returnToList}" styleClass="btn btn-default"
                                         value="Вернуться к задачам">
                        </h:commandButton>
                    </div>
                </h:panelGroup>
                       <h:panelGroup rendered="#{StealMoneyController.selectedTask.isCompleted}" id="pRes">
                           <h:outputText rendered="#{StealMoneyController.selectedTask.isSucceed}"value="Деньги успешно украдены"/>  
                           <h:outputText rendered="#{!StealMoneyController.selectedTask.isSucceed}" value="Не удалось украсть деньги"/>  
                        </h:panelGroup>                       
            </h:form>
        </f:view>   
                    
        </div>
        <img src="img/1.jpg" align="right" height="200" width="200" />
</html>
