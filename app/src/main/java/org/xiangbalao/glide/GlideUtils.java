package org.xiangbalao.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.orhanobut.hawk.Hawk;

/**
 * Created by longtaoge on 2016/7/25.
 */
public class GlideUtils {


    // public static String slipTag = "\\?";  //加载七牛时用本分隔符

    public static String slipTag = "it";

    public static void loadImage(final Context context, final String url, final ImageView imageView) {


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
                            .load(String.valueOf(Hawk.get(getCacheUrl(url))))
                            // 设置加载失败监听，假如由于缓存过期或
                            // 者被清等客观原因导致加载失败，从最新的url 加载，并更新本地缓存
                            .listener(new RequestListener<String, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    Hawk.put(getCacheUrl(url), url); //更新缓存
                                    Glide.with(context)
                                            .load(url)
                                            .into(imageView);
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    return false;
                                }
                            })
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
