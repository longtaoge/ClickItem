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

                if (Hawk.get(getCacheUrl(url)) == null) {//用图片URL固定的部分获取第一次缓存图片时的全URL

                    Hawk.put(getCacheUrl(url), url); //如果没有缓存过，将第图片第一次加载时的URL缓存起来
                   //第一次加载用全路径从网络上加载
                    Glide.with(context)
                            .load(url)
                            .into(imageView);

                } else {
                    //第二次以后能过 url 加载本地缓存图片
                    Glide.with(context)
                            .load(Hawk.get(getCacheUrl(url)))
                            .into(imageView);
                }


            } else {
                 //如果非动态URL 则直接加载即可
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
