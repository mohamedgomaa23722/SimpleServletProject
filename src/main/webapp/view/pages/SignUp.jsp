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
                <h1>SignUp</h1>
                <form ACTION="SignUp" enctype="multipart/form-data" METHOD="post">

                    <div class="input-container">
                        <i class="fa fa-user icon"></i>
                        <input class="input-field" id="userName" type="text"
                            placeholder="Eneter Username" name="userName">
                    </div>

                    <div class="input-container">
                        <i class="fa fa-key icon"></i>
                        <input class="input-field" id="password" type="password"
                            placeholder="Eneter password" name="password">
                    </div>

                    <div class="input-container">
                        <i class="fa fa-key icon"></i>
                        <input class="input-field" id="cpassword"
                            type="password" placeholder="Confirm password">
                    </div>

                    <div class="input-container">
                        <i class="fa fa-calendar icon"></i>
                        <input class="input-field" id="date" type="date"
                            name="date">
                    </div>

                    <div class="input-container">
                        <i class="fa fa-calendar icon"></i>
                        <input class="input-field" id="file" type="file"
                            name="file">
                    </div>

                    <input type="submit" id="submit" value="Sign up">
                </div>
            </form>
        </div>
    </body>

</html>