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
        } else if (action.equals("setMulSel")) {
            String pinName = args.getString(0);
            int pinNumber = args.getInt(1);
            int flag = args.getInt(2);
            if ( pinName.length() > 0 ) {
                this.setMulSel(pinName[0], pinNumber, flag, callbackContext);
            }
        } else if (action.equals("writeGpio")) {
            String pinName = args.getString(0);
            int pinNumber = args.getInt(1);
            int flag = args.getInt(2);
            if ( pinName.length() > 0 ) {
                this.writeGpio(pinName[0], pinNumber, flag, callbackContext);
            }
        } else if (action.equals("readGpio")) {
            String pinName = args.getString(0);
            int pinNumber = args.getInt(1);
            if ( pinName.length() > 0 ) {
                this.readGpio(pinName[0], pinNumber, callbackContext);
            }
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

    protected void setMulSel(char pinName, int pinNumber, int flag, CallbackContext callbackContext) {
        Gpio.setMulSel(pinName, pinNumber, flag);
        callbackContext.success("setMulSel");
    }

    protected void writeGpio(char pinName, int pinNumber, int flag, CallbackContext callbackContext) {
        Gpio.writeGpio(pinName, pinNumber, flag);
        callbackContext.success("writeGpio");
    }

    protected void readGpio(char pinName, int pinNumber, CallbackContext callbackContext) {
        int ret = Gpio.readGpio(pinName, pinNumber);
        callbackContext.success(ret);
    }
}