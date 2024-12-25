import { PluginListenerHandle, WebPlugin } from '@capacitor/core';

import type { AudioFocusPlugin } from './definitions';

export class AudioFocusWeb extends WebPlugin implements AudioFocusPlugin {
  async requestFocus(): Promise<void> {
    return Promise.resolve();
  };
  async abandonFocus(): Promise<void> {
    return Promise.resolve();
  };
  addListener(
    eventName: 'audioFocusChangeEvent',
    listenerFunc: (obj: {
      type: 'AUDIOFOCUS_GAIN' | 'AUDIOFOCUS_LOSS' | 'AUDIOFOCUS_LOSS_TRANSIENT' | 'AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK',
    }) => void,
  ): Promise<PluginListenerHandle> {
    console.log(eventName);
    console.log(listenerFunc);
    return Promise.resolve(null as any);
  }
}
