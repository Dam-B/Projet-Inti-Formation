import { Departement } from "./departement";
import { User } from "./user";

export class Centre{
    idcentre : number;
    departement : Departement = new Departement();
    user : User = new User();
    name : String;
    tel : String;
    city : String;
    postalCode : String;
}