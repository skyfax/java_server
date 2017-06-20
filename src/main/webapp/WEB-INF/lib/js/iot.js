
function displayNavBar(page){

	var html,
		activeTabsLeft = '',
		activeTabsRight = '',
		userId = sessionStorage.getItem("userId");

	if( userId != null){
		activeTabsLeft = '<li ' + isPageActive(page,'devices') + '><a href="devices">Devices</a></li>';
		activeTabsRight = 	'<li ' + isPageActive(page,'account') + '><a href="account">Account</a></li>' +
              				'<li class="logOut"><a href="">Log Out</a></li>';
		
	}else {
		activeTabsRight = 	'<li ' + isPageActive(page,'register') + '><a href="register">Register</a></li>' +
        					'<li ' + isPageActive(page,'signIn') + '><a href="login">Login</a></li>';
	}

	 html =   
      '<nav class="navbar navbar-default">' +
        '<div class="container-fluid">' +
          '<div class="navbar-header">' +
            '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">' +
              '<span class="sr-only">Toggle navigation</span>' +
              '<span class="icon-bar"></span>' +
              '<span class="icon-bar"></span>' +
              '<span class="icon-bar"></span>' +
            '</button>' +
            '<a class="navbar-brand">Internet of Things</a>' +
          '</div>' +
          '<div id="navbar" class="navbar-collapse collapse">' +
            '<ul class="nav navbar-nav">' +
              '<li ' + isPageActive(page,'home') + '><a href="index">Home</a></li>' +
              activeTabsLeft +
            '</ul>' +
            '<ul class="nav navbar-nav navbar-right">' +
 				activeTabsRight +
            '</ul>' +
          '</div><!--/.nav-collapse -->' +
        '</div><!--/.container-fluid -->' +
      '</nav>';

      document.getElementById("nBar").innerHTML = html;
      
//      if(userId != null && ())
}


function isPageActive(sentPage, page){
	if(sentPage == page){
		return 'class="active"';
	}
}