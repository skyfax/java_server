<%--
  Created by IntelliJ IDEA.
  User: Shyzzle
  Date: 12/07/2017
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Groups</title>

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
    <script>displayNavBar('groups')</script>

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="row">
            <div class="col-xs-12 col-sm-4"></div>
            <div class="col-xs-12 col-sm-4"></div>
            <div class="col-xs-12 col-sm-4">
                <button type="button" id="addGroupButton" class="pull-right btn btn-md btn-primary right"
                        data-toggle="modal" data-target="#myModalHorizontal">Add Group
                </button>

                <div class="modal fade" id="myModalHorizontal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title" id="myModalLabel">Add group</h4>
                            </div>

                            <!-- Modal Body -->
                            <div class="modal-body">

                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="inputGroupName">Group name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputGroupName"
                                                   placeholder="Name" required/>
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <input type="hidden" id="inputId"/>
                            <!-- Modal Footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" onclick="addNewGroup(this,'insert', -1)">Save
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

//        getDevices();
    });

//    function getDevices(){
//        $.get("/iot/device/getDevices",
//            function(data){
//                if(data.status == "ok"){
//                    document.getElementById("deviceList").innerHTML = buildDeviceHtmlCode(data.devices);
//                }else {
//                    alert("Failed to load devices.");
//                }
//            });
//    }

</script>
</html>
