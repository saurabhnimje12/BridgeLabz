package org.example;

@FunctionalInterface
public interface UserService {
    public boolean checkValidation(String input) throws UserHandleException;
}
