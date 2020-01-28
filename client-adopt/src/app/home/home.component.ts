import { Component, OnInit } from '@angular/core';
import { PetService } from '../shared';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private petService :PetService,) { }

  ngOnInit() {
  }

  
  NbPet(){
    this.petService.countPet;
  }
}
