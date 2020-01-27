import { Component, OnInit } from '@angular/core';

import { PetService } from '../shared';
import { NgForm } from "@angular/forms";
import { Pet } from 'src/models/pet';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {
  public isNoResult: boolean = true;
  public messageModal: string;
  public displayMessageModal: boolean = false;
  
  public pet = new Pet();
  public searchPetResult: Pet[] = [];
categorie: string;
  pets: any[] = [];

  constructor(private petService: PetService, private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.petService.getAll().subscribe(data => this.pets = data);
  }

  /**
* Delete an existing customer
* @param customer
*/
deletePet(pet: Pet){
  this.spinner.show();
  this.displayMessageModal = true;
  this.petService.deletePet(pet).subscribe(
          result => {
              for( var i = 0; i < this.searchPetResult.length; i++){ 
                  if ( this.searchPetResult[i].idpet === pet.idpet) {
                      this.searchPetResult.splice(i, 1); 
                  }
              }
              this.spinner.hide();
              this.buildMessageModal('End of delete operation');
              if(this.searchPetResult.length == 0){
                  this.isNoResult = true;
              }
          });
}
/**
* Construit le message à afficher suite à une action utilisateur.
* @param msg 
*/
buildMessageModal(msg: string){
  this.messageModal = msg;
  this.displayMessageModal = true;
  }

}
