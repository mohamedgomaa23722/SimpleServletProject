<%@ page session="false"%>
<!DOCTYPE html>
<html>

    <head>
        <title>My Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/styleFile.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <div id="container">
            <div id="subContainer">
                <h1>Sign in</h1>
                <form ACTION="/MG1/loginReq" METHOD = get>
                    <div class="input-container">
                        <i class="fa fa-user icon"></i>
                        <input class="input-field" id="UserName" type="text" name="UserName"
                            placeholder="Eneter Username">
                    </div>

                    <div class="input-container">
                        <i class="fa fa-key icon"></i>
                        <input class="input-field" id="password" type="password" name="password"
                            placeholder="Eneter password">
                    </div>
                    <label id = "errorMessage" class="errorLabel"></label>
                    <div id="fasilitis">
                        <input id="remember" type="checkbox" name="remember">
                        <label id="rememberLable" for="remember">Remember me</label><br>
                    </div>
                        <input onclick="applyCookie()" type="submit" value="Sign in" id="submit">

                        <a href="signUp">
                            don't have account yet?
                        </a>
                </div>

            </form>

            <script src="../login.js"></script>

        </body>

    </html>