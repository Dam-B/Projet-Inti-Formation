import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Pet } from 'src/models/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<any[]>(`http://localhost:8080/pets`);
  }
}
