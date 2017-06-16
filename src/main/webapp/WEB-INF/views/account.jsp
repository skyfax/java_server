<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Account</title>

    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/css/signin.css" rel="stylesheet">
    <script src="lib/js/iot.js"></script>
    <script src="lib/js/jquery-3.2.1.min.js"></script>
    <script src="lib/js/requests.js"></script>

</head>

<script type="text/javascript">
	$(document).ready(function() {
		$("#submitUpdate").click(function(e) {
			e.preventDefault();
			
			var user = {
				"id" : sessionStorage.getItem("userId"),
				"password" : $("#inputPassword").val(),
				"email" : $("#inputEmail").val(),
				"phone" : $("#inputPhone").val()
			};

			$.ajax({
				type : "POST",
				url : "/iot/user/editUser",
				async : false,
				data : JSON.stringify(user),
				contentType : "application/json",
				complete : function(data) {
					if (data.statusText == "success") {
						window.location.href= "/iot/account";
					} else {
						alert("Could not register");
					}
				}
			});
		});
		
		getUser();
	});
	
			function getUser(){
		    $.get("/iot/user/getUser",
		            {
		    		  userId: sessionStorage.getItem("userId"),

		            },
		            function(data){
						if(data.status == "ok"){
							var user = data.user; 
							$("#inputEmail").val(user.email),
							$("#inputPhone").val(user.phone),				
							$("#inputUsername").val(user.username);
						}else {
							alert("Failed to load user data.");
						}
		   });
		} 
</script>

<body>

<div class="container">

    <!-- Display the navbar -->
    <div id="nBar"></div>
    <script>displayNavBar('account')</script>

    <!-- Main component for a primary marketing message or call to action -->

		<form class="form-signin">
			<h2 class="form-signin-heading">Account</h2>
			<label for="inputUsername" class="sr-only">Username</label>
			 <input disabled type="text" id="inputUsername" class="form-control"	placeholder="Username"> 
			 <label	for="inputEmail" class="sr-only">Email address</label> 
			 <input	type="email" id="inputEmail" class="form-control" placeholder="Email address"> 
			 <label	for="inputPhone" class="sr-only">Phone</label> 
			 <input type="text"	id="inputPhone" class="form-control" placeholder="Phone">
			 <label for="inputPassword" class="sr-only">Password</label> 
			 <input type="password" id="inputPassword" class="form-control"	placeholder="Password">

			<button id="submitUpdate"
				class="btn btn-lg btn-primary btn-block">Save</button>
		</form>


</div> <!-- /container -->


<script src="lib/bootstrap/dist/js/bootstrap.min.js"></script>

</body>
</html>