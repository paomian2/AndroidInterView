package com.linxz.androidinterview.mvvm;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * @author Linxz
 * 创建日期：2021年07月20日 9:32 AM
 * version：
 * 描述：
 */
public class ImageHelper {

    @BindingAdapter({"imageUrl", "placeHolder","error"})
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable,Drawable errorDrawable){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView);
    }
} 