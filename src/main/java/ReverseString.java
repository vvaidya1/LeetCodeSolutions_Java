//O(n) time | O(1) space
class ReverseString {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
    }

    void swap(char[] array, int i, int j) {
        char ch = array[i];
        array[i] = array[j];
        array[j] = ch;
    }
}