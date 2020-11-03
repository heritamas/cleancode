package ch07.exception;

public class TaskError extends RuntimeException {
    Task t;

    public TaskError(String message, Task t) {
        super(message);
        this.t = t;
    }
}
