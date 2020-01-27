import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";
import { Pet } from 'src/models/pet';
import { PetService } from 'src/app/shared/pet/pet.service';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-formulaire',
  templateUrl: './formulaire.component.html',
  styleUrls: ['./formulaire.component.css']
})
export class FormulaireComponent implements OnInit {
    public types = [ 'Name', 'Race','Age'];
    public name: string;
    public race: string;
    public age:number;
    public displayType: string = 'Email'
    public headsTab = ['NAME', 'RACE', 'AGE'];
    public isNoResult: boolean = true;
    public isFormSubmitted: boolean = false;
    public actionButton: string = 'Save';
    public titleSaveOrUpdate: string = 'Add New Customer Form';
    public messageModal: string;
    public displayMessageModal: boolean = false;
    
    public pet = new Pet();
    public searchPetResult: Pet[] = [];
  categorie: string;
    
  constructor(private petService: PetService, private spinner: NgxSpinnerService) { }

  ngOnInit() {
  }
  /**
  * Method that save in the Backend server,
  *  a new customer data retreived from the form
  * @param addCustomerForm
  */
 saveOrUpdatePet(addPetForm: NgForm){
  this.displayMessageModal = false;
  console.log(addPetForm)
  if(!addPetForm.valid){
    console.log("ùa")
    return this.buildMessageModal('Error in the form');
  }
  if(this.actionButton && this.actionButton === 'Save'){
    console.log("gdrga")
      this.saveNewPet(this.pet);
  }else if(this.actionButton && this.actionButton === 'Update'){
    console.log("ùasfefzef")
      this.updatePet(this.pet);
  }else {
    console.log("EH BAH NAN")
  }
  
  this.titleSaveOrUpdate = 'Add New Customer Form';
  this.actionButton = 'Save';
}
  customer(pet: Pet) {
    throw new Error("Method not implemented.");
  }

  

/**
* Save new customer
* @param customer
*/
saveNewPet(pet : Pet){
  this.spinner.show();
  this.petService.savePet(pet).subscribe(
          (result: Pet) => {
             if(result.idpet){
                 this.spinner.hide();
                 this.buildMessageModal('Save operation correctly done');
             }
          },
          error => {
              this.spinner.hide();
              this.buildMessageModal('An error occurs when saving the customer data');
          }
  );
}

/**
* Update an existing customer
* @param customer
*/
updatePet(pet : Pet){
   this.spinner.show();
   this.petService.updatePet(pet).subscribe(
           (result: Pet) => {
              if(result.idpet){
                  this.updateResearchPetTab(pet);
                  this.spinner.hide();
                  this.buildMessageModal('Update operation correctly done');
              }
           },
           error => {
            this.spinner.hide();
            this.buildMessageModal('An error occurs when updating the customer data');
           }
   );
}

/**
* Update in the list tab, the customer that has been updated
* @param customer 
*/
updateResearchPetTab(pet: Pet){
    let index : number = 0; 
    if(this.searchPetResult && this.searchPetResult.length > 0){
        this.searchPetResult.forEach(element => {
            if(element.idpet == pet.idpet){
                this.searchPetResult.splice(index, 1, pet);
        
            }
            index++;
        });
    }
}



/**
* Set the selected customer as the customer to be updated
* @param customer
*/
setUpdateCustomer(pet: Pet){
   this.titleSaveOrUpdate = 'Update Customer Form';
   this.actionButton = 'Update';
   this.pet = Object.assign({}, pet);
}

/**
* Erase all data from this NgForm.
* @param addCustomerForm
*/
clearForm(addPetForm: NgForm){
  addPetForm.form.reset(); 
  this.displayMessageModal = false;
}

/**
* Search customers by title or by isbn
* @param searchCustomerForm
*/
searchPetByType(searchPetResult){
  this.spinner.show();
  this.displayMessageModal = false;
  if(!searchPetResult.valid){
    this.buildMessageModal('Error in the form');
  }
  if(this.displayType === 'Name'){
      this.searchPetResult = [];
      this.petService.searchPetById(this.pet).subscribe(
              result => {
                  if(result && result != null){
                      this.searchPetResult.push(result);
                      this.isNoResult = false;
                      this.spinner.hide();
                      return;
                   }
                   this.isNoResult = true;
                   this.spinner.hide();
              },
              error => {
                  this.spinner.hide();
                  this.buildMessageModal('An error occurs when searching the customer data');
              }
      );
  } else if(this.displayType === 'Last Name'){
      this.searchPetResult = [];
      this.petService.searchPetByCategorie(this.categorie).subscribe(
              result => {
                  if(result && result != null){
                      this.searchPetResult = result;
                      this.isNoResult = false;
                      this.spinner.hide();
                      return;
                  }
                  this.isNoResult = true;
                  this.spinner.hide();
              },
              error => {
                  this.spinner.hide();
                  this.buildMessageModal('An error occurs when searching the customer data');
              }
      );
  }
  this.isFormSubmitted = searchPetResult.submitted;
}
  email(email: any) {
    throw new Error("Method not implemented.");
  }
  lastName(lastName: any) {
    throw new Error("Method not implemented.");
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
