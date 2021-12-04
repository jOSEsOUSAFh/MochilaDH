/*
    Equipe 3: Vinicius Ocker Fagundes,Fredson Junior, Ana Paula Souza, Lucas Nogueira, Marcela Castro Schiavoni e Pedro Pinheiro 
*/

const FizzBuzz = (num1, num2, multiplo) => {
    for (let i = 1; i <= 100; i++) {
        if(multiplo(num1,i) && multiplo(num2,i)){
            console.log("FizzBuzz");
        }
        else if(multiplo(num1,i)){
            console.log("Fizz");
        }
        else if(multiplo(num2,i)){
            console.log("Buzz");
        }
        else{
            console.log(i);
        }
    }
}

const resto = (x,y) => {
    if((y%x) === 0){
        return true;
    }
    else {
        return false;
    }
}

FizzBuzz(2,5, resto);