import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<any[]>(`http://localhost:8080/pets`);
  }
}
