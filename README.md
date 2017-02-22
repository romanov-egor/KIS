# Document Automation Portlet
Портлет, реализующий минимальную функциональность СЭД

DONE:
<ul>
  <li>Database schema</li>
  <li>ORM</li>
  <li>Workflow (Kaleo Engine)</li>
</ul>

TODO:
<ul>
  <li>OLAP/BI</li>
  <li>WSDL</li>
  <li>User interface - frontend</li>
</ul>

Инструкция по устанвке: развернуть tomcat, liferay 6.2, eclipse (с предустановленным sdk). Импортировать проект.
Запустить томкат. Зайти под админом на портал. Перейти в Панель управления (Control Panel), выбрать пункт Workflow.
Перейти на вкладку Definitions и нажать Upload defenition. На форме заполнить Title значением Document Automation Process 
и выбрать файл document-automation.xml из корня проекта. Перейти на вкладку Default Configuration и в выпадающем списке напритив 
пункта model.resource.ru.ifmo.model.Document выбрать Document Automation Process.

Необходимо доделать загрузку документов при нажатии кнопки Submit на странице add_document.jsp
Необходимо изменить главную страницу, оставив там только поля логин/пароль. После входя в систему для любого пользователя должна открываться 
страница без возможности ее изменения с одним портлетом.
Необходимо проработать ролевые ограничения (сейчас все видят все вкладки в портлете) и реализовать их.

Добавить или изменить все, что кажется неверным или некрасивым =)
