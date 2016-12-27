package com.evervc.imageloaderlibrary.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by yaoyao on 2016/12/27.
 */

public class ImageLoaderUtil {

    private BaseImageLoaderProvider mImageLoaderProvider;

    private static ImageLoaderUtil mInstance;
    public static ImageLoaderUtil getInstance(){
        if(mInstance ==null){
            synchronized (ImageLoaderUtil.class){
                if(mInstance == null){
                    mInstance = new ImageLoaderUtil();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }
    public ImageLoaderUtil(){
        mImageLoaderProvider=new GlideImageLoaderProvider();
    }


    public void loadImage(Context context, String url, ImageView imageView) {
        mImageLoaderProvider.loadImage(context,url,imageView);
    }

    public void loadCircleImage(Context context, String url, ImageView imageView) {
        mImageLoaderProvider.loadCircleImage(context,url,imageView);
    }
    public void loadCircleImageWithBorder(Context context, String url, ImageView imageView,int borderWidth,int borderColor) {
        mImageLoaderProvider.loadCircleImageWithBorder(context,url,imageView,borderWidth,borderColor);
    }
    public void loadRoundImage(Context context, String url, ImageView imageView,int radius,int margin) {
        mImageLoaderProvider.loadRoundImage(context,url,imageView,radius,margin);
    }
}
