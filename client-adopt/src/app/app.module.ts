import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ImageAccueilComponent } from './image-accueil/image-accueil.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

import { BasicAuthHtppInterceptorService} from './shared';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PetsComponent } from './pets/pets.component';
import { FormulaireComponent } from './formulaire/formulaire.component';
import { UpdateFormComponent } from './update-form/update-form.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ImageAccueilComponent,
    LoginComponent,
    RegistrationComponent,
    PetsComponent,
    FormulaireComponent,
    UpdateFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: BasicAuthHtppInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
