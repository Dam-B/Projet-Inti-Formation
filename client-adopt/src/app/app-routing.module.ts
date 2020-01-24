import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PetsComponent } from './pets/pets.component';
import { RegistrationComponent } from './registration/registration.component';
import {FormulaireComponent} from './formulaire/formulaire.component'

const routes: Routes = [
{path: 'home', component: HomeComponent},
{path: 'login', component: LoginComponent},
{path: 'pets', component: PetsComponent},
{path:'', redirectTo:'home', pathMatch:'full'},
{path:'registration', component: RegistrationComponent},
{path:'logout', redirectTo:'home', pathMatch:'full'},
{path:'formuairePet', component : FormulaireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
