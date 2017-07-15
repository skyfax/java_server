package iot.common;

import iot.core.entities.sensorValue.SensorValue;
import net.minidev.json.JSONObject;

import java.util.List;

/**
 * Created by Shyzzle on 12/07/2017.
 */
public class SearchTextParser {

    public static SearchCriteria parseAndValidateSearchText( String searchText){

        if(searchText.equals("")){
            return  null;
        }

        return new SearchCriteria();
    }

    public static JSONObject convertSearchResults(List<SensorValue> values, SearchCriteria searchCriteria){

        return new JSONObject();
    }
}
