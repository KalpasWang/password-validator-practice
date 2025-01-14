package org.practice;

public class UserRegistration {
    public void registerUser(String password, String confirmPassword) {
        ValidationLogger logger = new ValidationLogger();
        try (logger) {
            PasswordValidator validator = new PasswordValidator();
            validator.validatePassword(password, confirmPassword);
            logger.logSuccess();
        } catch (WeakPasswordException | PasswordMismatchException e) {
            logger.logFailure(e.getMessage());
        }
    }
}
