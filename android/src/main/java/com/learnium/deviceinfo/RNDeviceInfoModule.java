package com.learnium.deviceinfo;

import static android.provider.Settings.Secure.getString;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class RNDeviceInfoModule extends NativeDeviceInfoSpec {

    private final ReactApplicationContext reactContext;

    public RNDeviceInfoModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @SuppressLint("HardwareIds")
    @Override
    protected Map<String, Object> getTypedExportedConstants() {
        String appVersion, appName, uniqueId;
        int buildNumber = 0;
        try {
            appVersion = getPackageInfo().versionName;
            buildNumber = getPackageInfo().versionCode;
            appName = reactContext.getApplicationInfo().loadLabel(reactContext.getPackageManager()).toString();
            uniqueId = getString(reactContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            appVersion = "unknown";
            appName = "unknown";
            uniqueId = "unknown";
        }
        final Map<String, Object> constants = new HashMap<>();

        constants.put("deviceId", Build.BOARD);
        constants.put("bundleId", reactContext.getPackageName());
        constants.put("systemName", "Android");
        constants.put("systemVersion", Build.VERSION.RELEASE);
        constants.put("appVersion", appVersion);
        constants.put("buildNumber", buildNumber);
        constants.put("appName", appName);
        constants.put("brand", Build.BRAND);
        constants.put("model", Build.MODEL);
        constants.put("uniqueId", uniqueId);
        return constants;
    }

    private PackageInfo getPackageInfo() throws Exception {
        return reactContext.getPackageManager().getPackageInfo(reactContext.getPackageName(), 0);
    }

}
