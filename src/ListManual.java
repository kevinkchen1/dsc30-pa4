import java.util.*;

/**
 * TODO
 * @author Kevin Chen
 * @since  2/4/24
 */

public class ListManual {

// No style for this file. How poetic :D

    public static ArrayList<String>  listManipulations() {

        ArrayList<String> answers = new ArrayList<>(11);
        // Each index corresponds to the task number. Example is
        // at index 0.

        answers.add("h = h.next;");
        answers.add("h = r;");
        answers.add("r = h;");
        answers.add("t = h.next;");
        answers.add("h.elem = t.elem;");
        answers.add("head.elem = head.next.next.elem;");
        answers.add("head.next.next.next = head");
        answers.add("head.next = head.next.next;");
        answers.add("while ((p!=null) && (r.elem != 'M')) {r = r.next}");  //put your statements in one line, follow the column Structures
        answers.add("h = new Node('A', null); h.next = new Node('B', null); h.next.next = new Node('C', null); h.next.next.next = new Node('D', null)");  //put your statements in one line, follow the column Structures
        answers.add("head.next.next.next = new Node('D', null");
        return answers;
    }
}
