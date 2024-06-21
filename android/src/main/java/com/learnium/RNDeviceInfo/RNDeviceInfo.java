package com.learnium.RNDeviceInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;

import java.util.HashMap;
import java.util.Map;

public class RNDeviceInfo extends TurboReactPackage {

    @Nullable
    @Override
    public NativeModule getModule(@NonNull String s, @NonNull ReactApplicationContext reactApplicationContext) {
        if (RNDeviceModule.NAME.equals(s))
            return new RNDeviceModule(reactApplicationContext);
        return null;
    }

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return () -> {
            final Map<String, ReactModuleInfo> moduleInfo = new HashMap<>();
            boolean isTurboModule = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
            moduleInfo.put(
                    RNDeviceModule.NAME,
                    new ReactModuleInfo(
                            RNDeviceModule.NAME,
                            RNDeviceModule.NAME,
                            false, // canOverrideExistingModule
                            false, // needsEagerInit
                            true, // hasConstants
                            false, // isCxxModule
                            isTurboModule // isTurboModule
                    ));
            return moduleInfo;
        };
    }

}
