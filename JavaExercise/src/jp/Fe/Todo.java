/*
 * H28年春
 */
package jp.Fe;

import java.util.UUID;

public class Todo {
    public enum Priority { LOW, MIDDLE, HIGH }
    public enum State { NOT_YET_STARTED, STARTED, DONE }

    // 8桁または12桁の数字からなる文字列と一致する正規表現
    private static final String DEADLINE_PATTERN = "\\d{8}|\\d{12}";

    private final String id;
    private String subject;
    private String deadline;
    private Priority priority;
    private State state;

    private  Todo(String subject, String deadline, Priority priority, String id, State state) {
        if (!deadline.matches(DEADLINE_PATTERN)) {
            throw new IllegalArgumentException();
        }
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.id = id;
        this.state = state;
    }

    public Todo(String subject, String deadline, Priority priority) {
        this(subject, deadline, priority, UUID.randomUUID().toString(), State.NOT_YET_STARTED);
    }

    public Todo(Todo todo) {
        this(todo.subject, todo.deadline, todo.priority, todo.id, todo.state);
    }

    public String getSubject() {
        return subject;
    }

    public String getDeadline() {
        return deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object o) {
        return o instanceof Todo && ((Todo) o).equals(id);  // a
    }
}
