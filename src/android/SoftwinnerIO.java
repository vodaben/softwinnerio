package io.alphabeans.plugin.SoftwinnerIO;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.util.concurrent.locks.*;
import java.util.concurrent.TimeUnit;

import com.softwinner.utils.Config;
import com.softwinner.Gpio;

public class SoftwinnerIO extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("echo")) {
            String message = args.getString(0);
            this.echo(message, callbackContext);
            return true;
        } else if (action.equals("adjustRed")) {
            int level = args.getInt(0);
            this.adjustRed(level, callbackContext);
            return true;
        } else if (action.equals("adjustGreen")) {
            int level = args.getInt(0);
            this.adjustGreen(level, callbackContext);
            return true;
        } else if (action.equals("adjustYellow")) {
            int level = args.getInt(0);
            this.adjustYellow(level, callbackContext);
            return true;
        } else if (action.equals("closeLed")) {
            this.closeLED(callbackContext);
            return true;
        }
        return false;
    }

    protected void echo(String message, CallbackContext callbackContext) {
         Log.d("SoftwinnerIO", message);
         callbackContext.success("Echoed");
        // System.out.println(message);
    }

    protected void closeLED(CallbackContext callbackContext) {
        Config.closeLed();
        callbackContext.success("Closed LED");
    }

    protected void adjustRed(int level, CallbackContext callbackContext) {
        Config.adjustRed(level);
        callbackContext.success("Adjusted RED");
    }

    protected void adjustGreen(int level, CallbackContext callbackContext) {
        Config.adjustGreen(level);
        callbackContext.success("Adjusted GREEN");
    }

    protected void adjustYellow(int level, CallbackContext callbackContext) {
        Config.adjustYellow(level);
        callbackContext.success("Adjusted YELLOW");
    }
}