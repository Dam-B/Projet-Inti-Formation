package fr.formation.inti.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
