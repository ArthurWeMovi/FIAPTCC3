import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgZorroModule } from './ng-zorro.module';
import { UserStorageService } from './basic/services/storage/user-storage.service';
import { DemoNgZorroAntdModule } from './DemoNgZorroAntdModule';
import { routes } from './app.routes';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, NgZorroModule, DemoNgZorroAntdModule, ReactiveFormsModule,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Service';

  isClientLoggedIn: boolean = UserStorageService.isClientLoggedIn();
  isCompanyLoggedIn: boolean = UserStorageService.isCompanyLoggedIn();

  constructor(private router: Router ){}

  ngOnInit(){
    this.router.events.subscribe(event => {
      this.isClientLoggedIn = UserStorageService.isClientLoggedIn();
      this.isCompanyLoggedIn = UserStorageService.isCompanyLoggedIn();
    })
  }

  logout(){
    UserStorageService.signOut();
    this.router.navigateByUrl('login');
  }
}
