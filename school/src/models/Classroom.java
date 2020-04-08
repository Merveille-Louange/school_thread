package models;


import java.util.concurrent.Semaphore;

public class Classroom {
    private static final int MAX_LECTURER = 1;
    private static final int MAX_VISITOR = 5;

    private final Semaphore numOfLecturers = new Semaphore(MAX_LECTURER, true);
    private final Semaphore visitors = new Semaphore(MAX_VISITOR, true);

    private String title;
    private int capacity;
    private boolean inSession = false;
    private boolean isLecturer = false;
    private boolean isSeated = false;
    private final Semaphore students = new Semaphore(this.capacity, true);

    public Classroom() {
    }

    public Classroom(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
    }

// invoke by student
    public void enter(String person) {
        if (person.equals("lecturer")) {
            try {
                System.out.println("lecturer entering class");
                //
                numOfLecturers.acquire();
                //
                this.isLecturer = true;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // visitors
        else{
            try {
                System.out.println("Visitor entering classroom");
                visitors.acquire();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        // student
        if (person.equals("student")){
            if (!inSession && !isLecturer) {
                try{
                    System.out.println("entering classroom");
                    students.acquire();
                    System.out.println("successfully entered classroom");

                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }


    //lecturer startLecture
    public void startLecture () {
        this.inSession = true;
        this.isLecturer = true;
    }
    public void leave (String person) {
        if (person.equals("visitor")){
            System.out.println("You have left the class " + this.title);
            this.isSeated = false;
            visitors.release();
        }
        // lecturer leaves
        if (person.equals("lecturer")) {
            System.out.println(" class " + this.title + " Over" );
            System.out.println("lecturer leaves class");
            //
            this.isLecturer = false;
            //
            numOfLecturers.release();
        }
        if (person.equals("student")) {
            System.out.println("student leaving class");
            students.release();

        }

    }
// invoke by  student

    public boolean sitDown() {
        return isSeated = true;
    }

}
