package iot.presentation.controllers;

import iot.core.services.interfaces.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    SensorService sensorService;

}
