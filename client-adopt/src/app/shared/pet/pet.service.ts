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
    return this.http.get<Pet[]>(`http://localhost:8080/pets`);
  }
  /**
     * Save a new Book object in the Backend server data base.
     * @param book
     */
    savePet(pet: Pet): Observable<Pet>{
      return this.http.post<Pet>(`http://localhost:8080/pets/addPet`, pet);
  }
  
  /**
   * Update an existing Book object in the Backend server data base.
   * @param book
   */
   updatePet(pet: Pet): Observable<Pet>{
       return this.http.put<Pet>(`http://localhost:8080/pets/updatePet`, pet);
   }
   
   /**
    * Delete an existing Book object in the Backend server data base.
    * @param book
    */
    deletePet(pet: Pet): Observable<string>{
        return this.http.delete<string>(`http://localhost:8080/pets/updatePet`+pet.idpet);
    }
  
  /**
   * Search books by isbn
   * @param isbn
   */
  searchPetByDepartment(departementName: String): Observable<Pet[]>{
      return  this.http.get<Pet[]>(`http://localhost:8080/pets/searchByDepartement`);
  }
  
 /**
  * Search books by title
  * @param title
  */
  searchPetByCategorie(categorieName: string): Observable<Pet[]>{
          return this.http.get<Pet[]>(`http://localhost:8080/pets/searchByCategorie`);
  }
  /**
  * Search books by title
  * @param title
  */
 searchPetById(idpet : number): Observable<Pet>{
  return this.http.get<Pet>(`http://localhost:8080/pets/searchByID`+ idpet);
}
 /**
  * Search books by title
  * @param title
  */
 countPet(nbpet:number): Observable<Pet>{
  return this.http.get<Pet>(`http://localhost:8080/pets/countPet`);
}

}
