package com.lingang.utils;

import android.text.TextUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * json的工具类
 * @author liguotao
 *
 */
public class JsonUtil {

	public static final String DefaultDateFormat = "yyyy/MM/dd HH:mm:ss";
	public static boolean isPrintException = true;

	/**
	 * 提供指定日期格式的Gson对象
	 * 
	 * @param dateFormat
	 * @return
	 */
	public static Gson getGson(String dateFormat) {
		return new GsonBuilder().setDateFormat(dateFormat).create();
	}

	/**
	 * 提供默认日期解析格式的Gson对象
	 * 
	 * @return
	 */
	public static Gson getGson() {
		return new GsonBuilder().setDateFormat(DefaultDateFormat).create();
	}

	/**
	 * json转指定对象
	 * 
	 * @author luxf 2015-7-14 下午9:18:48
	 * @param json
	 * @param cls
	 * @return
	 * @return T
	 */
	public static <T> T getModle(String json, Class<T> cls) {
		return getGson().fromJson(json, cls);
	}

	/**
	 * json转指定对象(key为json中为列表的字段名)
	 * 
	 * @author luxf 2015-7-14 下午9:18:48
	 * @param json
	 * @param cls
	 * @return
	 * @return T
	 */
	public static <T> T getModle(String json, Class<T> cls, String key) {
		json = getString(json, key);
		return getGson().fromJson(json, cls);
	}

	/**
	 * json转指定对象列表
	 * 
	 * @author luxf 2015-7-16 下午3:01:42
	 * @param json
	 * @return
	 * @return List<T>
	 */
	public static <T> List<T> getListModle(String json) {
		List<T> list = new ArrayList<T>();
		Type type = new TypeToken<ArrayList<T>>() {
		}.getType();
		list = getGson().fromJson(json, type);
		return list;
	}

	/**
	 * json转指定对象列表(key为json中为列表的字段名)
	 * 
	 * @author luxf 2015-7-16 下午3:01:50
	 * @param json
	 * @param key
	 * @return
	 * @return List<T>
	 */
	public static <T> List<T> getListModle(String json, String key) {
		json = getString(json, key);
		List<T> list = new ArrayList<T>();
		Type type = new TypeToken<ArrayList<T>>() {
		}.getType();
		list = getGson().fromJson(json, type);
		return list;
	}

	/**
	 * get String from jsonObject
	 * 
	 * @param jsonObject
	 * @param key
	 * @return <ul>
	 *         <li>if jsonObject is null, return null</li>
	 *         <li>if key is null or empty, return null</li>
	 *         <li>if {@link JSONObject#getString(String)} exception, return
	 *         null</li>
	 *         <li>return {@link JSONObject#getString(String)}</li>
	 *         </ul>
	 */
	public static String getString(String jsonObject, String key) {
		return getString(jsonObject, key, null);
	}

	/**
	 * get String from jsonObject
	 * 
	 * @param jsonObject
	 * @param key
	 * @param defaultValue
	 * @return <ul>
	 *         <li>if jsonObject is null, return defaultValue</li>
	 *         <li>if key is null or empty, return defaultValue</li>
	 *         <li>if {@link JSONObject#getString(String)} exception, return
	 *         defaultValue</li>
	 *         <li>return {@link JSONObject#getString(String)}</li>
	 *         </ul>
	 */
	public static String getString(String jsonObject, String key,
			String defaultValue) {
		if (jsonObject == null || TextUtils.isEmpty(key)) {
			return defaultValue;
		}

		try {
			return new JSONObject(jsonObject).getString(key);
		} catch (JSONException e) {
			if (isPrintException) {
				e.printStackTrace();
			}
			return defaultValue;
		}
	}
}
