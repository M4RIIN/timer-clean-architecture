package com.exemple;

import com.exemple.timer.TimerObserver;

public interface TimerPresenter extends TimerObserver {
    void showTime(String time);
}
