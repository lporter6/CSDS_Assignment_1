public class test2{

    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        courseList.addCourse(2, new Course());
        courseList.getCourseWithIndex(0);
        courseList.getCourseWithIndex(-1);
        courseList.getCourseWithIndex(3);
    }


}