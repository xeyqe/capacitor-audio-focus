import { PluginListenerHandle } from "@capacitor/core";

export interface AudioFocusPlugin {
  requestFocus(): Promise<void>;
  abandonFocus(): Promise<void>;
  addListener(
    eventName: 'audioFocusChangeEvent',
    listenerFunc: (obj: {
      type: 'AUDIOFOCUS_GAIN' | 'AUDIOFOCUS_LOSS' | 'AUDIOFOCUS_LOSS_TRANSIENT' | 'AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK',
    }) => void,
  ): Promise<PluginListenerHandle>;

}
