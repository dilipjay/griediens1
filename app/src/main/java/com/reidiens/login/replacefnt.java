package com.reidiens.login;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by admin on 10/2/2015.
 * Default font change
 */
public class replacefnt {

    public static void replaceDefaultFont(Context context, String nameofFontBeignReplaced, String nameOfFontBeingreplaced, String nameOfFontInAsset) {

        Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), nameOfFontInAsset);
        replacefont(nameofFontBeignReplaced, customFontTypeface);
    }

    private static void replacefont(String nameofFontBeignReplaced, Typeface customFontTypeface) {
        try {
            Field myfield = Typeface.class.getDeclaredField(nameofFontBeignReplaced);
            myfield.setAccessible(true);
            myfield.set(null, customFontTypeface);
        } catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static void replaceDefaultFont(personalinfo personalinfo, String aDefault, String s) {

    }
}
