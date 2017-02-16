<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<portlet:defineObjects />

<portlet:renderURL var="addDocumentViewURL">
	<portlet:param name="mvcPath" value="/html/documentautomation/add_document.jsp"></portlet:param>
</portlet:renderURL>

<a class="btn" href="${addDocumentViewURL}">Add New Document</a>

<liferay-ui:tabs names="${documents.getTabNames()}" refresh="false">
	<c:forEach var="tab" items="${documents.getTaskNames()}">
		<liferay-ui:section>
			<table>
				<c:forEach var="document" items="${documents.getDocumentsByTaskName(tab)}">					
					<tr>
						<td>${document.getTitle()}</td>
						<c:forEach var="transitionName" items="${documents.getNextTransitionNamesByDocument(document)}">
							<td>
								<portlet:actionURL name="completeTask" var="completeTaskURL">
									<portlet:param name="workflowTaskId" value="${documents.getTaskByDocument(document).getWorkflowTaskId()}"/>
									<portlet:param name="transitionName" value="${transitionName}"/>
								</portlet:actionURL>
								<a class="btn" href="${completeTaskURL}">
									${transitionName}
								</a>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</liferay-ui:section>
	</c:forEach>
</liferay-ui:tabs>
