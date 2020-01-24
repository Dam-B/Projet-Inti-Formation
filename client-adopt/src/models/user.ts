import { Pet } from "./pet";
import { Title } from "./title";
import { Departement } from "./departement";
import { Individual } from "./individual";
import { Centre } from "./centre";


export class User{
    iduser : number;
    departement :Departement = new Departement();
    pet : Pet =  new Pet();
    title : Title = new Title();
    username : String;
    password : String;
    dateCreate : Date;
    dateClose : Date;
    individual : Individual = new Individual();
    centre : Centre = new Centre();
    
}