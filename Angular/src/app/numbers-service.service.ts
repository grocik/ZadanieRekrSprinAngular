import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Numbers } from './Numbers';

@Injectable({
  providedIn: 'root'
})
export class NumbersServiceService {
  num: Numbers = new Numbers([],"");
  private apiServerUrl ="http://localhost:8080/numbers/sort-command";

  constructor(private http: HttpClient) { }

  bind(num : Number[],order: string){
    this.num.setNumbers(num);
    this.num.setOrder(order);
    
  }

  public getNumbers(): Observable<any> {
    const body = JSON.stringify(this.num);
    console.log(body);
    return this.http.post(this.apiServerUrl,this.num)
  }
}
