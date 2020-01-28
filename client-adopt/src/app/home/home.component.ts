import { Component, OnInit } from '@angular/core';
import { PetService } from '../shared';
import { Observable } from "rxjs";
import { count } from 'rxjs/operators';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public numberofpet : number = 0;

  constructor(private petService :PetService,) { }

  ngOnInit() {
    this.petService.countPet().subscribe(data => this.numberofpet = data);
    console.log(this.numberofpet);
  }


}
