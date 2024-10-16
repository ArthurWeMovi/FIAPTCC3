// ng-zorro.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

// Importação de todos os módulos do NG-Zorro
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { BrowserModule } from '@angular/platform-browser';
// Adicione mais módulos conforme a necessidade
// Você pode continuar importando todos os módulos que desejar utilizar

@NgModule({
  imports: [
    CommonModule,
    NzButtonModule,
    NzGridModule,
    NzInputModule,
    NzFormModule,
    NzIconModule,
    NzTableModule,
    NzLayoutModule
    // Adicione mais módulos aqui
  ],
  exports: [
    NzButtonModule,
    NzGridModule,
    NzInputModule,
    NzFormModule,
    NzIconModule,
    NzTableModule,
    NzLayoutModule,
    CommonModule
  ]
})
export class NgZorroModule { }
