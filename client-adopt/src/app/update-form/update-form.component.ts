import { Component, OnInit } from '@angular/core';
import { Pet } from 'src/models/pet';
import { PetService } from 'src/app/shared/pet/pet.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-edit',
  templateUrl: './update-form.component.html',
  styleUrls: ['./update-form.component.css']
})
export class UpdateFormComponent implements OnInit {
  petname: String;
  sub: Subscription;
  pet:Pet = new Pet();
  registerForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private petService: PetService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      race: ['', Validators.required],
      Age: [0, [Validators.required]],
  });
    this.sub = this.route.params.subscribe(params => {
      const idpet = + params['idpet']; // (+) converts string 'id' to a number
      this.petService.searchPetById(idpet).subscribe(pet => {
        if (pet) {
          this.petname = pet.name;
          
          this.pet = new Pet(pet);
        } else {
          this.gotoList();
        }
      });
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  cancel() {
    this.router.navigate(['/pets']);
  }

  save() {
    this.petService.updatePet(this.pet).subscribe(data => {
      console.log(this.pet);
      this.gotoList();
    })
  }

  gotoList() {
    if (this.pet) {
      this.router.navigate(['/pets' ]);
    } else {
      this.router.navigate(['/pets']);
    }
  }
}
