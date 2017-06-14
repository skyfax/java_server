<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SignIn</title>

    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/css/signin.css" rel="stylesheet">
    <script src="lib/js/iot.js"></script>
    <script src="lib/js/jquery-3.2.1.min.js"></script>
    <!-- <script src="js/requests.js"></script> -->

    <script type="text/javascript">
      $(document).ready(function(){
        $("#signInButton").click(function(){
          alert("Entered sign");
          $.post("/token",
            {
              username: "Donald Duck",
              password: "Duckburg"
            },
            function(data){
                alert("Data: " + data + "\nStatus: ");
               });
                    alert("End sign");
        });
      });
    </script>


  </head>

  <body>

    <div class="container">
    
    <div id="nBar"></div>
    <script >displayNavBar('signIn')</script>

      <form class="form-signin">
        <h2 class="form-signin-heading">Please Sign In</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button id="signInButton" class="btn btn-lg btn-primary btn-block">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
