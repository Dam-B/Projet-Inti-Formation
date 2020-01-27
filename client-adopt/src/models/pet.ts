import { User } from "./user"
import { from } from "rxjs"
import { Categorie } from "./categorie"
import { Departement } from "./departement";


export class Pet{

    idpet : number;
    categorie :Categorie = new Categorie();
    name : String;
    race : String;
    age: String;
    departement : Departement = new Departement();


    constructor(obj?: any) {
        this.idpet = obj && Number(obj.idpet) || null;
        this.name = obj && obj.name || null;
        this.race = obj && obj.race || null;
        this.age = obj && obj.age || null;
      }
}