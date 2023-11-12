import { registerPlugin } from '@capacitor/core';

import type { AudioFocusPlugin } from './definitions';

const AudioFocus = registerPlugin<AudioFocusPlugin>('AudioFocus', {
  web: () => import('./web').then(m => new m.AudioFocusWeb()),
});

export * from './definitions';
export { AudioFocus };
