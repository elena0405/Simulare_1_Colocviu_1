package ro.pub.cs.systems.eim.practicaltest01;

public class Constants {
    public static final int NUMBER_OF_CLICKS_THRESHOLD = 10;
    public static final Object SERVICE_STARTED = 1;
    public static final Object SERVICE_STOPPED = 0;
    public static final String PROCESSING_THREAD_TAG =  "[Processing Thread]";
    public static final String BROADCAST_RECEIVER_EXTRA = "ro.pub.cs.systems.eim.practicaltest01.broadcastreceiverextra";

    public static String[] actionTypes = {
            "ro.pub.cs.systems.eim.practicaltest01.arithmeticmean",
            "ro.pub.cs.systems.eim.practicaltest01.geometricmean"
    };
}
