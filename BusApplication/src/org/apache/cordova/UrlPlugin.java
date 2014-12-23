package org.apache.cordova;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class UrlPlugin extends CordovaPlugin {
	
	public final String ACTION_SEND = "SendRequest";
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals(ACTION_SEND)) {
			try {				
				String name = args.getString(0);
				System.out.println("URL Value::"+name);
				
				//String output = "http://115.111.228.109:8080/vtpis/appQuery.do?"; // test url
				String output = "http://125.16.1.204:8080/vtpis/appQuery.do?"; //production url
				
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, output));
				return true;
			}
			catch (Exception ex) {
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
			}			
		}
		return false;
	}
	

}
