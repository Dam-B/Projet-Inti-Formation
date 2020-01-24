import { User } from "./user"
import { from } from "rxjs"
import { Categorie } from "./categorie"
import { Departement } from "./departement";


export class Pet{
    idpet : number;
    categorie :Categorie = new Categorie();
    user : User = new User();
    name : String;
    race : String;
    age: String;
    departement : Departement = new Departement();

}