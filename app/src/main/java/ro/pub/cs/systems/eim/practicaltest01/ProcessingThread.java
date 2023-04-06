package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

    private double aritm_mean;
    private double geom_mean;
    private Context context = null;
    private boolean isRunning = true;
    Random random = new Random();

    public ProcessingThread(Context context, int nr_1, int nr_2) {
        this.context = context;

        this.aritm_mean = (nr_1 + nr_2) / 2;
        this.geom_mean = Math.sqrt(nr_1 * nr_2);
    }

    @Override
    public void run() {
        System.out.println("Process started!");

        while (isRunning) {
            sendMessage();
            sleep();
        }

        System.out.println("Process stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();

        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                new Date(System.currentTimeMillis()) + " " + aritm_mean + " " + geom_mean);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
