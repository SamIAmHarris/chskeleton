package chironhealth.chironskeleton;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

/**
 * Created by SamMyxer on 10/15/15.
 */
public class ChironApplication extends Application {

    private static Context context;
    private static ChironApplication appInstance;
    private static RequestQueue requestQueue;

    public static final String TAG = "ChironVolley";


    public ChironApplication(){
        this.appInstance = this;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        ChironApplication.context = getApplicationContext();

    }

    public static ChironApplication getInstance(){
        return appInstance;
    }


    public static Context getAppContext(){
        return ChironApplication.context;
    }


    public RequestQueue getRequestQueue() {

        //we create the request queue if it is null here
        //and then always return it
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }


    //if you give it a tag it uses that tag instead of default tag as long
    //as the tag is not empty
    public <T> void addToRequestQueue(Request<T> req, String tag) {

        req.setTag(TextUtils.isEmpty(tag) ? TAG: tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {

        req.setTag(TAG);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(String tag) {

        if(requestQueue != null) {
            getRequestQueue().cancelAll(tag);
        }

    }

}
