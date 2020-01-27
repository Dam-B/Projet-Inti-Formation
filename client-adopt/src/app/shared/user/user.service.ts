import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { User } from 'src/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService { 

  constructor(private http: HttpClient) { }

  save(user: User): Observable<User>{
    console.log(user);
    return this.http.post<User>(`http://localhost:8080/users/addUser`, {username: user.username, password: user.password});
}

}
