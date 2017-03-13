<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<portlet:defineObjects />

<portlet:renderURL var="addDocumentViewURL">
	<portlet:param name="mvcPath" value="/html/documentautomation/add_document.jsp"></portlet:param>
</portlet:renderURL>

<a class="btn" href="${addDocumentViewURL}">Add New Document</a>

<liferay-ui:tabs names="${documents.getTabNames()}" refresh="false">
	<c:forEach var="tab" items="${documents.getTaskNames()}">
		<liferay-ui:section>
			<table>				
				<c:forEach var="document" items="${documents.getWorkflowDocumentsByTaskName(tab)}">					
					<tr>
						<td>${document.getTitle()}</td>
						<c:forEach var="transitionName" items="${documents.getNextTransitionNamesByWorkflowDocument(document)}">
							<td>
								<portlet:actionURL name="completeTask" var="completeTaskURL">
									<portlet:param name="workflowTaskId" value="${documents.getTaskByWorkflowDocument(document).getWorkflowTaskId()}"/>
									<portlet:param name="transitionName" value="${transitionName}"/>
								</portlet:actionURL>
								<a class="btn" href="${completeTaskURL}">
									${transitionName}
								</a>
							</td>
						</c:forEach>
						<c:choose>
							<c:when test="${userId == document.getUserId()}">
								<portlet:renderURL var="editDocumentURL">
									<portlet:param name="mvcPath" value="/html/documentautomation/edit_document.jsp"></portlet:param>
									<portlet:param name="documentId" value="${document.getDocumentId()}"></portlet:param>
								</portlet:renderURL>
								<td>
									<a class="btn" href="${editDocumentURL}">Edit document</a>
								</td>
							</c:when>
							<c:otherwise>
								<portlet:renderURL var="viewDocumentURL">
									<portlet:param name="mvcPath" value="/html/documentautomation/view_document.jsp"></portlet:param>
									<portlet:param name="documentId" value="${document.getDocumentId()}"></portlet:param>
								</portlet:renderURL>
								<td>
									<a class="btn" href="${viewDocumentURL}">Document details</a>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</liferay-ui:section>
	</c:forEach>
</liferay-ui:tabs>
