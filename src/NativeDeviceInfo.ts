import {TurboModule, TurboModuleRegistry} from "react-native";
import {Int32} from "react-native/Libraries/Types/CodegenTypes";

export interface Spec extends TurboModule {
    readonly getConstants: () => {
        deviceId: string
        bundleId: string
        systemName: string
        systemVersion: string
        appVersion: string
        buildNumber: Int32
        appName: string
        model: string
        brand: string
        uniqueId: string
    };
}

export default TurboModuleRegistry.getEnforcing<Spec>("RNDeviceInfo")
