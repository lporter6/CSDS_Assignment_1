/**
 * Class:         Test
 * Author:        William Porter
 * Date:          09/08/2020
 */


public class Test {

    /**
     * This function tests functionality using bad path and good path testing in the form of a boolean array
     * @return testResults array with 4 values
     *         index 0 - if the addCourse method can add courses to the list and maintain the correct size()
     *         index 1 - if the addCourse method protects sub 0 integers intputs for index
     *         index 2 - if the addCourse method protects above the list size inputs for index
     *         index 3 - if the addCourse method correctly inserts Course objects to the list
     *         index 4 - if the addCourse method correctly stops insertion from overfilling the courseList
     */
    public static boolean[] testAddCourseAndSize(){
        boolean[] testResults = {true,true,true,true,false};

        //initialization of CourseList
        CourseList courseList = new CourseList();
        Course course1 = new Course("0001","Science",20);
        Course course2 = new Course("0002","Technology",20);
        Course course3 = new Course("0003","Engineering",20);
        Course course4 = new Course("0004","Math",20);
        Course toInsert = new Course("0005", "Art", 20);        //this Course will attempt to be inserted into the CourseList
        courseList.addCourse(0, course1);
        courseList.addCourse(1, course2);
        courseList.addCourse(2, course3);
        courseList.addCourse(3, course4);

        //test 1
        if(!(courseList.getListOfCourses()[0] == course1)){testResults[0] = false;}
        if(!(courseList.getListOfCourses()[1] == course2)){testResults[0] = false;}
        if(!(courseList.getListOfCourses()[2] == course3)){testResults[0] = false;}
        if(!(courseList.getListOfCourses()[3] == course4)){testResults[0] = false;}
        if(!(courseList.size() == 4)){testResults[0] = false;}

        //test 2
        boolean result1 = courseList.addCourse(-1, new Course());
        if(!(courseList.size() == 4)){testResults[1] = false;}
        if(result1){testResults[1] = false;}

        //test 3
        boolean result2 = courseList.addCourse(20, new Course());
        if(!(courseList.size() == 4)){testResults[2] = false;}
        if(result2){testResults[2] = false;}

        //test 4
        boolean result3 = courseList.addCourse(2, toInsert);
        if(!(courseList.size() == 5)){testResults[3] = false;}
        if(!(courseList.getListOfCourses()[0] == course1)){testResults[3] = false;}
        if(!(courseList.getListOfCourses()[1] == course2)){testResults[3] = false;}
        if(!(courseList.getListOfCourses()[2] == toInsert)){testResults[3] = false;}
        if(!(courseList.getListOfCourses()[3] == course3)){testResults[3] = false;}
        if(!(courseList.getListOfCourses()[4] == course4)){testResults[3] = false;}


        //test 5
        CourseList courseList2 = new CourseList(1);
        courseList2.addCourse(0, new Course());
        boolean result = courseList2.addCourse(0, new Course());
        if(!result){testResults[4] = true;}

        return testResults;

        

    }

    public static void testRemoveCourse(){
        
        CourseList.dummy().removeCourse(3); //testing good path removal
        CourseList.dummy().removeCourse(10); //testing bad path removal
        CourseList.dummy().removeCourse(-1); //testing bad path removal

    }

    public static void testChangeCapacity(){
        CourseList.dummy().changeCapacity("121", 20); //good path
        CourseList.dummy().changeCapacity("000", 20); //bad path
        CourseList.dummy().changeCapacity("121", -20000); //bad path
    }

    public static void testGetCourseWithIndex(){
        CourseList.dummy().getCourseWithIndex(0); //good path
        CourseList.dummy().getCourseWithIndex(10); //bad path
        CourseList.dummy().getCourseWithIndex(-1); //bad path
    }

    public static void testSearchCourseID(){
        CourseList.dummy().SearchCourseID("121"); //good path
        CourseList.dummy().SearchCourseID("000"); //bad path
    }

    public static void testSearchCourseName(){
        CourseList.dummy().SearchCourseName("MATH"); //good path
        CourseList.dummy().SearchCourseName("EECS"); //bad path
    }

    public static void main(String[] args){
        testAddCourseAndSize();
        testRemoveCourse();
        testChangeCapacity();
        testGetCourseWithIndex();
        testSearchCourseID();
        testSearchCourseName();
    }


}