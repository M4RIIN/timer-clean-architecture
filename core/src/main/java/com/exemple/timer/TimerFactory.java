package com.exemple.timer;

public class TimerFactory {

   public Timer create(){
        return new TimerMsDisplayText();
    }
}
