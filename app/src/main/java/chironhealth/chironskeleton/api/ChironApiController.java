package chironhealth.chironskeleton.api;

/**
 * Created by SamMyxer on 10/15/15.
 */

import android.content.Context;
import android.content.SharedPreferences;

import chironhealth.chironskeleton.ChironApplication;

/**
 * Created by SamHarris on 9/24/14.
 * API Controller class.  Contains methods to call to create Volley requests
 */

public class ChironApiController {

    private static ChironApiController controller;
    private Context mAppContext;

    private static final String PREFS = "PREFS";


    private static SharedPreferences prefs = ChironApplication.getAppContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);


    /**
     * @return instance of singleton HSApiController object
     */
    public static ChironApiController getInstance() {
        if(controller == null) {
            controller = new ChironApiController();
        }
        return controller;
    }



}
