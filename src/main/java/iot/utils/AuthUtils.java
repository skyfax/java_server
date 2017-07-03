package iot.utils;

import javax.servlet.http.HttpSession;

/**
 * Created by Shyzzle on 01/07/2017.
 */
public class AuthUtils {

    public static boolean isUserAuthenticated(HttpSession session) {
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");

        return isAuthenticated != null ? isAuthenticated : false;
    }

    public static Long getUserId(HttpSession session){
        return (Long) session.getAttribute("userId");
    }
}
