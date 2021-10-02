package co.com.sofka.easy_fly.usecase;

public interface SendEmailService {
    Boolean sendEmail(String emailDestination, String subject, String message);
}
