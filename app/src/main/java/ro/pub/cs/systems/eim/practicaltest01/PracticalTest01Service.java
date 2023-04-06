package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Service extends Service {
    private ProcessingThread processingThread = null;

    public PracticalTest01Service() {
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        int first_number = intent.getIntExtra("first_edit_text", -1);
        int second_number = intent.getIntExtra("second_edit_text", -1);

        processingThread = new ProcessingThread(this, first_number, second_number);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}