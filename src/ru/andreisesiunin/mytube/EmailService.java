package ru.andreisesiunin.mytube;

public class EmailService implements Notificable {
    @Override
    public void sendNotification(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
