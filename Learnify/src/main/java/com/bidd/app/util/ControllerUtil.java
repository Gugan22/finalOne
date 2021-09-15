package com.bidd.app.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

@Service
public class ControllerUtil {

	
	public static String getSuccessResponse(String output,String message,String org_id,String user_id,String service_name) throws JSONException {
		String resultStr  = null;
		String data = null;
		JSONObject result = new JSONObject();
		//prepare datastatus object
		JSONObject dataStatus = new JSONObject();
		dataStatus.put("isSuccess", Boolean.valueOf(true));	
		dataStatus.put("message", message);
		dataStatus.put("message_code", "200");
		result.put("dataStatus", dataStatus);
		int size = 0;
		if(output == null)
		{
			result.put("payload","");
		}
		else
		{
			data = output;
			Object json = new JSONTokener(data).nextValue();
			if (json instanceof JSONObject)//if the result is json object then convert the data into json object
			{
				JSONObject jsonobj = new JSONObject(data);
				result.put("payload", jsonobj);
			}
			else if (json instanceof JSONArray)//if the result is json array then convert the data into json array
			{
				JSONArray jsonarr = new JSONArray(data);
				size = jsonarr.length();
				result.put("payload", jsonarr);
			}
			else
			{
				result.put("payload", output);
			}
		}
		resultStr = result.toString();
		
	//just save the request done information in log
		String response = "Team_id: " +org_id +"User_id: "+user_id+"  Service_name: "+service_name+" response: done";//+resultStr.toString() ;
		return resultStr;
	}

	
	public static String getErrorResponse(int errorCode, String errorMessage,String org_id,String user_id,String service_name) throws JSONException {
		JSONObject dataStatus = new JSONObject();
		dataStatus.put("message_code", errorCode);
		dataStatus.put("message", errorMessage);
		dataStatus.put("isSuccess", Boolean.valueOf(false));
		JSONObject result = new JSONObject();
		result.put("dataStatus", dataStatus);
		//just save the request error information in log
		String response = "Team_id: " +org_id +"  User_id: "+user_id+"  Service_name: "+service_name+" response: "+result.toString() ;
		return result.toString();
	}
	
	
	public static String getUnhandledErrorResponse(String org_id,String user_id,String service_name) throws JSONException
	{
		return getErrorResponse(200, "OOPS Something Went Wrong",org_id,user_id,service_name);
	}

	
}
