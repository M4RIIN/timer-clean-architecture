package com.exemple.timer;

public interface Timer {
    void launch(Object... params);

    void stop();

    void addObserver(TimerObserver timerObserver);
}
