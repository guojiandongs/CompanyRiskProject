package com.example.administrator.riskprojects.tools;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONArray;
import com.example.administrator.riskprojects.bean.UserInfo;

import java.util.List;


public class UserUtils {
	private static final String TAG = "UserUtils";
	/**
	 * 获取用户信息
	 * 
	 * @param context
	 * @return
	 */
	public static UserInfo getUserModel(Context context) {
		UserInfo user = null;
		String jsondata = Utils.getValue(context, Constants.UserInfo);
		if (!TextUtils.isEmpty(jsondata)) {
			List<UserInfo> userInfoList = JSONArray.parseArray(jsondata, UserInfo.class);
			user = userInfoList.get(0);
		}
		//user = JSON.parseObject(jsondata, User.class);
		return user;
	}

	/**
	 * 获取用户ID
	 *
	 * @param context
	 * @return
	 */
	public static String getUserID(Context context) {
		UserInfo user = getUserModel(context);
		if (user != null) {
			return user.getId();
		}else{
			return "";
		}
	}

	/**
	 * 获取用户角色ID
	 * 
	 * @param context
	 * @return
	 */
	public static String getUserRoleids(Context context) {
		UserInfo user = getUserModel(context);
		if (user != null) {
			return user.getRoleids();
		}else{
			return "";
		}
	}

	/**
	 * 获取用户名字
	 * 
	 * @param context
	 * @return
	 */
	public static String getUserName(Context context) {
		UserInfo user = getUserModel(context);
		if (user != null)
			return user.getRealName();
		else
			return "";
	}

	/**
	 * 获取用户
	 *
	 * @param context
	 * @return
	 */
	public static String getUserPwd(Context context) {
		UserInfo user = getUserModel(context);
		if (user != null)
			return user.getPassword();
		else
			return "";
	}

}
