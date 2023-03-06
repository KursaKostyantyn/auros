<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Knowledge Package Sets</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/grid_gpl/codebase/grid.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/grid_gpl/codebase/grid.css">
</head>
<body>
<a href="/">Home</a>
<form name="knowledgePackageSet" action="/add_knowledge_package_set" method="post">
    <p>Title
    <p>
        <input title="title" type="text" name="title" maxlength="250" placeholder="title"><br>
        <c:forEach items="${knowledgePackages}" var="knowledgePackage">
        <input type="checkbox" name="ids" value="${knowledgePackage.id}">${knowledgePackage.title}<br>
        </c:forEach>
        <input type="submit" value="Save Knowledge Package Set">
</form>

<div id="grid_container"></div>

<script>
    const grid = new dhx.Grid("grid_container", {
        columns: [
            {width: 100, id: "id", header: [{text: "Id"}, {content: "inputFilter"}]},
            {width: 100, id: "title", header: [{text: "Title"}, {content: "inputFilter"}]},
            {
                width: 100, id: "delete", header: [{text: "Delete"}],
                htmlEnable: true,
                template: function (cellValue, row, col) {
                    return "<div class='delete_icon'> <img height='20px' width='20px' src='resources/images/delete.png' alt='delete icon'></div>"
                }
            }
        ],
        eventHandlers: {
            onclick: {
                delete_icon: function (event, data) {
                    window.location.href = "/delete_knowledge_package_set/" + data.row.id
                }
            }
        },
        resizable: true,
        headerRowHeight: 50,
        data: ${knowledgePackageSets}
    })
    grid.events.on("cellDblClick", function (row, col, e) {
        window.location.href = "/set/" + row.id
    })


</script>


</body>
</html>
