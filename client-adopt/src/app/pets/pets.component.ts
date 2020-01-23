import { Component, OnInit } from '@angular/core';

import { PetService } from '../shared';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  pets: any[] = [];

  constructor(private petService: PetService) { }

  ngOnInit() {
    this.petService.getAll().subscribe(data => this.pets = data);
  }

}
