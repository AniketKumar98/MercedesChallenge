import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders,HttpParams  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  url='http://localhost:8080/'
  constructor(private http:HttpClient) { }

  private httpOptions={
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };


  addcomponent(data:any):Observable<any>{
    console.log(data);
    return this.http.post(this.url+'api/store/',data,this.httpOptions);
  }

  getdata():Observable<any>{
    return this.http.get(this.url+'api/get/');
  }

  deletedata(id:any):Observable<any>{
    return this.http.get(this.url+'api/delete/'+"?id="+id);
  }
}
