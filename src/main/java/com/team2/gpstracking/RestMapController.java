package com.team2.gpstracking;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RestMapController {
    public static class RestResponse {
        private float latitude;
        private float longitude;

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }
    }

    public RestResponse globalRes;

    @RequestMapping(value = "/add-tracking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse addTracking(@RequestParam Map<String,String> requestParams){
        RestResponse res = new RestResponse();

        float latitude = Float.parseFloat(requestParams.get("latitude"));
        float longitude = Float.parseFloat(requestParams.get("longitude"));

        res.setLatitude(latitude);
        res.setLongitude(longitude);

        globalRes = res;
        return res;
    }

    @GetMapping(value = "/get-last-tracking", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse lastTracking(Model model) throws JsonProcessingException {
//        String json = new ObjectMapper().writeValueAsString(globalRes);
        return globalRes;
    }
}
