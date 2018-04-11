package com.sadashiv.presenter;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BasePresenter {

    protected EventBus mEventBus;

    public BasePresenter(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public void registerEventBus() {
        if (!(mEventBus.isRegistered(this))) {
            mEventBus.register(this);
            Log.d("EVENT_BUS", "Registered " + this.getClass().getName());
        }
    }

    public void unregisterEventBus() {
        mEventBus.unregister(this);
        Log.d("EVENT_BUS", "Unregistered " + this.getClass().getName());

    }

    @Subscribe
    public void onNullEvent(NullEvent e) {
        // Empty method - this is just to stop green robot complaining because of
        // sub classes not actually subscribing to events.
    }

    private class NullEvent {
    }
}
