package sort

class QuickSort : SortStrategy {

    override fun sort(input: IntArray) {
        return quickSort(input, 0, input.size - 1)
    }

    private fun quickSort(input: IntArray, l: Int, r: Int) {
        if (l >= r) return

        val v = partition(input, l, r)

        quickSort(input, l, v - 1)
        quickSort(input, v + 1, r)
    }

    /**
     * 右端をpivotにしてpivotより小さい値を左に大きい値を右に集める
     * @return pivotの位置
     */
    private fun partition(input: IntArray, l: Int, r: Int): Int {
        var i = l - 1
        var j = r

        // 右端をpivotにする
        val pivot = input[r]

        // pivotより小さいものを左に、大きいものを右に集める
        while (true) {
            i = proceedLeftCursor(input, i, pivot)
            j = proceedRightCursor(input, i, j, pivot)

            if (i >= j) break

            input.swap(i, j)
        }

        input.swap(i, r)
        return i
    }

    private fun proceedLeftCursor(input: IntArray, cursor: Int, pivot: Int): Int {
        var ret = cursor
        while (input[++ret] < pivot) {}
        return ret
    }

    private fun proceedRightCursor(input: IntArray, stopper: Int, cursor: Int, pivot: Int): Int {
        var ret = cursor
        while (stopper < --ret && pivot < input[ret]) {}
        return ret
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
