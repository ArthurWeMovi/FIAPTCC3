import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DemoNgZorroAntdModule } from './DemoNgZorroAntdModule';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { en_US, NZ_I18N } from 'ng-zorro-antd/i18n';
import { NgZorroModule } from './ng-zorro.module';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { SignupClientComponent } from './basic/components/signup-client/signup-client.component';
import { SignupCompanyComponent } from './basic/components/signup-company/signup-company.component';
import { LoginComponent } from './basic/components/login/login.component';
import { SignupComponent } from './basic/components/signup/signup.component';


const routes: Routes = [
  { path: 'register_client', component: SignupClientComponent},
  { path: 'register_company', component: SignupCompanyComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: SignupComponent},
  { path: 'company', loadChildren: () => import('./company/company.module').then(m => m.CompanyModule) },
  { path: 'client', loadChildren: () => import('./client/client.module').then(m => m.ClientModule) },
  { path: '**', redirectTo: 'login', pathMatch: 'full' } 
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClient,
    BrowserAnimationsModule,
    DemoNgZorroAntdModule,
    ReactiveFormsModule,
    NgZorroModule,
    NzLayoutModule,
    RouterModule.forRoot(routes) 

  ],
  exports: [RouterModule],
  providers:[
    
    {provide: NZ_I18N, useValue: en_US}
  
  ], 
})
export class AppRoutingModule { }
