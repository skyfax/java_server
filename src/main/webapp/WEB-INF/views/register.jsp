<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/lib/css/signin.css" rel="stylesheet">
    <script src="/lib/js/iot.js"></script>
    <script src="/lib/js/jquery-3.2.1.min.js"></script>
    <script src="/lib/js/requests.js"></script>

  </head>

  <body>

    <div class="container">

      <!-- Display the navbar -->
      <div id="nBar"></div>
      <script >displayNavBar('register')</script>
    
      <form class="form-signin">
        <h2 class="form-signin-heading">Register Form</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
        
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
        
        <label for="inputPhone" class="sr-only">Phone</label>
        <input type="text" id="inputPhone" class="form-control" placeholder="Phone" required>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        
        <button id="submitRegistration" class="btn btn-lg btn-primary btn-block">Register</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
