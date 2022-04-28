/*
 * H28年春
 */
package jp.Fe;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todoList = new ArrayList<Todo>();

    public void add(Todo todo) {
        if (!todoList.contains(todo)) {     // b
            todoList.add(new Todo(todo));
        }
    }

    public void update(Todo todo) {
        int index = todoList.indexOf(todo);
        if (index != -1) {      // c
            todoList.set(index, todo);
        }
    }

    public List<Todo> select(Condition... conditions) {
        List<Todo> result = new ArrayList<Todo>();
        for (Todo todo : todoList) {
            boolean selected = true;    // d
            for (Condition condition : conditions) {
                selected = condition.test(todo);
                if (!selected) break;
            }
            if (selected) {
                result.add(new Todo(todo));
            }
        }
        return result;
    }
}
