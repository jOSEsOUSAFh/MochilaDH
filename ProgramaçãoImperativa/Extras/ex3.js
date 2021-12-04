const fizzBuzz = (num1,num2, callBack) => {
    for (i=1; i <= 100; i++){
        if( callBack( i,num1) && callBack( i,num2) ){
            console.log("FizzBuzz")
        }
        else if(callBack( i,num1)){
            console.log("Fizz")
        }
        else if (callBack( i,num2)){
            console.log("Buzz")
        } else{
            console.log(i)
        }
       
    }
}

const resto = (a,b)=>{
    if((a%b) === 0){
      return true;
} else{
    return false
}
}



fizzBuzz(2,5,resto)