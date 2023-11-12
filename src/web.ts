import { WebPlugin } from '@capacitor/core';

import type { AudioFocusPlugin } from './definitions';

export class AudioFocusWeb extends WebPlugin implements AudioFocusPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
