package com.celebritysupermarket.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * @author wzd
 * @version $Rev$
 * @time 2016/2/25 15:37
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class ShowToast {


    public static void show(final Activity context, final String mess) {
        // 判断 是否主线程
        if (Thread.currentThread().getName().equals("main")) {
            Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();
        } else {
            context.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

}
