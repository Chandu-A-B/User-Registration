import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  public loginUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>('http://localhost:8082/login',user);
  }
  
  public registerUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>('http://localhost:8080/api/v1/kafka/add',user);
  }

  public getUserByIdFromRemote(name:string):Observable<any>{
    return this.http.get<any>('http://localhost:8082/user/'+name);
  }

  public getAllUsersFromRemote():Observable<any>{
    return this.http.get<any>('http://localhost:8082/all');
  }

  public updateUserFromRemote(userName:string,user:User):Observable<any>{
    return this.http.patch<any>('http://localhost:8082/edit/' +userName, user);
  }

  public deleteUserFromRemote(name:string):Observable<any>{
    return this.http.delete('http://localhost:8082/del/'+name);
  }

  dologout(){
    localStorage.removeItem("role")
    localStorage.removeItem("id")
    sessionStorage.removeItem("role")
    sessionStorage.removeItem("id")
  }

  saveCurrUsername(userName:string){
    localStorage.setItem("currUser",userName);
  }

}
