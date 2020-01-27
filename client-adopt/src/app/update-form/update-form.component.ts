import { Component, OnInit } from '@angular/core';
import { Pet } from 'src/models/pet';
import { PetService } from 'src/app/shared/pet/pet.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-edit',
  templateUrl: './update-form.component.html',
  styleUrls: ['./update-form.component.css']
})
export class UpdateFormComponent implements OnInit {
  editName: String;
  editRace: String;
  editAges: String;
  idpet: number;
  sub: Subscription;
  pet:Pet;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private petService: PetService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const idpet = + params['idpet']; // (+) converts string 'id' to a number
      this.petService.searchPetById(idpet).subscribe(pet => {
        if (pet) {
          this.editName = pet.name;
          this.editRace = pet.race;
          this.editAges = pet.age;
          this.pet = new Pet;
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
    this.router.navigate(['/search']);
  }

  save() {
    this.pet.name = this.editName;
    this.pet.race = this.editRace;
    this.pet.age = this.editAges;
    this.petService.savePet(this.pet);
    this.gotoList();
  }

  gotoList() {
    if (this.pet) {
      this.router.navigate(['/search', {term: this.pet.name} ]);
    } else {
      this.router.navigate(['/search']);
    }
  }
}
