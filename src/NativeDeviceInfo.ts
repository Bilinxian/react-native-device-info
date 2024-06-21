import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {EmitterSubscription, NativeEventEmitter, TurboModuleRegistry} from "react-native";
import {Int32, Float} from "react-native/Libraries/Types/CodegenTypes";

export interface Spec extends TurboModule {
  addListener(eventName: string): void;

  removeListeners(count: Int32): void;

  isEmulator(): Promise<boolean>

  getFontScale(): Promise<Float>

  getIpAddress(): Promise<string>

  getMacAddress(): Promise<string>

  getUniqueId(): Promise<string>

}

export default TurboModuleRegistry.get<Spec>('RNDeviceInfo',);
