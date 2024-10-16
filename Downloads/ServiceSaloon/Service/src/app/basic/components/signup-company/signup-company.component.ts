import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Router } from '@angular/router';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from '../../../app.component';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    NzButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

@Component({
  selector: 'app-signup-company',
  standalone: true,
  imports: [],
  templateUrl: './signup-company.component.html',
  styleUrls: ['./signup-company.component.scss']
})
export class SignupCompanyComponent {

  validateForm!: FormGroup;

constructor(private fb: FormBuilder,private authService: AuthService, private notification:NzNotificationService, private router: Router ){}

ngOnInit(){
  this.validateForm = this.fb.group({
    email: [null, [Validators.email, Validators.required]],name: [null, [Validators.required]], 
    address: [null, [Validators.required]], phone: [null],password: [null, [Validators.required]], checkpassword: [null, [Validators.required]]
  })
}

submitForm(){
  this.authService.registerComapny(this.validateForm.value).subscribe(res => {this.notification.success('SUCESS','Signup successful', {nzDuration: 5000});
  this.router.navigateByUrl('/login');
},error => {this.notification.error('ERROR',`${error.error}`, {nzDuration: 5000})

});

}

}
