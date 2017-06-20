<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Devices</title>

    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/css/navbar.css" rel="stylesheet">
    <script src="lib/js/iot.js"></script>
    <script src="lib/js/jquery-3.2.1.min.js"></script>

     <script src="lib/bootstrap/dist/js/bootstrap.min.js"></script>

</head>

<body>

<div class="container">

    <!-- Display the navbar -->
    <div id="nBar"></div>
    <script>displayNavBar('devices')</script>

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
    	<div class="row">
    	    <div class="col-xs-12 col-sm-4"></div>
    	   	<div class="col-xs-12 col-sm-4"></div>
    		<div class="col-xs-12 col-sm-4">
    			 <button type="button" id="addDeviceButton" class="pull-right btn btn-md btn-primary right" data-toggle="modal" data-target="#myModalHorizontal">Add Device</button>
    		
    		<div class="modal fade" id="myModalHorizontal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    			<div class="modal-dialog">
        			<div class="modal-content">
				        <!-- Modal Header -->
				        <div class="modal-header">
				             <h4 class="modal-title" id="myModalLabel">Add device</h4>
				        </div>
	            
			            <!-- Modal Body -->
			            <div class="modal-body">
			                
			                <form class="form-horizontal" role="form">
			                  <div class="form-group">
			                    <label  class="control-label col-sm-2" for="inputDeviceName">Device name</label>
			                    <div class="col-sm-10">
			                        <input type="text" class="form-control" id="inputDeviceName" placeholder="Name" required/>
			                    </div>
			                  </div>
			             	  <div class="form-group">
			                    <label  class="control-label col-sm-2" for="inputDeviceSN">Device SN</label>
			                    <div class="col-sm-10">
			                        <input type="text" class="form-control" id="inputDeviceSN" placeholder="Device Serial Number( unique)" required/>
			                    </div>
			                  </div>
			                  <div class="form-group">
			                    <label class="col-sm-2 control-label" for="inputFrequency" >Frequency</label>
			                    <div class="col-sm-10">
			                        <input type="number" class="form-control" id="inputFrequency" placeholder="Frequency" required/>
			                    </div>
			                  </div>
			                  <div class="form-group">
			                    <label class="col-sm-2 control-label" for="inputToken" >Token</label>
			                    <div class="col-sm-10">
			                        <input type="text" class="form-control" id="inputToken" placeholder="Token" required/>
			                    </div>
			                  </div>
			                </form>
			            </div>
			             <input type="hidden" id="inputId"/>
			            <!-- Modal Footer -->
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			                <button type="button" class="btn btn-primary" onclick="addNewDevice(this,'insert')">Save changes</button>
			            </div>
       			 	</div>
    			</div>
			</div>
    		
    	<!-- End Modal -->	
    		</div>
    	</div>
    	
    	<div id="deviceList">
				<div class="row">
    				<div class="col-xs-6 col-sm-2">
        				<div class="devIcon"></div>
                    </div>
				    <div class="col-xs-6 col-sm-4">
				        <div style="color: black;">
				            <h3>Device Name</h3>
				        </div>
				    </div>
				    <div class="col-xs-6 col-sm-6">
				        <!--<a href="edit({{dev.id}}" class="">-->
				            <img src="lib/images/edit.png" width="25" height="25" style="margin-top: 20px">
				        <!--</a>-->
				        <!--<a href="#" class="">-->
				            <img src="lib/images/remove.png" width="25" height="25" style="margin-top: 20px">
				        <!--</a>-->
				    </div>
				</div>

				<div class="row">
				    <div class="col-xs-6 col-sm-2"></div>
				    <div class="col-xs-6 col-sm-6">
				        <div class="row">
				            <div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">
				                <div class="butStyle"> Data Frequency</div>
				            </div>
				            <div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">
				                <div class="inpStyle"> {{dev.frequency}}</div>
				            </div>
				        </div>
				    </div>
				    <div class="col-xs-6 col-sm-4"></div>
				</div>

				<div class="row">
				    <div class="col-xs-6 col-sm-2"></div>
				    <div class="col-xs-6 col-sm-6">
				        <div class="row">
				            <div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">
				                <div class="butStyle">Sensors</div>
				            </div>
				            <div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 5px;">
				                <!--<a href="#" class="" >-->
				                    <img src="lib/images/add.png"  width="20" height="20">
				                <!--</a>-->
				            </div>
				        </div>
				    </div>
				    <div class="col-xs-6 col-sm-4"></div>
				</div>
				<div class="row">
				    <div class="col-xs-6 col-sm-2"></div>
				    <div class="col-xs-6 col-sm-6"></div>
				    <div class="col-xs-6 col-sm-4"></div>
				</div>
				
				<div id="sensorList">
					<div class="sensBackground">
					    <div class="row">
					        <div class="col-xs-6 col-sm-2"></div>
					        <div class="col-xs-6 col-sm-6">
					            <div class="row">
					                <div class="col-xs-6 col-sm-2" style="padding: 5px 0 5px 0;"></div>
					                <div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">
					                    <div class="butStyle" style="background-color: #00a379">Type</div>
					                </div>
					                <div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">
					                    <div class="inpStyle" style="background-color: #00a379"> {{sens.name}}</div>
					                </div>
					                <div class="col-xs-6 col-sm-2" style="padding: 5px 0 5px 5px;">
					                    <!--<a href="#" class="">-->
					                        <img src="lib/images/edit.png" width="17" height="17">
					                    <!--</a>-->
					                    <!--<a href="#" class="">-->
					                        <img src="lib/images/remove.png" width="17" height="17">
					                    <!--</a>-->
					                </div>
					            </div>
					        </div>
					        <div class="col-xs-6 col-sm-4"></div>
					    </div>
					
					    <div class="row">
					        <div class="col-xs-6 col-sm-2"></div>
					        <div class="col-xs-6 col-sm-6">
					            <div class="row">
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="butStyle">Min. Value</div>
					                </div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="inpStyle"> {{sens.minVal}}</div>
					                </div>
					            </div>
					        </div>
					        <div class="col-xs-6 col-sm-4"></div>
					    </div>
					
					    <div class="row">
					        <div class="col-xs-6 col-sm-2"></div>
					        <div class="col-xs-6 col-sm-6">
					            <div class="row">
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="butStyle">Max. Value</div>
					                </div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="inpStyle"> {{sens.maxVal}}</div>
					                </div>
					            </div>
					        </div>
					        <div class="col-xs-6 col-sm-4"></div>
					    </div>
					
					    <div class="row">
					        <div class="col-xs-6 col-sm-2"></div>
					        <div class="col-xs-6 col-sm-6">
					            <div class="row">
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="butStyle">Event Enable</div>
					                </div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="inpStyle"> {{sens.eventEnabled}}</div>
					                </div>
					            </div>
					        </div>
					        <div class="col-xs-6 col-sm-4"></div>
					    </div>
					
					    <div class="row">
					        <div class="col-xs-6 col-sm-2"></div>
					        <div class="col-xs-6 col-sm-6">
					            <div class="row">
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="butStyle">Last Value Read</div>
					                </div>
					                <div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">
					                    <div class="inpStyle"> {{sens.lastValueRead}}</div>
					                </div>
					            </div>
					        </div>
					        <div class="col-xs-6 col-sm-4"></div>
					    </div>		
					</div>
				</div>
				
				<div class="row">
				    <div class="col-xs-6 col-sm-2"></div>
				    <div class="col-xs-6 col-sm-6"></div>
				    <div class="col-xs-6 col-sm-4"></div>
				</div>
    	</div>    
    </div>

</div> <!-- /container -->







</body>

<script src="lib/js/requests.js"></script>
</html>