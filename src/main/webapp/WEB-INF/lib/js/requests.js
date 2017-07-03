var host = "localhost:8080/"

$(document).ready(function () {

    $("#submitRegistration").click(function () {
        $.post(host + "/user/registerUser",
            {
                username: "Donald Duck",
                password: "Duckburg",
                email: "asd@asd.com",
                phone: 2543543534
            },
            function (data) {
                alert("Data: " + data + "\nStatus: " + status);
            });
    });

    $("#signInButton").click(function () {
        alert("Entered sign");
        $.post("/token",
            {
                username: "Donald Duck",
                password: "Duckburg"
            },
            function (data) {
                alert("Data: " + data + "\nStatus: ");
            });
        alert("End sign");
    });
});


function addNewDevice(button, action, deviceId) {
    var parentModal = button.parentElement.parentElement,
        id, frequency, name, deviceSn, token, accessLevel, location, url;

    if (action === "update") {
        url = "/iot/device/editDevice";
        id = $(parentModal).find("#editId" + deviceId);
        frequency = $(parentModal).find("#editFrequency"+ deviceId);
        name = $(parentModal).find("#editDeviceName"+ deviceId);
        deviceSn = $(parentModal).find("#editDeviceSN"+ deviceId);
        token = $(parentModal).find("#editToken"+ deviceId);
        accessLevel = $(parentModal).find("#editAccessLevel"+ deviceId);
        location = $(parentModal).find("#editLocation"+ deviceId);
    } else {
        url = "/iot/device/addDevice";
        id = $(parentModal).find("#inputId");
        frequency = $(parentModal).find("#inputFrequency");
        name = $(parentModal).find("#inputDeviceName");
        deviceSn = $(parentModal).find("#inputDeviceSN");
        token = $(parentModal).find("#inputToken");
        accessLevel = $(parentModal).find("#inputAccessLevel");
        location = $(parentModal).find("#inputLocation");
    }


    var device = {
        "id": id.val(),
        "dataFrequency": frequency.val(),
        "name": name.val(),
        "deviceSN": deviceSn.val(),
        "token": token.val(),
        "accessLevel": accessLevel.val(),
        "location": location.val()

    };

    $.ajax({
        type: "POST",
        url: url,
        async: false,
        data: JSON.stringify(device),
        contentType: "application/json",
        complete: function (data) {
            if (data.statusText === "success") {
                location.reload();
            } else {
                alert("Could not register");
            }
        }
    });

}

function addNewSensor(button, action, sensorId) {
    let parentModal = button.parentElement.parentElement,
        sensId,sensorType, deviceId, name, minValue, maxValue, eventEnabled, url;

    if (action === "update") {
        url = "/iot/sensor/editSensor";
        sensId = $(parentModal).find("#sensorId" + sensorId);
        deviceId = $(parentModal).find("#deviceId" + sensorId);
        name = $(parentModal).find("#editSensorName"+ sensorId);
        sensorType = $(parentModal).find("#editSensorType"+ sensorId);
        minValue = $(parentModal).find("#editSensorMinValue"+ sensorId);
        maxValue = $(parentModal).find("#editSensorMaxValue"+ sensorId);
        eventEnabled = $(parentModal).find("#editSensorEventEnabled"+ sensorId);
    } else {
        url = "/iot/sensor/addSensor";

        name = $(parentModal).find("#addSensorName"+ sensorId);
        sensorType = $(parentModal).find("#addSensorType"+ sensorId);
        minValue = $(parentModal).find("#addSensorMinValue"+ sensorId);
        maxValue = $(parentModal).find("#addSensorMaxValue"+ sensorId);
        eventEnabled = $(parentModal).find("#addSensorEventEnabled"+ sensorId);
        deviceId = $(parentModal).find("#deviceId"+ sensorId);
        sensId = $(parentModal).find("#sensorId" + sensorId);
    }


    let sensor = {
        "id": sensId.val(),
        "name": name.val(),
        "sensorType": sensorType.val(),
        "deviceId": deviceId.val(),
        "minValue": minValue.val(),
        "maxValue": maxValue.val(),
        "isEventEnabled": eventEnabled.val()

    };

    $.ajax({
        type: "POST",
        url: url,
        async: false,
        data: JSON.stringify(sensor),
        contentType: "application/json",
        complete: function (data) {
            if (data.statusText === "success") {
                location.reload();
            } else {
                alert("Could not save sensor");
            }
        }
    });

}


$(function () {

    $(".logOut").click(function () {

        sessionStorage.removeItem("userId");
        sessionStorage.removeItem("username");

        // also remove session from server
        $.ajax({
            type: "POST",
            url: "/iot/logOut",
            async: false,
            contentType: "application/json"
        });

        window.location.href = "/iot/index";
    });
});
