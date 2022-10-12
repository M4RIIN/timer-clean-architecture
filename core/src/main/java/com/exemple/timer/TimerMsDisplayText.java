package com.exemple.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

 class TimerMsDisplayText extends TimerMs {


    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    @Override
    public Object executeFunction(Object... params) {
        return  format.format(new Date());
    }
}
