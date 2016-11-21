package com.celebritysupermarket.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @项目名称: Zhbj10
 * @包名: org.itheima.zhbj10.utils
 * @作者: 肖琦
 * @创建时间: 2015-8-13 上午10:49:01
 * @描述: 存储 key-value 本地 数据
 * 
 * @SVN版本号: $Rev: 32 $
 * @修改人: $Author: xq $
 * @修改时间: $Date: 2015-08-16 09:06:07 +0800 (Sun, 16 Aug 2015) $
 * @修改的内容: TODO
 * 
 */
public class PreferenceUtils
{
	private static SharedPreferences	mSp;
	private static final String			SP_NAME	= "config";

	private static SharedPreferences getPreferences(Context context)
	{
		if (mSp == null)
		{
			mSp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
		}
		return mSp;
	}

	/**
	 * 获得boolean数据
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 *            :没有时的默认值
	 * @return
	 */
	public static boolean getBoolean(Context context, String key, boolean defValue)
	{
		SharedPreferences sp = getPreferences(context);
		return sp.getBoolean(key, defValue);
	}

	/**
	 * 获得boolean数据，如果没有返回false
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Context context, String key)
	{
		return getBoolean(context, key, false);
	}

	/**
	 * 设置boolean数据
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void setBoolean(Context context, String key, boolean value)
	{
		SharedPreferences sp = getPreferences(context);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	/**
	 * 获得String数据
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 *            :没有时的默认值
	 * @return
	 */
	public static String getString(Context context, String key, String defValue)
	{
		SharedPreferences sp = getPreferences(context);
		return sp.getString(key, defValue);
	}

	/**
	 * 获得String数据，如果没有返回null
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static String getString(Context context, String key)
	{
		return getString(context, key, null);
	}

	/**
	 * 设置String数据
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void setString(Context context, String key, String value)
	{
		SharedPreferences sp = getPreferences(context);
		Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/**
	 * 获得long数据
	 * 
	 * @param context
	 * @param key
	 * @param defValue
	 *            :没有时的默认值
	 * @return
	 */
	public static long getLong(Context context, String key, long defValue)
	{
		SharedPreferences sp = getPreferences(context);
		return sp.getLong(key, defValue);
	}

	/**
	 * 获得long数据，如果没有返回0
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static long getLong(Context context, String key)
	{
		return getLong(context, key, 0);
	}

	/**
	 * 设置long数据
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void setLong(Context context, String key, long value)
	{
		SharedPreferences sp = getPreferences(context);
		Editor editor = sp.edit();
		editor.putLong(key, value);
		editor.commit();
	}
}
