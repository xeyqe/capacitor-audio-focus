package com.xeyqe.plugins.audiofocus;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

@CapacitorPlugin(name = "AudioFocus")
public class AudioFocusPlugin extends Plugin {

    private static final String AUDIO_FOCUS_CHANGE_EVENT = "audioFocusChangeEvent";

    private AudioFocus implementation;

    @Override
    public void load() {
        implementation = new AudioFocus(getContext());
    }

    @PluginMethod
    public void requestFocus(PluginCall call) {
        implementation.requestFocus(createCallback(call));
    }

    @PluginMethod
    public void abandonFocus(PluginCall call) {
        implementation.abandonFocus(createCallback(call));
    }

    private AudioFocusResultCallback createCallback(PluginCall call) {
        // Focus events can continue after the original call has completed.
        AtomicBoolean completed = new AtomicBoolean();

        return new AudioFocusResultCallback() {
            @Override
            public void onDone() {
                if (completed.compareAndSet(false, true)) {
                    call.resolve();
                }
            }

            @Override
            public void onError(String errorMessage) {
                if (completed.compareAndSet(false, true)) {
                    call.reject(errorMessage);
                }
            }

            @Override
            public void onAudioFocusChange(JSObject obj) {
                notifyListeners(AUDIO_FOCUS_CHANGE_EVENT, obj);
            }
        };
    }
}
