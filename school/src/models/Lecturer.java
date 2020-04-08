package models;

public class Lecturer extends Classroom {
    //@Override
    public void enter() {
        super.enter("lecturer");
    }

    public void leave() {
        super.leave("lecturer");
    }

    @Override
    public void startLecture() {
        super.startLecture();
    }
}
