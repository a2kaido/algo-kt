package sort

fun main() {
    val input = intArrayOf(100, 3, 2, 4, 5, 10, 1)

    val sort: SortStrategy = QuickSort()

    sort.sort(input)
    println(input.joinToString())
}
