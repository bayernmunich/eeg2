<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>

<ui:listsTemplate pageTitle="pageTitle.itemDeleted">

    <h1><fmt:message key="pageTitle.itemDeleted"/></h1>

    <p>
        <fmt:message key="text.itemWasDeletedFromDatabase"/>
    </p>

</ui:listsTemplate>
