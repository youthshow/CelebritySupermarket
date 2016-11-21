package com.celebritysupermarket.impl;

/**
 * @author wzd
 * @version $Rev$
 * @time 2016/4/5 11:09
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public interface ApiRequestListen {

    void onSuccess(int method, String success);

    void onCacheSuccess(int method, Object obj);

    void onError(int method, String error);
}
