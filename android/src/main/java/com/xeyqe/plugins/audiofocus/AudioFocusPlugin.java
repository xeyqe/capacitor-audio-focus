package com.xeyqe.plugins.audiofocus;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "AudioFocus")
public class AudioFocusPlugin extends Plugin {

    private AudioFocus implementation;
    @Override
    public void load() {
        implementation = new AudioFocus(getContext());
    }

    @PluginMethod
    public void requestFocus(PluginCall call) {

        AudioFocusResultCallback callback = new AudioFocusResultCallback() {
            @Override
            public void onDone() {
                call.resolve();
            }

            @Override
            public void onError(String errorMessage) {
                call.reject(errorMessage);
            }

            @Override
            public void onAudioFocusChange(JSObject obj) {
                notifyListeners("audioFocusChangeEvent", obj);
            }
        };

        implementation.requestFocus(callback);
    }

    @PluginMethod
    public void abandonFocus(PluginCall call) {
        AudioFocusResultCallback callback = new AudioFocusResultCallback() {
            @Override
            public void onDone() {
                call.resolve();
            }

            @Override
            public void onError(String errorMessage) {
                call.reject(errorMessage);
            }

            @Override
            public void onAudioFocusChange(JSObject obj) {
                notifyListeners("audioFocusChangeEvent", obj);
            }
        };

        implementation.abandonFocus(callback);
    }
}
