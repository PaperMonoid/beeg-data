// This function iterates over a list of numbers and 
// prints whether the current element is even or odd.
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}

// Declares two lists with values.
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
// Calls the function with the two lists to print
// even and odd values.
listEvens(l)
listEvens(l2)


// This function iterates over a list of numbers and 
// sums them. If the current element is 7, it sums 14
// instead of 7.
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

// Declares a list with values.
val af= List(1,7,7)
// Calls the function to print the sum of values.
println(afortunado(af))


// This function iterates over a list of numbers and 
// does two things: add up each element and substract 
// each element from the total sum. If at any point
// the add up sum is equal to the subtraction, it
// returns true.
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}

// Declares three lists with values.
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)
// Calls the function with the three lists to print
// whether they satisfy this condition.
balance(bl)
balance(bl2)
balance(bl3)


// This function reverses a string of characters
// and checks whether is the same as reversed.
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

// Declares some words.
val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

// Prints whether these words are the same as
// reversed.
println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))