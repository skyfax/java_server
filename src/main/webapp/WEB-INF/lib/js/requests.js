var host = "localhost:8080/"

$(document).ready(function(){

   $("#submitRegistration").click(function(){
   		$.post(host + "/user/registerUser",
    		{
       	 		username: "Donald Duck",
        		password: "Duckburg",
        		email: "asd@asd.com",
        		phone: 2543543534
    		},
    		function(data){
    	    	alert("Data: " + data + "\nStatus: " + status);
    		});
	});

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



