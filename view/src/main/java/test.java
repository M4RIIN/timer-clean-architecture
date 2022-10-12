import com.exemple.TimerPresenter;
import com.exemple.timer.Timer;
import com.exemple.timer.TimerFactory;

public class test implements TimerPresenter {

    static Timer timer;

    static {
        timer = new TimerFactory().create();
        timer.addObserver(new test());

    }


    public static void main(String[] args) {
        timer.launch();

    }

    @Override
    public void showTime(String time) {
            System.out.println(time);
    }

    @Override
    public void update(Object o) {
        showTime((String) o);
    }
}
