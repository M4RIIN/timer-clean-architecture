package com.exemple.timer;


import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

abstract class TimerMs implements Timer {
    private int delay = 1;
    private int period = 1;
    private Object value;
    private List<TimerObserver> timerObserverList = new ArrayList<>();
    private java.util.Timer timer = new java.util.Timer();
    private boolean isStarted = false;
    @Override
    public void launch(Object... params){
        this.stop();
        if(!isStarted){
            timer.schedule(new TimerTask(){
                @Override
                public void run() {
                    isStarted = true;
                    Object result = executeFunction(params);
                    for (TimerObserver obs: timerObserverList
                    ) {
                        obs.update(result);
                    }
                }
            },delay,period);
        }
    }

    @Override
    public void stop() {
        if(isStarted){
            timer.cancel();
            timer.purge();
            timer = new java.util.Timer();
            isStarted = false;
        }

    }

    protected abstract Object executeFunction(Object... params);

    @Override
    public void addObserver(TimerObserver timerObserver){
        timerObserverList.add(timerObserver);
    }


}
