/*
 * Copyright (c) Joseph P. Ferraro
 * <p>
 * This source code is licensed under the MIT license found in the
 * LICENSE file here: https://github.com/joeferraro/react-native-cookies/blob/master/LICENSE.md.
 */

package com.reactnativecommunity.tenjin;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.tenjin.android.TenjinSDK;

public class TenjinModule extends ReactContextBaseJavaModule {

    TenjinModule(ReactApplicationContext context) {
        super(context);

        initTenjin();
        // this.mCookieSyncManager = CookieSyncManager.createInstance(context);
        // this.mCookieManager = CookieManager.getInstance();
        // mCookieManager.setAcceptCookie(true);
    }

    public String getName() {
        return "TenjinRnAndroid";
    }

    TenjinSDK tenjinInstance;
    private void initTenjin() {
        System.out.println("Tenjin done");
        // try {
        //     String apiKey = getString(R.string.TENJIN_KEY);

        //     if(apiKey == "null") {
        //         System.out.println("Tenjin not initialized - no key in gradle.properties");
        //     } else {
        //         tenjinInstance = TenjinSDK.getInstance(this, apiKey);
        //         tenjinInstance.connect();
        //     }
        // }

        // catch (Exception e) {
        //     e.printStackTrace();

        //     System.out.println("Tenjin not initialized - no key in gradle.properties");
        // }
    }

    // public void sendTenjinPurchaseEvent(String sku, String purchaseData, String dataSignature, Double price, String currencyCode) {
    //     if(tenjinInstance != null) {
    //         tenjinInstance.transaction(sku, currencyCode, 1, price, purchaseData, dataSignature);
    //     } else {
    //         System.out.println("Tenjin - can not send purchase event - tenjin not initialized");
    //     }
    // }

    @ReactMethod
    public void sendTenjinPurchaseEvent(String sku, String purchaseData, String dataSignature, Double price, String currencyCode) {
        if(tenjinInstance != null) {
            tenjinInstance.transaction(sku, currencyCode, 1, price, purchaseData, dataSignature);
        } else {
            System.out.println("Tenjin - can not send purchase event - tenjin not initialized");
        }

    // public void sendTenjinPurchaseEvent(String url, ReadableMap cookie, Boolean useWebKit, final Promise promise) {
        // String cookieString = null;
        // try {
        //     cookieString = toRFC6265string(makeHTTPCookieObject(url, cookie));
        // } catch (Exception e) {
        //     promise.reject(e);
        //     return;
        // }

        // if (cookieString == null) {
        //     promise.reject(new Exception(INVALID_COOKIE_VALUES));
        //     return;
        // }

        // addCookies(url, cookieString, promise);
    }

}
