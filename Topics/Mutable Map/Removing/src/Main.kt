fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String>
= currentMap.filterNot {  it.value == value  }.toMutableMap()