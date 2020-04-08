package models;

public class Student extends Classroom {

    public void enter() {
        super.enter("student");
    }

    public void leave() {
        super.leave("student");
    }

    @Override
    public boolean sitDown() {
        return super.sitDown();
    }
}
