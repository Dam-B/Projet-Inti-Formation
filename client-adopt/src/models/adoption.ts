import { Pet } from "./pet"
import { PetService } from "src/app/shared";
import { User } from "./user";
import { Paiement } from "./paiement";


export class Adoption{
    
idadoption : number;
pet : Pet = new Pet();
user : User = new User();
dateDemande : Date;
validationProfile : BinaryType;
validationPaiement : BinaryType;
paiement : Paiement = new Paiement();

}
