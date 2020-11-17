/**
 * Class:         CourseList
 * Author:        William Porter
 * Date:          09/08/2020
 * 
 * Paramaters:    courseID, courseName, capacity
 * Constructor:   Course(), Course(String, String, int)
 */


public class Course {

    private String courseID;
    private String courseName;
    private int capacity;
    private boolean isCool;

    public Course(){
        this("1", "Hello", 1);
    }
    public Course(String courseID, String courseName, int capacity){
        if(courseID.equals("") || courseName.equals("") || capacity <= 0){
            throw new IllegalArgumentException("Incorrect argument(s)");
        }
        this.courseID = courseID;
        this.courseName = courseName;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCourseName() {
        return courseName;
    }

    protected void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    protected void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString(){
        return new String(this.getClass().getName() + ": [Name: " + this.courseName + ", ID: " + this.courseID + ", Capacity: " + String.valueOf(this.capacity) + "]");
    }

}