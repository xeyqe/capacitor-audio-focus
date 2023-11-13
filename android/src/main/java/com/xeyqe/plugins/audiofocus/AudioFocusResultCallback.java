package com.xeyqe.plugins.audiofocus;

import com.getcapacitor.JSObject;

public interface AudioFocusResultCallback {
    void onDone();
    void onError(String errorMessage);
    void onAudioFocusChange(JSObject obj);
}
