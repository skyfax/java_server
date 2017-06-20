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




function addNewDevice(button, action) {
    var xmlhttp = new XMLHttpRequest();
    var parentModal = button.parentElement.parentElement,
    	id = $(parentModal).find("#inputId"),
    	frequency = $(parentModal).find("#inputFrequency"),
    	name = $(parentModal).find("#inputDeviceName"),
    	deviceSn = $(parentModal).find("#inputDeviceSN"),
    	token = $(parentModal).find("#inputToken"),
    	url = "/iot/device/addDevice";
    
    
    var device = {
    		"id" : id.val(),
    		"dataFrequency" : frequency.val(),
    		"name": name.val(),
    		"deviceSN": deviceSn.val(),
    		"token": token.val()
    			
    }
    
    if(action === "update"){
    	url =  "/iot/device/editDevice";
    }
    
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		data : JSON.stringify(device),
		contentType : "application/json",
		complete : function(data) {
			if (data.statusText == "success") {
				alert("data saved");
			} else {
				alert("Could not register");
			}
		}
	});
    
}


$(function() {
    
	$(".logOut").click(function(){
		sessionStorage.removeItem("userId");
		sessionStorage.removeItem("username");
		
		window.location.href= "/iot/index";
	});
});
