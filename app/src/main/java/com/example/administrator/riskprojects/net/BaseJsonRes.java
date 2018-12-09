package com.example.administrator.riskprojects.net;

import android.util.Log;

import com.example.administrator.riskprojects.tools.Constants;
import com.example.administrator.riskprojects.tools.Utils;
import com.example.administrator.riskprojects.util.FormatUtil;
import com.juns.health.net.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseJsonRes extends JsonHttpResponseHandler {
	private static final String TAG = "BaseJsonRes";
	@Override
	public void onSuccess(JSONObject response) {
		try {
			System.out.println("============返回的值==================="+response.toString());
			FormatUtil.printJson(response.toString());
			String result = response.getString(Constants.Result);
			String content = response.getString(Constants.Info);
			if("success".equals(result)){
				String str_data = response.getString(Constants.Value);
				onMySuccess(str_data);
			}else if("fail".equals(result)){
				onMyFailure(content);
			}else{
				onMyFailure(Constants.NET_ERROR);
			}

		} catch (JSONException e) {
			e.printStackTrace();
			onMyFailure(Constants.NET_ERROR);
		}
	}

	public abstract void onMySuccess(String data);

	public abstract void onMyFailure(String content);
}
