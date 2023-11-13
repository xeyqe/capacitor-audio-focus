import { WebPlugin } from '@capacitor/core';

import type { AudioFocusPlugin } from './definitions';

export class AudioFocusWeb extends WebPlugin implements AudioFocusPlugin {
  async requestFocus(): Promise<void> {
    return Promise.resolve();
  };
  async abandonFocus(): Promise<void> {
    return Promise.resolve();
  };
}
