import { Routes } from '@angular/router';
import { SignupClientComponent } from './basic/components/signup-client/signup-client.component';
import { SignupCompanyComponent } from './basic/components/signup-company/signup-company.component';
import { LoginComponent } from './basic/components/login/login.component';
import { SignupComponent } from './basic/components/signup/signup.component';

export const routes: Routes = [
  { path: 'register_client', component: SignupClientComponent },
  { path: 'register_company', component: SignupCompanyComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: SignupComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Redirecionar para login por padrão
  { path: '**', redirectTo: 'login' } // Rota padrão para 404
];
