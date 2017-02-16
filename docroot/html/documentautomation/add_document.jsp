<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<portlet:defineObjects />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/documentautomation/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addDocument" var="addDocumentURL"></portlet:actionURL>

<aui:form action="${addDocumentURL}" name="<portlet:namespace />fm">
	<aui:fieldset>
		<aui:input name="title" label="Title"></aui:input>
		<aui:input name="description" label="Description"></aui:input>
		<aui:input name="filePath" type="file" label="File"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="${viewURL}"></aui:button>
	</aui:button-row>
</aui:form>