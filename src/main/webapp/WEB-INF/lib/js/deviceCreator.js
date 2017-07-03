/**
 * Created by Shyzzle on 02/07/2017.
 */

function buildDeviceHtmlCode(devices) {
    let length = devices.length,
        html = "";
    for (let i = 0; i < length; i++) {
        let device = devices[i];
        let deviceId = device.id;
        html +=
            '<div id="device' + deviceId + '">' +
                '<div class="row">' +
                    '<div class="col-xs-6 col-sm-2">' +
                        '<div class="devIcon"></div>' +
                    '</div>' +
                    '<div class="col-xs-6 col-sm-4">' +
                        '<div style="color: black;">' +
                            '<h3>' + device.name + '</h3>' +
                        '</div>' +
                    '</div>' +
                    '<div class="col-xs-6 col-sm-6">' +

                        '<button type="button" id="editDeviceButton' + deviceId + '" data-toggle="modal"' +
                                'data-target="#editDeviceModal' + deviceId + '">' +
                            '<img src="lib/images/edit.png" width="25" height="25" style="margin-top: 20px">' +
                        '</button>' +

                        '<div class="modal fade" id="editDeviceModal' + deviceId + '" tabindex="-1" role="dialog"' +
                             'aria-labelledby="editDeviceModalLabel' + deviceId + '" aria-hidden="true">' +
                            '<div class="modal-dialog">' +
                                '<div class="modal-content">' +
                                    '<!-- Modal Header -->' +
                                    '<div class="modal-header">' +
                                        '<h4 class="modal-title" id="editDeviceModalLabel' + deviceId + '">Edit Device</h4>' +
                                    '</div>' +

                                    '<!-- Modal Body -->' +
                                    '<div class="modal-body">' +

                                        '<form class="form-horizontal" role="form">' +
                                            '<div class="form-group">' +
                                                '<label class="control-label col-sm-2" for="editDeviceName' + deviceId + '">Device name</label>' +
                                                '<div class="col-sm-10">' +
                                                    '<input type="text" class="form-control" id="editDeviceName" placeholder="Name" value="' + device.name + '" required/>' +
                                                '</div>' +
                                            '</div>' +
                                            '<div class="form-group">' +
                                                '<label class="control-label col-sm-2" for="editDeviceSN' + deviceId + '">Device SN</label>' +
                                                '<div class="col-sm-10">' +
                                                    '<input type="text" class="form-control" id="editDeviceSN' + deviceId + '" placeholder="Device Serial Number( unique)" value="' + device.deviceSN + '" required/>' +
                                                '</div>' +
                                            '</div>' +
                                            '<div class="form-group">' +
                                                '<label class="col-sm-2 control-label" for="editFrequency' + deviceId + '">Frequency</label>' +
                                                '<div class="col-sm-10">' +
                                                    '<input type="number" class="form-control" id="editFrequency' + deviceId + '"' +
                                                           'placeholder="Frequency" value="' + device.dataFrequency + '" required/>' +
                                                '</div>' +
                                            '</div>' +
                                            '<div class="form-group">' +
                                                '<label class="col-sm-2 control-label" for="editToken' + deviceId + '">Token</label>' +
                                                '<div class="col-sm-10">' +
                                                    '<input type="text" class="form-control" id="editToken' + deviceId + '" placeholder="Token" value="' + device.token + '" required/>' +
                                                '</div>' +
                                            '</div>' +
                                            '<div class="form-group">' +
                                                '<label class="col-sm-2 control-label" for="editAccessLevel' + deviceId + '">Access Level</label>' +
                                                '<div class="col-sm-10">' +
                                                    '<input type="number" class="form-control" id="editAccessLevel' + deviceId + '" placeholder="Access Level" value="' + device.accessLevel + '" required/>' +
                                                '</div>' +
                                            '</div>' +
                                            '<div class="form-group">' +
                                                '<label class="col-sm-2 control-label" for="editLocation' + deviceId + '">Location</label>' +
                                                '<div class="col-sm-10">' +
                                                    '<input type="text" class="form-control" id="editLocation' + deviceId + '" placeholder="Location" value="' + device.location + '" required/>' +
                                                '</div>' +
                                            '</div>' +
                                        '</form>' +
                                    '</div>' +
                                    '<input type="hidden" id="editId" value="aaaa"/>' +
                                    '<!-- Modal Footer -->' +
                                    '<div class="modal-footer">' +
                                        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
                                        '<button type="button" class="btn btn-primary" onclick="addNewDevice(this,\'update\', ' + deviceId + ')">' +
                                            'Save changes' +
                                        '</button>' +
                                    '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>' +

                        '<!--<a href="#" class="">-->' +
                        '<button type="button" id="removeDeviceButton' + deviceId + '" onclick="removeDevice(' + deviceId + ')">' +
                            '<img src="lib/images/remove.png" width="25" height="25" style="margin-top: 20px">' +
                        '</button>' +
                        '<!--</a>-->' +
                    '</div>' +
                '</div>' +

                '<div class="row">' +
                    '<div class="col-xs-6 col-sm-2"></div>' +
                    '<div class="col-xs-6 col-sm-6">' +
                        '<div class="row">' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="butStyle"> Data Frequency</div>' +
                            '</div>' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="inpStyle">' + device.dataFrequency + '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                    '<div class="col-xs-6 col-sm-4"></div>' +
                '</div>' +

                '<div class="row">' +
                    '<div class="col-xs-6 col-sm-2"></div>' +
                    '<div class="col-xs-6 col-sm-6">' +
                        '<div class="row">' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="butStyle"> Access Level</div>' +
                            '</div>' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="inpStyle"> ' + device.accessLevel + '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                    '<div class="col-xs-6 col-sm-4"></div>' +
                '</div>' +

                '<div class="row">' +
                    '<div class="col-xs-6 col-sm-2"></div>' +
                    '<div class="col-xs-6 col-sm-6">' +
                        '<div class="row">' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="butStyle"> Location</div>' +
                            '</div>' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="inpStyle">' + device.location + '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                    '<div class="col-xs-6 col-sm-4"></div>' +
                '</div>' +

                '<div class="row">' +
                    '<div class="col-xs-6 col-sm-2"></div>' +
                    '<div class="col-xs-6 col-sm-6">' +
                        '<div class="row">' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                '<div class="butStyle">Sensors</div>' +
                            '</div>' +
                            '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 5px;">' +
                                '<!--<a href="#" class="" >-->' +
                                '<button type="button" id="addSensorButton' + deviceId + '" data-toggle="modal"' +
                                        'data-target="#addSensorModal' + deviceId + '">' +
                                    '<img src="lib/images/add.png" width="20" height="20">' +
                                '</button>' +

                                '<div class="modal fade" id="addSensorModal' + deviceId + '" tabindex="-1" role="dialog"' +
                                     'aria-labelledby="addSensorModalLabel' + deviceId + '" aria-hidden="true">' +
                                    '<div class="modal-dialog">' +
                                        '<div class="modal-content">' +
                                            '<!-- Modal Header -->' +
                                            '<div class="modal-header">' +
                                                '<h4 class="modal-title" id="addSensorModalLabel' + deviceId + '">Add Sensor</h4>' +
                                            '</div>' +

                                            '<!-- Modal Body -->' +
                                            '<div class="modal-body">' +

                                                '<form class="form-horizontal" role="form">' +
                                                    '<div class="form-group">' +
                                                        '<label class="control-label col-sm-2" for="addSensorName' + deviceId + '">Sensor name</label>' +
                                                        '<div class="col-sm-10">' +
                                                            '<input type="text" class="form-control" id="addSensorName' + deviceId + '"' +
                                                                   'placeholder="Name" required/>' +
                                                        '</div>' +
                                                    '</div>' +
                                                    '<div class="form-group">' +
                                                        '<label class="control-label col-sm-2" for="addSensorType' + deviceId + '">Sensor Type</label>' +
                                                        '<div class="col-sm-10">' +
                                                            '<input type="text" class="form-control" id="addSensorType' + deviceId + '"' +
                                                            'placeholder="Name" required/>' +
                                                        '</div>' +
                                                    '</div>' +
                                                    '<div class="form-group">' +
                                                        '<label class="control-label col-sm-2" for="addSensorMinValue' + deviceId + '">Min.' +
                                                            'Value</label>' +
                                                        '<div class="col-sm-10">' +
                                                            '<input type="number" class="form-control" id="addSensorMinValue' + deviceId + '"' +
                                                                   'placeholder="Min. Value" required/>' +
                                                        '</div>' +
                                                    '</div>' +
                                                    '<div class="form-group">' +
                                                        '<label class="col-sm-2 control-label" for="addSensorMaxValue' + deviceId + '">Max.' +
                                                            'Value</label>' +
                                                        '<div class="col-sm-10">' +
                                                            '<input type="number" class="form-control" id="addSensorMaxValue' + deviceId + '"' +
                                                                   'placeholder="Max. Value" required/>' +
                                                        '</div>' +
                                                    '</div>' +
                                                    '<div class="form-group">' +
                                                        '<label class="col-sm-2 control-label" for="addSensorEventEnabled' + deviceId + '">Event' +
                                                            'Enabled</label>' +
                                                        '<div class="col-sm-10">' +
                                                            '<input type="text" class="form-control"' +
                                                                   'id="addSensorEventEnabled' + deviceId + '" placeholder="Event Enabled"' +
                                                                   'required/>' +
                                                        '</div>' +
                                                    '</div>' +
                                                '</form>' +
                                            '</div>' +
                                            '<input type="hidden" id="deviceId' + deviceId + '" value="' + deviceId + '"/>' +
                                            '<input type="hidden" id="sensId' + deviceId + '" value="-1"/>' +
                                            '<!-- Modal Footer -->' +
                                            '<div class="modal-footer">' +
                                                '<button type="button" class="btn btn-default" data-dismiss="modal">Close' +
                                                '</button>' +
                                                '<button type="button" class="btn btn-primary"' +
                                                        'onclick="addNewSensor(this,\'insert\',' + deviceId +')">Save changes' +
                                                '</button>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>' +

                                '<!--</a>-->' +
                        '</div>' +
                    '</div>' +
                '</div>' +
                '<div class="col-xs-6 col-sm-4"></div>' +
            '</div>' +
        '<div class="row">' +
            '<div class="col-xs-6 col-sm-2"></div>' +
            '<div class="col-xs-6 col-sm-6"></div>' +
            '<div class="col-xs-6 col-sm-4"></div>' +
        '</div>' +

            (device.sensors !== null ? buildSensorsHtmlCode(device.sensors) : "") +

    '</div>+ +';
    }

    return html;
}

function viewSensorData(sensorId){

    $.post("/iot/sensor/getSensorData",
        {
            sensorId:sensorId
        },
        function (data) {
            if (data.values != null) {
                alert("Data success"+ data.values);
            } else {
                alert("Could not get sensor data");
            }

        });

}

function removeDevice(deviceId){
    $.post("/iot/device/removeDevice",
        {
            deviceId: deviceId
        },
        function (data) {
            if (data.statusText === true) {
                location.reload();
            } else {
                alert("Could not remove device.");
            }

        });
}

function removeSensor(sensorId) {
    $.post("/iot/sensor/removeSensor",
        {
            sensorId: sensorId
        },
        function (data) {
            if (data.statusText === true) {
                location.reload();
            } else {
                alert("Could not remove sensor");
            }

        });
}

function buildSensorsHtmlCode(sensors) {
  let length = sensors.length,i,entireHtml = "";

  for( i =0;i <length; i++){
  let sensor = sensors[i],
      sensorId = sensor.id;
      entireHtml += '<div>' +
                    '<div class="sensBackground">' +
                        '<div class="row">' +
                            '<div class="col-xs-6 col-sm-2"></div>' +
                            '<div class="col-xs-6 col-sm-6">' +
                                '<div class="row">' +
                                    '<div class="col-xs-6 col-sm-2" style="padding: 5px 0 5px 0;"></div>' +
                                    '<div class="col-xs-6 col-sm-4" style="padding: 5px 0 5px 0;">' +
                                        '<div class="butStyle" style="background-color: #00a379">Type</div>' +
                                    '</div>' +
                                    '<div class="col-xs-6 col-sm-3" style="padding: 5px 0 5px 0;">' +
                                        '<div class="inpStyle" style="background-color: #00a379"> ' + sensor.name + '</div>' +
                                    '</div>' +
                                    '<div class="col-xs-6 col-sm-3" style="padding: 5px 0 5px 5px;">' +
                                        '<!--<a href="#" class="">-->' +
                                        '<button type="button"  onclick="viewSensorData(' + sensorId + ')">' +
                                            '<img src="lib/images/data.png" width="17" height="17" >'+
                                        '</button>' +
                                        '<button type="button" id="editSensorButton' + sensorId + '" data-toggle="modal"' +
                                                'data-target="#editSensorModal' + sensorId + '">' +
                                            '<img src="lib/images/edit.png" width="17" height="17">' +
                                        '</button>' +

                                        '<div class="modal fade" id="editSensorModal' + sensorId + '" tabindex="-1" role="dialog"' +
                                             'aria-labelledby="editSensorModalLabel' + sensorId + '" aria-hidden="true">' +
                                            '<div class="modal-dialog">' +
                                                '<div class="modal-content">' +
                                                    '<!-- Modal Header -->' +
                                                    '<div class="modal-header">' +
                                                        '<h4 class="modal-title" id="editSensorModalLabel' + sensorId + '">Edit device</h4>' +
                                                    '</div>' +

                                                    '<!-- Modal Body -->' +
                                                    '<div class="modal-body">' +

                                                        '<form class="form-horizontal" role="form">' +
                                                            '<div class="form-group">' +
                                                                '<label class="control-label col-sm-2" for="editSensorName' + sensorId + '">Device name</label>' +
                                                                '<div class="col-sm-10">' +
                                                                    '<input type="text" class="form-control" id="editSensorName' + sensorId + '" placeholder="Name" value="' + sensor.name + '" required/>' +
                                                                '</div>' +
                                                            '</div>' +
                                                            '<div class="form-group">' +
                                                                '<label class="control-label col-sm-2" for="editSensorType' + sensorId + '">Sensor Type</label>' +
                                                                '<div class="col-sm-10">' +
                                                                    '<input type="text" class="form-control" id="editSensorType' + sensorId + '"' +
                                                                    'placeholder="Type" value="' + sensor.sensorType + '"required/>' +
                                                                '</div>' +
                                                            '</div>' +
                                                            '<div class="form-group">' +
                                                                '<label class="control-label col-sm-2" for="editSensorMinValue' + sensorId + '">Min. Value</label>' +
                                                                '<div class="col-sm-10">' +
                                                                    '<input type="number" class="form-control" id="editSensorMinValue' + sensorId + '" placeholder="Min. Value" value="' + sensor.minValue + '" required/>' +
                                                                '</div>' +
                                                            '</div>' +
                                                            '<div class="form-group">' +
                                                                '<label class="col-sm-2 control-label"' +
                                                                       'for="editSensorMaxValue' + sensorId + '">Max. Value</label>' +
                                                                '<div class="col-sm-10">' +
                                                                    '<input type="number" class="form-control"' +
                                                                           'id="editSensorMaxValue' + sensorId + '" placeholder="Max. Value"' +
                                                                           'value="' + sensor.maxValue + '" required/>' +
                                                                '</div>' +
                                                            '</div>' +
                                                            '<div class="form-group">' +
                                                                '<label class="col-sm-2 control-label" for="editSensorEventEnabled' + sensorId + '">Event Enabled</label>' +
                                                                '<div class="col-sm-10">' +
                                                                    '<input type="text" class="form-control" id="editSensorEventEnabled' + sensorId + '"' +
                                                                           'placeholder="Event Enabled" value="' + sensor.isEventEnabled + '" required/>' +
                                                                '</div>' +
                                                            '</div>' +
                                                        '</form>' +
                                                    '</div>' +
                                                    '<input type="hidden" id="sensorId' + sensorId + '" value="' + sensorId + '"/>' +
                                                    '<input type="hidden" id="deviceId' + sensorId + '" value="' + sensor.deviceId + '"/>' +
                                                    '<!-- Modal Footer -->' +
                                                    '<div class="modal-footer">' +
                                                        '<button type="button" class="btn btn-default" data-dismiss="modal">Close </button>' +
                                                        '<button type="button" class="btn btn-primary" onclick="addNewSensor(this,\'update\',' + sensorId + ')">Save changes </button>' +
                                                    '</div>' +
                                                '</div>' +
                                            '</div>' +
                                        '</div>' +

                                        '<!--</a>-->' +
                                    '<!--<a href="#" class="">-->' +
                                    '<button type="button" id="removeSensorButton' + sensorId + '" onclick="removeSensor(' + sensorId + ')">' +
                                        '<img src="lib/images/remove.png" width="17" height="17">' +
                                    '</button>' +
                                    '<!--</a>-->' +
                                '</div>' +
                            '</div>' +
                        '</div>' +
                        '<div class="col-xs-6 col-sm-4"></div>' +
                    '</div>' +

                    '<div class="row">' +
                        '<div class="col-xs-6 col-sm-2"></div>' +
                        '<div class="col-xs-6 col-sm-6">' +
                            '<div class="row">' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="butStyle">Min. Value</div>' +
                                '</div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="inpStyle"> ' + sensor.minValue + '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>' +
                        '<div class="col-xs-6 col-sm-4"></div>' +
                    '</div>' +

                    '<div class="row">' +
                        '<div class="col-xs-6 col-sm-2"></div>' +
                        '<div class="col-xs-6 col-sm-6">' +
                            '<div class="row">' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="butStyle">Max. Value</div>' +
                                '</div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="inpStyle">' + sensor.maxValue + '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>' +
                        '<div class="col-xs-6 col-sm-4"></div>' +
                    '</div>' +

                    '<div class="row">' +
                        '<div class="col-xs-6 col-sm-2"></div>' +
                        '<div class="col-xs-6 col-sm-6">' +
                            '<div class="row">' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="butStyle">Event Enable</div>' +
                                '</div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="inpStyle">' + sensor.isEventEnabled + '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>' +
                        '<div class="col-xs-6 col-sm-4"></div>' +
                    '</div>' +

                    '<div class="row">' +
                        '<div class="col-xs-6 col-sm-2"></div>' +
                        '<div class="col-xs-6 col-sm-6">' +
                            '<div class="row">' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;"></div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="butStyle">Last Value Read</div>' +
                                '</div>' +
                                '<div class="col-xs-6 col-sm-4" style="padding: 0 0 0 0;">' +
                                    '<div class="inpStyle"> ' + sensor.lastValueRead + '</div>' +
                                '</div>' +
                            '</div>' +
                        '</div>' +
                        '<div class="col-xs-6 col-sm-4"></div>' +
                    '</div>' +
                '</div>' +
        '</div>' +


    '<div class="row">' +
        '<div class="col-xs-6 col-sm-2"></div>' +
        '<div class="col-xs-6 col-sm-6"></div>' +
        '<div class="col-xs-6 col-sm-4"></div>' +
    '</div>';
  }

  return entireHtml;
}