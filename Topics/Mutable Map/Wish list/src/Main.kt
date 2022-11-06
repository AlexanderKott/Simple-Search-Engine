fun makeMyWishList(wishList: Map<String, Int>, limit: Int): MutableMap<String, Int> =
    wishList.filter { it.value <= limit }.toMutableMap()