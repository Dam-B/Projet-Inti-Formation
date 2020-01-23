import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class Token{
  constructor(public token:string) {}
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  authenticate(username, password) {
    return this.http.post<Token>('http://localhost:8080/authenticate',{ username, password }).pipe(
      map(tokenData => {
        sessionStorage.setItem('username', username);
        sessionStorage.setItem('token', `Bearer ${tokenData.token}`);
        return tokenData;
      }));
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}