package com.eakonovalov.pattern.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Waine
 * @version 1.0
 * @created 20-Feb-2017 10:38:58
 */
public class Caretaker {

    private Deque<Memento> history = new ArrayDeque<>();

    public void save(Originator originator) {
        history.add(originator.save());
    }

    public void undo(Originator originator) {
        Memento memento = history.pollLast();
        if (memento != null) {
            originator.restore(memento);
        }
    }

}
