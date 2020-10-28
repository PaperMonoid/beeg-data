var list = List("red", "white", "black")
print(list)

list = list ++ List("green", "yellow", "blue", "orange", "pearl")
print(list)

print(list slice(3, 6))

val values = Array.range(1, 10000, 5)
print(values)

print(List(1,3,3,4,6,7,3,7).toSet)

val names = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", 27))
print(names)

print(names.keys)

names.put("Miguel", 23)
print(names)