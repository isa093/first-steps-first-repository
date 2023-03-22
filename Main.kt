package parking

fun create(n: Int) = MutableList(n) {"free"}

fun status(list: MutableList<String>){
    if (list.isEmpty()) return println("Sorry, a parking lot has not been created.")

    if (list.all(predicate = {it == "free"})) {
        println("Parking lot is empty.")
    }
    else {
        var n = 0
        for (i in list) {
            if (list[n] != "free")
                println(list[n])
            n++
        }
    }
}

fun park(input: List<String>, spots: MutableList<String>){
    if (spots.isEmpty()) return println("Sorry, a parking lot has not been created.")

    val color = input[2]
    var checked = 0
    while(checked<20){

        if(spots[checked] == "free"){
            println("$color car parked in spot ${checked+1}.")
            spots[checked] = "${checked+1} ${input[1]} ${input[2]}"
            break
        }
        checked++
        if(spots.last() != "free"){
            println("Sorry, the parking lot is full.")
            break
        }
    }
}

fun leave(input: List<String>, spots: MutableList<String>){
    if (spots.isEmpty()) return println("Sorry, a parking lot has not been created.")

    val n = input[1].toInt()
    spots[n-1] = "free"
    println("Spot $n is free.")
}

fun regByColor(color: String, spots: MutableList<String>){
    if (spots.isEmpty()) return println("Sorry, a parking lot has not been created.")

    val filteredSpot = spots.filter {
        val split = it.split(" ")
        split.size >= 3 && split[2].lowercase() == color.lowercase()
    }
    if (filteredSpot.isEmpty()) return println("No cars with color $color were found.")
    val regNums = filteredSpot.map { it.split(" ")[1] }
    for (item in regNums) {
        print(item)
        if (regNums.indexOf(item) != regNums.lastIndex)
            print(", ")
        else println()
    }
}

fun spotByColor(color: String, spots: MutableList<String>) {
    if (spots.isEmpty()) return println("Sorry, a parking lot has not been created.")

    val filteredSpot = spots.filter {
        val split = it.split(" ")
        split.size >= 3 && split[2].lowercase() == color.lowercase()
    }
    if (filteredSpot.isEmpty()) return println("No cars with color $color were found.")
    val spotNums = filteredSpot.map { it.split(" ")[0] }
    for (item in spotNums) {
        print(item)
        if (spotNums.indexOf(item) != spotNums.lastIndex)
            print(", ")
        else println()
    }
}

fun spotByReg(reg_num: String, spots: MutableList<String>) {
    if (spots.isEmpty()) return println("Sorry, a parking lot has not been created.")

    val filteredSpot = spots.filter {
        val split = it.split(" ")
        split.size >= 3 && split[1].lowercase() == reg_num.lowercase()
    }
    if (filteredSpot.isEmpty()) return println("No cars with registration number $reg_num were found.")
    val spotNums = filteredSpot.map { it.split(" ")[0] }
    for (item in spotNums) {
        print(item)
        if (spotNums.indexOf(item) != spotNums.lastIndex)
            print(", ")
        else println()
    }
}


fun userInput(){
    //принимаем запрос юзера
    var input = readln().split(" ").toList()
    //определяем наш спот
    var spots: MutableList<String> = mutableListOf()

    while(input[0]!="exit"){
        when(input[0]) {
            "create" -> {
                spots = create(input[1].toInt())
                println("Created a parking lot with ${input[1]} spots.") }
            "status" -> status(spots)
            "park" -> park(input, spots)
            "leave" -> leave(input, spots)
            "reg_by_color" -> regByColor(input[1], spots)
            "spot_by_color" -> spotByColor(input[1],spots)
            "spot_by_reg" -> spotByReg(input[1], spots)
        }
        input = readln().split(" ").toList()
    }
}


fun main() {
    userInput()
}