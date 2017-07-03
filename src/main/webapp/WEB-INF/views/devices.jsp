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
                <button type="button" id="addDeviceButton" class="pull-right btn btn-md btn-primary right"
                        data-toggle="modal" data-target="#myModalHorizontal">Add Device
                </button>

                <div class="modal fade" id="myModalHorizontal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
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
                                        <label class="control-label col-sm-2" for="inputDeviceName">Device name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputDeviceName"
                                                   placeholder="Name" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="inputDeviceSN">Device SN</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputDeviceSN"
                                                   placeholder="Device Serial Number( unique)" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="inputFrequency">Frequency</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" id="inputFrequency"
                                                   placeholder="Frequency" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="inputToken">Token</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputToken" placeholder="Token"
                                                   required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="inputAccessLevel">Access Level</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" id="inputAccessLevel" placeholder="Access Level"
                                                   required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="inputLocation">Location</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputLocation" placeholder="Location"
                                                   required/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <input type="hidden" id="inputId"/>
                            <!-- Modal Footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" onclick="addNewDevice(this,'insert', -1)">Save
                                    changes
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- End Modal -->
            </div>
        </div>
        <div id="deviceList">

        </div>
    </div>

</div> <!-- /container -->


</body>

<script src="lib/js/requests.js"></script>
<script src="lib/js/deviceCreator.js"></script>

<script type="text/javascript">
    $(document).ready(function() {

        getDevices();
    });

    function getDevices(){
        $.get("/iot/device/getDevices",
            function(data){
                if(data.status == "ok"){
                    document.getElementById("deviceList").innerHTML = buildDeviceHtmlCode(data.devices);
                }else {
                    alert("Failed to load devices.");
                }
            });
    }

</script>
</html>