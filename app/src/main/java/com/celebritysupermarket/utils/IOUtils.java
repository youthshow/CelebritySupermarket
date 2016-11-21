package com.celebritysupermarket.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @项目名称:Daoye
 * @包名:mobile.daoye.utils
 * @作者:王祖典
 * @创建时间:2016-6-9 下午1:44:26
 * @描述:关流工具
 * 
 * @SVN版本号:$Rev$
 * @修改人:$Author:zd$
 * @修改时间:$Date$
 * @修改的内容:IO
 */
public class IOUtils {

	/** 关闭流 */
	public static boolean close(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (IOException e) {
				Logger.e("IO",e.toString());
			}
		}
		return true;
	}
	
	
	//读取数据
	public static String decodeStream(InputStream in) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int len=0;
		byte[] buf = new byte[1024];
		while((len=in.read(buf))>0){
			baos.write(buf, 0, len);
		}
		in.close();
		return baos.toString();
		
	}
}
