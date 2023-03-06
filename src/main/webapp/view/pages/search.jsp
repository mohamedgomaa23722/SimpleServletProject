
<%@ taglib uri="myTLD" prefix="users"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>

        <jsp:useBean id="userBean" type="gov.iti.model.User"
            scope="session" />
            <!DOCTYPE html>
            <html>

                <head>
                    <title>My Page</title>
                    <meta name="viewport" content="width=device-width,
                        initial-scale=1">
                    <link rel="stylesheet"
                        href="${pageContext.request.contextPath}/view/css/homeStyle.css">
                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                        <script src="view/js/Home.js"></script>

                </head>
                <body onload="setInterval(function() {loadJSONFromServlet(); },5000);">
                    <nav class="bar"> <a>Home</a> <a>About</a> <a>Contact us</a>
                    </nav>
                    <div class="center">
                        <h1>Welcome</h1>
                        <h1>${userBean.userName}</h1>
                        <h1>${online} online User</h1>
                        <form action="/MG1/download" method="get">
                            <input class="filledB" type="submit" value="download" id="download"/>
                        </form>

                        <form action="/MG1/logOut" method="get">
                            <input class="filledB" type="submit" value="signOut" id="signout"/>
                        </form>
                        <c:if test="${userBean.userName eq 'gomaa'}">
                            <h1>Admin</h1>
                        </c:if>

                        <c:if test="${userBean.userName eq 'gg'}">
                            <h1> msh Admin</h1>
                        </c:if>

                        <p>Search in user table by name<br> fast access to
                            users
                        </p>
                        <form action="" name="ajax">
                            <input id="searchValue" name="searchValue"
                                class="filledF"
                                type="text" placeholder="Search for user">
                            <input class="filledB" type="button"
                                value="search" onclick="loadJSONFromServlet();">
                        </form>

                    </div>
                    <div id = "result"></div>
                    </body>
                </html>