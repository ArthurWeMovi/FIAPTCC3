

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { NzNotificationModule } from 'ng-zorro-antd/notification';
import { LoginComponent } from './login.component';

@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NzNotificationModule
  ],
  exports: [LoginComponent]
})
export class LoginModule {}
