import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { UserService } from 'src/app/shared/user/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user = new User();

  constructor(private userService: UserService) { }

  ngOnInit() {
  }
  save(){
    this.userService.save(this.user).subscribe(
      (result: User) => {
        if(result.iduser){
            console.log('Save operation correctly done');
        }
     },
     error => {
         console.log('An error occurs when saving the customer data');
     }
    );
  }
}
