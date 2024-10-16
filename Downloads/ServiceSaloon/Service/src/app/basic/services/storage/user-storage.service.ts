import { Injectable } from '@angular/core';

const TOKEN = "s_token";

const USER = "s_user";

@Injectable({
  providedIn: 'root'
})
export class UserStorageService {

  constructor() { }

  private isBrowser(): boolean {
    return typeof window !== 'undefined' && typeof window.localStorage !== 'undefined';
  }

  static isBrowser() {
    return typeof window !== 'undefined' && typeof window.localStorage !== 'undefined';
  }

  public saveToken(token: string):void{
    if (this.isBrowser()) {
      window.localStorage.removeItem(TOKEN);
      window.localStorage.setItem(TOKEN, token);
    }
  }

  static getToken():string | null{
    if (this.isBrowser()) {
      return localStorage.getItem(TOKEN);
    }
    return null;
  }
  

  public saveUser(user: { userId: string; role: string }): void { 
    if (this.isBrowser()) {
      window.localStorage.removeItem(USER);
      window.localStorage.setItem(USER, JSON.stringify(user));
    }
  }

  static getUser():any{
    if (this.isBrowser()) {
      const user = localStorage.getItem(USER);
      return user ? JSON.parse(user) : null;
    }
    return null;
  }

  static getUserId():string{
    const user = this.getUser();
    if(user === null){return '';}
    return user?.userId || '';;
  }

  static getUserRole():string{
    const user = this.getUser();
    if(user === null){return '';}
    return user?.role || '';
  }
 
  static isClientLoggedIn(): boolean{

    if(this.getToken()===null){
      return false;
    }
    const role:string = this.getUserRole();
    return role == "CLIENT";
  }

  static isCompanyLoggedIn(): boolean{

    if(this.getToken()===null){
      return false;
    }
    const role:string = this.getUserRole();
    return role == "COMPANY";
  }

  static signOut():void{
    if (this.isBrowser()) {
      window.localStorage.removeItem(TOKEN);
      window.localStorage.removeItem(USER);
    }
  }
}

