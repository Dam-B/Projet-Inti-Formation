package fr.formation.inti.Iservices;

public interface ISecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
