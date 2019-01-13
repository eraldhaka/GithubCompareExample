package org.procoresample.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class Utils {

    public static void loadImage(Context mContext, String url, ImageView image){
        Glide.with(mContext)
                .load(url)
                .into(image);
    }



    public static SpannableStringBuilder convertString(String value, String firstIndex, String secondIndex){

        SpannableStringBuilder overallValue = new SpannableStringBuilder();

        String[] res = new String[value.length()];

        boolean flag = true; //add characters
        boolean noColor = true; // no color
        int j = 0;

        for (int i = 0; i < value.length(); i++) {

            if(i>0){
                j =i-1;
            }
            res[i] = Character.toString(value.charAt(i));

            if(flag){
                if((res[j]+res[i]).equals(firstIndex)){
                    flag = false;
                }else {
                    if(noColor){
                        if((res[j]+res[i]).equals(secondIndex)){
                            noColor = false;
                            fillColor(res[i],overallValue); //only for + or -
                        }else {
                            overallValue.append(res[i]);
                        }
                    }else {
                        if(res[i].equals("\n")){
                            noColor = true;
                            overallValue.append(res[i]);
                        }else {
                            fillColor(res[i],overallValue); // Strings values until \n
                        }
                    }
                }
            }else {
                if(res[i].equals("\n")){
                    flag = true;
                }
            }
        }
        return overallValue;
    }

    private static void fillColor(String str, SpannableStringBuilder overallValue){
        SpannableString blueSpannable = new SpannableString(str);
        blueSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, str.length(), 0);
        overallValue.append(blueSpannable);
    }



    //This commented method shows formatted String without adding colors

/*    public static StringBuilder convertString(String value, String startIndex, String lastIndex){

        String htmlText = value.replace("a","<font color='#c5c5c5'>a</font>");

        StringBuilder overallValue = new StringBuilder();
        boolean flag = true; //add characters
        int j = 0;

        String[] res = new String[value.length()];

        for (int i = 0; i < value.length(); i++) {

            if(i>0){
                j =i-1;
            }
            res[i] = Character.toString(value.charAt(i));

            if(flag){
                if((res[j]+res[i]).equals(startIndex)){
                    flag = false;
                }else {
                    overallValue.append(res[i]);
                }
            }else {
                if(res[i].equals(lastIndex)){
                    flag = true;
                }
            }
        }
        return overallValue;
    }*/

}
