package com.evervc.imageloaderlibrary;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.evervc.imageloaderlibrary.imageloader.ImageLoaderUtil;
import com.evervc.imageloaderlibrary.imageloader.transformation.CropCircleTransformation;
import com.evervc.imageloaderlibrary.imageloader.transformation.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image1)
    ImageView mImage1;
    @BindView(R.id.image2)
    ImageView mImage2;
    @BindView(R.id.image3)
    ImageView mImage3;
    @BindView(R.id.image4)
    ImageView mImage4;
    @BindView(R.id.image5)
    ImageView mImage5;

    private Context mContext;

    private static final String URL="http://4493bz.1985t.com/uploads/allimg/150127/4-15012G52133.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext=this;

        Glide.with(this).load(URL).into(mImage1);

        Glide.with(this).load(R.mipmap.ic_launcher).into(mImage2);

        Glide.with(this).load(URL).placeholder(R.mipmap.ic_launcher).transform(new GlideCircleTransform(this,2, Color.parseColor("#ff0000"))).into(mImage3);

        Glide.with(this).load(URL).placeholder(R.mipmap.ic_launcher).transform(new GlideCircleTransform(this)).into(mImage4);

        Glide.with(this).load(URL).bitmapTransform(new CropCircleTransformation(mContext)).into(mImage4);

       // Glide.with(this).load(URL).bitmapTransform(new RoundedCornersTransformation(mContext,50,0)).into(mImage5);

//        ImageLoaderUtil.getInstance().loadImage(mContext,URL,mImage5);
//        ImageLoaderUtil.getInstance().loadCircleImage(mContext,URL,mImage5);
        ImageLoaderUtil.getInstance().loadRoundImage(mContext,URL,mImage4,100,0);
        ImageLoaderUtil.getInstance().loadCircleImageWithBorder(mContext,URL,mImage5,2,Color.parseColor("#ff00ff"));

    //    Glide.with(this).load(URL).placeholder(R.mipmap.ic_launcher).transform(new GlideCircleTransform(this,2, Color.parseColor("#ff0000"))).into(mImage5);



    }
}
