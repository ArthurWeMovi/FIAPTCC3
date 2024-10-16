import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { UserStorageService } from '../storage/user-storage.service';

const BASIC_URL = "http://localhost:8050/";
export const AUTH_HEADER = 'authorization';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private userStorageService: UserStorageService) { }

  registerClient(signupRequestDTO:any):Observable<any>{
    return this.http.post(BASIC_URL + "client/sign-up",signupRequestDTO);
  }

  registerComapny(signupRequestDTO:any):Observable<any>{
    return this.http.post(BASIC_URL + "company/sign-up",signupRequestDTO);
  }

  login(userName:string, password:string){
    return this.http.post(BASIC_URL + "authenticate", {userName, password}, {observe: 'response'})
    .pipe(
       map((res: HttpResponse<any>)=> {
        console.log(res.body)
        this.userStorageService.saveUser(res.body);
        const tokenLength = res.headers.get(AUTH_HEADER)?.length;
        const bearerToken = res.headers.get(AUTH_HEADER)?.substring(7, tokenLength);
        console.log(bearerToken);
        this.userStorageService.saveToken(res.body);
        return res;
       })
    );
  }
}