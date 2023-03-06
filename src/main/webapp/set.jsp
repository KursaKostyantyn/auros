<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Knowledge Package Set</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/grid_gpl/codebase/grid.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/grid_gpl/codebase/grid.css">
</head>
<body>
<a href="/">Home</a>
<div id="grid_container"></div>

<script>
    const grid = new dhx.Grid("grid_container", {
        columns: [
            {width: 53, id: "id", header: [{text: "Id"}]},
            {width: 400, id: "title", header: [{text: "Title"}]},
            {width: 600, id: "description", header: [{text: "Description"}]},
        ],
        resizable: true,
        headerRowHeight: 50,
        data:${knowledgePackageSet}
    })
</script>
</body>
</html>
