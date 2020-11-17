/**
 * Class:         CourseList
 * Author:        William Porter
 * Date:          09/08/2020
 * 
 * Paramaters:    listOfCourses, numCourses
 * Constructors:  CourseList(), CourseList(int) 
 * Functions:     size(), addCourse(int, Course), removeCourse(int), changeCapacity(String, int),
 *                getCourseWithIndex(int), SearchCourseID(String), SearchCourseName(String), getListOfCourses(),
 *                beforeOperation(), afterOperation(), toString(), dummy()
 */


import java.util.Arrays;

public class CourseList{

    final private Course[] listOfCourses;   //stores Course objects for further functionality
    private int numCourses;           //stores the number of courses in the listOfCourses

    public CourseList(){
        this(20);
    }

    public CourseList(int maximum){
        if(maximum < 1){ //makes sure the user doesn't create a courseList that does nothing
            this.listOfCourses = new Course[20];
        }else{
            this.listOfCourses = new Course[maximum];
        }
        this.numCourses = 0;
        
    }

    public int size(){
        return this.numCourses;
    }


    /**
     * O(n) at worst case
     * @param i is the index which you want to add the element before
     * @param course the course you wish to add
     * @return it returns a boolean value of whether the operation was successful or not
     */
    public boolean addCourse(int i, Course course){
        
        System.out.println("==================================================");
        System.out.println("Operation: add course to index " + Integer.toString(i));
        System.out.println(course + "\n");

        beforeOperation();

        if(i < 0 || this.size() == listOfCourses.length){  //makes sure the index isn't out of bounds
            afterOperation();
            return false;
        }else if(i>= 0 && i>=this.size()-1 && i<listOfCourses.length){  //operates if the index is past the courses in the list
            this.listOfCourses[this.size()] = course;
            this.numCourses++;
            afterOperation();
            return true;
        }else if(i<=listOfCourses.length){  //operates if the index is within the courses in the list
            Course[] temp = Arrays.copyOfRange(this.listOfCourses, i, this.size());
            this.listOfCourses[i] = course;
            for (int j = 0; j < temp.length; j++) {
                this.listOfCourses[j+i+1] = temp[j];
            }
            this.numCourses++;
            afterOperation();
            return true;
        }
        afterOperation();
        return false;
    }

    /**
     * O(n) at worst case
     * @param i is the index of the course you want to remove
     * @return a boolean depending on whether or whether not the operation was successful
     */
    public boolean removeCourse(int i){

        System.out.println("==================================================");
        System.out.println("Operation: remove course at index " + Integer.toString(i) + "\n");
        beforeOperation();

        if(i >= this.size() || i < 0){  //checks if the index is within bounds of the courses
            System.out.println("List after the operation:");
            System.out.println(this.toString());
            afterOperation();
            return false;
        }else if(i == this.size()-1){  //checks if the index is the last index of the courses in the list
            this.numCourses--;
            this.listOfCourses[i] = null;
            System.out.println("List after the operation:");
            System.out.println(this.toString());
            afterOperation();
            return true;
        }else{  //operates if the index is within the number of courses
            Course[] temp = Arrays.copyOfRange(this.listOfCourses, i+1, this.size());
            this.listOfCourses[i] = null;
            for (int j = 0; j < temp.length; j++) {
                this.listOfCourses[i+j] = temp[j];
            }
            numCourses--;
            System.out.println("List after the operation:");
            System.out.println(this.toString());
            afterOperation();
            return true;
        }
    }

    /**
     * O(n) at worst case
     * @param courseID is the ID of the course you want to change the capacity of
     * @param capacity is the capacity you want to change it to
     * @return boolean value depending on whether or whether the operation was successful 
     */
    public boolean changeCapacity(String courseID, int capacity){

        System.out.println("==================================================");
        System.out.println("Operation: changing capacity of course with courseID of " + courseID + " to " + Integer.toString(capacity) + "\n");
        beforeOperation();

        for (Course course : listOfCourses) {
            if(capacity >= 0 && course.getCourseID() == courseID)
                course.setCapacity(capacity);
                afterOperation();
                return true;
        }
        afterOperation();
        return false;
    }

    /**
     * O(1) worst case
     * @param i is the index of the item you wish to retrieve
     * @return Course
     */
    public Course getCourseWithIndex(int i){

        System.out.println("==================================================");
        System.out.println("Operation: getting the Course at index " + Integer.toString(i));
        if(i > this.size() || i < 0){
            System.out.println("Index out of bounds");
            return null;
        }else{
            System.out.println("Found " + this.listOfCourses[i].toString());
            return this.listOfCourses[i];
        }
    }

    /**
     * O(n) at worst case
     * @param courseID is the courseID of the course you want to find
     * @return an integer that is the index of the course or is -1 if the operation couldn't find it
     */
    public int SearchCourseID(String courseID){

        System.out.println("==================================================");
        System.out.println("Operation: searching for course with courseID of " + courseID + "\n");

        for (int i = 0; i < this.size(); i++) {
            if(this.listOfCourses[i].getCourseID().equals(courseID)){
                System.out.println("Found course " + this.listOfCourses[i].toString() + " at index " + Integer.toString(i));
                return i;
            }
        }
        System.out.println("Did not find course");
        return -1;
    }    

    /**
     * O(n) at worst case
     * @param courseName is the courseName of the course you want to find
     * @return an integer that is the index of the course or is -1 if the operation couldn't find it
     */
    public int SearchCourseName(String courseName){

        System.out.println("==================================================");
        System.out.println("Operation: searching for course with courseName of " + courseName + "\n");

        for (int i = 0; i < this.size(); i++) {
            if(this.listOfCourses[i].getCourseName().equals(courseName)){
                System.out.println("Found course " + this.listOfCourses[i].toString() + " at index " + Integer.toString(i));
                return i;
            }
        }
        System.out.println("Did not find course");
        return -1;
    }

    public Course[] getListOfCourses() {
        return listOfCourses;
    }

    public void beforeOperation(){
        System.out.println("List before the operation:");
        System.out.println(this.toString());
    }

    public void afterOperation(){
        System.out.println("List after the operation:");
        System.out.println(this.toString());
        System.out.println("==================================================" + "\n");
    }

    @Override
    public String toString(){
        String result = this.getClass().getName() + " with maximum capacity of " + Integer.toString(this.listOfCourses.length) + " with Courses:\n";
        if(this.size() != 0){
            for (int i = 0; i < size(); i++) {
                result += Integer.toString(i+1) + ". " + listOfCourses[i].toString() + "\n";
            }
        }
        return result;
    }

    /**
     * used soley for testing purposes so I don't have to create a CourseList and initialize
     * variable and add stuff to the list every time
     * @return CourseList predetermined for testing purposes
     */
    public static CourseList dummy(){
        CourseList courseList = new CourseList(20);
        courseList.listOfCourses[0] = new Course("121", "MATH", 10);
        courseList.listOfCourses[1] = new Course("146", "FSNA", 10);
        courseList.listOfCourses[2] = new Course("233", "CSDS", 10);
        courseList.listOfCourses[3] = new Course("145", "ENGR", 10);
        courseList.numCourses = 4;
        return courseList;
    }
}