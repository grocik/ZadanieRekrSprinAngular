export class Numbers {
    constructor(
        public numbers: Number[],
        public order: String
    ){

    }
    getNumbers(){
        return this.numbers
    }
    setNumbers(num: Number[]){
        this.numbers = num;
    }
    setOrder(order: String){
        this.order = order;
    }
}