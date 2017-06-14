package iot.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shyzzle on 11/06/2017.
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    protected ModelAndView handleLoginPage(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("login");

        return model;
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    protected ModelAndView handleDevicesPage(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("devices");

        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    protected ModelAndView handleIndexPage(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("index");

        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    protected ModelAndView handleRegisterPage(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("register");

        return model;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    protected ModelAndView handleAccountPage(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("account");

        return model;
    }
}
