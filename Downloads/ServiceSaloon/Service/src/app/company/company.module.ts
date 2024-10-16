import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { Routes, RouterModule } from "@angular/router";
import { AllAdsComponent } from "../basic/all-ads/all-ads.component";
import { CreateAdComponent } from "../basic/create-ad/create-ad.component";
import { UpdateAdComponent } from "../basic/update-ad/update-ad.component";
import { DemoNgZorroAntdModule } from "../DemoNgZorroAntdModule";
import { NgZorroModule } from "../ng-zorro.module";
import { CompanyDetailComponent } from "./company-detail.component";
import { CompanyDashboardComponent } from "./pages/company-dashboard/company-dashboard.component";


const routes: Routes = [
  {path: '', component: CompanyDetailComponent },
  {path: 'dashboard', component: CompanyDashboardComponent},
  {path: 'ad', component: CreateAdComponent},
  {path: 'ads', component: AllAdsComponent},
  {path: 'update/:id', component: UpdateAdComponent},
];

@NgModule({
  declarations: [
    CompanyDetailComponent,
    CompanyDashboardComponent,
CreateAdComponent
  ],
  imports: [
    CommonModule,
    CompanyDetailComponent,
    DemoNgZorroAntdModule,
    ReactiveFormsModule,
    NgZorroModule
  ],
  exports: [RouterModule]
})
export class CompanyModule { }
