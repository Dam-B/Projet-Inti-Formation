import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { UserService } from 'src/app/shared/user/user.service';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user = new User();

  constructor(private userService: UserService, private router: Router) { }

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
    this.router.navigate(['/login']);
  }
}
