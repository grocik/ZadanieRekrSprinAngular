import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NumbersServiceService } from '../numbers-service.service';

@Component({
  selector: 'app-numbers-input',
  templateUrl: './numbers-input.component.html',
  styleUrls: ['./numbers-input.component.css']
})
export class NumbersInputComponent{
  numbers: number[] = [];
  orderInput: string = ""
  numbersInput: string = "";
  sorted: boolean = false;

  constructor(private numberservice: NumbersServiceService) { }


  public onSubmit(): void {
    this.numbers = this.numbersInput.split(',').map(s => Number(s));
    this.numberservice.bind(this.numbers,this.orderInput);

    if(this.orderInput==="" || this.numbers.length==1){
      console.log(this.numbers.length);
      this.sorted=false;
    }
    else{
      this.sorted=true;
    }

    this.numberservice.getNumbers().subscribe(
      (response: number[]) => {
        this.numbers = response;
      }
    )
  }
  
}