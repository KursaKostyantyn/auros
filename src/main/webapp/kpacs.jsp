<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Knowledge Packages</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/grid_gpl/codebase/grid.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/grid_gpl/codebase/grid.css">
</head>
<body>
<a href="/">Home</a> <br>

Create Knowledge Package:
<form name="knowledgePackage" action="/addKnowledgePackage" method="post">
    <p>Title</p>
    <input title="title" type="text" maxlength="250" name="title" placeholder="title">
    <p>Description</p>
    <input title="description" type="text" maxlength="2000" name="description" placeholder="description">
    <input type="submit" value="Save knowledge Package">
</form>

<div id="grid_container"></div>

<script>
    const grid = new dhx.Grid("grid_container", {
        columns: [
            {width: 100, id: "id", header: [{text: "Id"}, {content: "inputFilter"}]},
            {width: 100, id: "title", header: [{text: "Title"}, {content: "inputFilter"}]},
            {width: 100, id: "description", header: [{text: "Description"}, {content: "inputFilter"}]},
            {
                width: 150, id: "creationDate", header: [{text: "Creation Date"}, {content: "inputFilter"}],
                type: "date", format: "%d-%m-%Y"
            },
            {
                width: 100, id: "deleteIcon", header: [{text: "Delete"}],
                htmlEnable: true,
                template: function (cellValue, row, col) {
                    return "<div class='delete_icon'> <img height='20px' width='20px' src='resources/images/delete.png' alt='delete icon'></div>"
                }
            }
        ],
        eventHandlers: {
            onclick: {
                delete_icon: function (event, data) {
                    window.location.href = "/deleteKnowledgePackage/" + data.row.id
                }
            }
        },
        resizable: true,
        headerRowHeight: 50,
        data: ${knowledgePackages}
    })


</script>
</body>
</html>
