package com.evervc.imageloaderlibrary.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.evervc.imageloaderlibrary.R;
import com.evervc.imageloaderlibrary.imageloader.transformation.CropCircleTransformation;
import com.evervc.imageloaderlibrary.imageloader.transformation.GlideCircleTransform;
import com.evervc.imageloaderlibrary.imageloader.transformation.RoundedCornersTransformation;


/**
 * Created by yaoyao on 2016/12/27.
 */

public class GlideImageLoaderProvider implements BaseImageLoaderProvider {

    /**
     * 占位图
     */
    public static final int PLACE_HOLDER= R.mipmap.ic_launcher;

    @Override
    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(PLACE_HOLDER)
                .into(imageView);
    }

    @Override
    public void loadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(PLACE_HOLDER)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);
    }
    @Override
    public void loadCircleImageWithBorder(Context context, String url, ImageView imageView,int borderWidth,int borderColor) {
        Glide.with(context)
                .load(url)
                .placeholder(PLACE_HOLDER)
                .bitmapTransform(new GlideCircleTransform(context, borderWidth, borderColor))
                .into(imageView);
    }

    @Override
    public void loadRoundImage(Context context, String url, ImageView imageView, int radius, int margin) {
        Glide.with(context)
                .load(url)
                .placeholder(PLACE_HOLDER)
                .bitmapTransform(new RoundedCornersTransformation(context,radius,margin))
                .into(imageView);
    }

    public void loadImageWithListener(Context context, String url, ImageView imageView,RequestListener<String,GlideDrawable> requestListener) {
        Glide.with(context)
                .load(url)
                .placeholder(PLACE_HOLDER)
                .listener(requestListener)
                .into(imageView);
    }
}
