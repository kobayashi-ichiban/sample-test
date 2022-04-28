package jp.Fe;

public class TodoListTester {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add(new Todo("メール送信", "201604181500", Todo.Priority.HIGH));
        list.add(new Todo("ホテル予約", "20160420", Todo.Priority.LOW));
        list.add(new Todo("チケット購入", "20160430", Todo.Priority.MIDDLE));
        list.add(new Todo("報告書作成", "20160428", Todo.Priority.HIGH));
        list.add(new Todo("会議室予約", "201605301200", Todo.Priority.HIGH));
        list.update(new Todo("PC購入", "20160531", Todo.Priority.HIGH));
        for (Todo todo : list.select()) {
            todo.setState(Todo.State.STARTED);
            list.update(todo);
        }
        Condition condition1 = new Condition() {
            public boolean test(Todo todo) {
                return todo.getDeadline().compareTo("20160501") < 0;
            }
        };
        Condition condition2 = new Condition() {
            @Override
            public boolean test(Todo todo) {
                return todo.getPriority().equals(Todo.Priority.HIGH);
            }
        };
        for (Todo todo : list.select(condition1, condition2)) {
            System.out.println(todo);
        }
    }
}
