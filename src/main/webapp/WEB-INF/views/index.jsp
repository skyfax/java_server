<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Internet of Things</title>

    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="lib/css/navbar.css" rel="stylesheet">
    <script src="lib/js/iot.js"></script>
    <script src="lib/js/jquery-3.2.1.min.js"></script>

  </head>

  <body>

    <div class="container">

    <!-- Display the navbar -->
    <div id="nBar"></div>
    <script >displayNavBar('home')</script>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="row">
          <div class="col-md-2 col-md-offset-5">
            <h2 >Search</h2>
          </div>
        </div>

        <form class="form-signin">

          <label for="inputText" class="sr-only">Text</label>
          <input type="text" id="inputText" class="form-control" placeholder="Search data using  place, type or date e.g. Temperature in Cluj" required autofocus>
          <p></p>
          <div class="row">
            <div class="col-md-2 col-md-offset-5">
              <button id="submitText" class="btn btn-lg btn-primary">Search</button>
            </div>
          </div>

        </form>
      </div>

    </div> <!-- /container -->

  </body>
  
  <script src="lib/js/requests.js"></script>
</html>
