package com.learnium.deviceinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;

import java.util.HashMap;
import java.util.Map;

public class RNDeviceInfoPackage extends BaseReactPackage {
    @Nullable
    @Override
    public NativeModule getModule(@NonNull String s, @NonNull ReactApplicationContext reactApplicationContext) {
        if (NativeDeviceInfoSpec.NAME.equals(s))
            return new RNDeviceInfoModule(reactApplicationContext);
        return null;
    }

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() {
            @Override
            public Map<String, ReactModuleInfo> getReactModuleInfos() {
                final Map<String, ReactModuleInfo> moduleInfo = new HashMap<>();
                boolean isTurboModule = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
                moduleInfo.put(
                        NativeDeviceInfoSpec.NAME,
                        new ReactModuleInfo(
                                NativeDeviceInfoSpec.NAME,
                                NativeDeviceInfoSpec.NAME,
                                false,
                                false,
                                false,
                                isTurboModule
                        )
                );
                return moduleInfo;
            }
        };
    }
}
