package iot.core.services.helper;

/**
 * Created by Shyzzle on 13/07/2017.
 */
public enum Command {
    AUTHENTICATE(0),
    EVENT(1),
    GET_VALUE(2),
    SET_MIN_VALUE(3),
    SET_MAX_VALUE(4),
    FREQUENCY(5),
    RESET(6),
    UNKNOWN(7),
    INTERVAL(8);



    private int code;

    private Command(int code){
        this.code = code;
    }

    public static Command toCommand(String txt){
        txt= txt.toUpperCase();

        switch (txt){
            case "AUTHENTICATE" : return AUTHENTICATE;
            case "EVENT" : return EVENT;
            case "GET_VALUE" : return GET_VALUE;
            case "SET_MIN_VALUE" : return SET_MIN_VALUE;
            case "SET_MAX_VALUE" : return SET_MIN_VALUE;
            case "FREQUENCY": return SET_MIN_VALUE;
            case "RESET" :return RESET;
            case "INTERVAL" : return INTERVAL;
            default: return UNKNOWN;
        }
    }
}
