package org.xiangbalao.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orhanobut.hawk.Hawk;

/**
 * Created by longtaoge on 2016/7/25.
 */
public class GlideUtils {


   // public static String slipTag = "\\?";

    public static String slipTag = "it";

    public static void loadImage(Context context, String url, ImageView imageView) {


        if (url != null) {
            String[] urls = url.split(slipTag);
            if (urls.length > 1) {

                if (Hawk.get(getCacheUrl(url)) == null) {

                  Hawk.put(getCacheUrl(url), url);

                    Glide.with(context)
                            .load(url)
                            .into(imageView);
                } else {

                    Glide.with(context)
                            .load(Hawk.get(getCacheUrl(url)))
                            .into(imageView);
                }


            } else {

                Glide.with(context)
                        .load(url)
                        .into(imageView);
            }

        }


    }







    public static String getCacheUrl(String url) {
        if (url != null) {
            String[] urls = url.split(slipTag);
            if (urls.length > 0) {
                return urls[0];
            } else {
                return "";
            }
        } else {
            return "";
        }

    }


}
