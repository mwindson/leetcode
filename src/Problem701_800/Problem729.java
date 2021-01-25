package Problem701_800;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/12/1.
 * https://leetcode.com/problems/my-calendar-i/description/
 */
public class Problem729 {
    static class MyCalendar {
        class Book {
            int key;
            int value;

            Book(int k, int v) {
                key = k;
                value = v;
            }
        }

        List<Book> books;

        public MyCalendar() {
            books = new ArrayList<>();
        }

        // start <= x < end
        public boolean book(int start, int end) {
            if (start > end) return false;
            if (books.isEmpty()) {
                books.add(new Book(start, end));
            } else {
                for (Book p : books) {
                    if (!(end <= p.key || start >= p.value)) {
                        return false;
                    }
                }
                books.add(new Book(start, end));
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));
        System.out.println(obj.book(30, 40));
        System.out.println(obj.book(5, 10));
        System.out.println(obj.book(4, 60));
    }

}
