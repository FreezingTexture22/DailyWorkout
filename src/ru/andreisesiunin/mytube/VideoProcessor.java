package ru.andreisesiunin.mytube;

public class VideoProcessor {
    private Encodable encoder;
    private Databasable database;
    private Notificable notification;

    public VideoProcessor(Encodable encoder, Databasable database, Notificable notification) {
        this.encoder = encoder;
        this.database = database;
        this.notification = notification;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notification.sendNotification(video.getUser());
    }
}

