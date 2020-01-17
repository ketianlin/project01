package top.ke1205.pojo;

public class MultiObject<T> {
    private boolean success;

    private Exception ex;

    private T obj;

    public MultiObject() {
    }

    public MultiObject(T obj) {
        this.success = true;
        this.obj = obj;
    }
}
