package models;

public class Visitor extends Classroom {

    public void enter() {
        super.enter("visitor");
    }

    public void leave() {
        super.leave("visitor");
    }

    @Override
    public boolean sitDown() {
        return super.sitDown();
    }
}
