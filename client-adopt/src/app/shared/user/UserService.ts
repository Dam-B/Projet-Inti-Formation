import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { User } from 'src/models/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }
  getAll() {
    return this.http.get<User[]>(`http://localhost:8080/users`);
  }
  /**
     * Save a new Book object in the Backend server data base.
     * @param book
     */
  saveUser(user: User): Observable<User> {
    return this.http.post<User>(`http://localhost:8080/users/addUser`, user);
  }
  /**
   * Update an existing Book object in the Backend server data base.
   * @param book
   */
  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`http://localhost:8080/users/updateUser`, user);
  }
  /**
   * Delete an existing Book object in the Backend server data base.
   * @param book
   */
  deleteUser(iduser: number): Observable<string> {
    return this.http.delete<string>(`http://localhost:8080/users/deleteUser/` + iduser);
  }
  /**
   * Search books by isbn
   * @param isbn
   */
  searchUserByDepartment(departementName: String): Observable<User[]> {
    return this.http.get<User[]>(`http://localhost:8080/users/searchByDepartement/` + departementName);
  }
  /**
   * Search books by title
   * @param title
   */
  searchUserByCategorie(categorieName: string): Observable<User[]> {
    return this.http.get<User[]>(`http://localhost:8080/users/searchByCategorie/` + categorieName);
  }
  /**
  * Search books by title
  * @param title
  */
  searchPetById(iduser: number): Observable<User> {
    return this.http.get<User>(`http://localhost:8080/pets/searchById/` + iduser);
  }
  /**
   * Search books by title
   * @param title
   */
  countPet(nbpet: number): Observable<User> {
    return this.http.get<User>(`http://localhost:8080/users/countUser`);
  }
}
