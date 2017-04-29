// ~~~~~ 3PIO Comments for StudType ~~~~~//
//Purpose: create a StudType object
//Input: Various. Depends on the method/constructor called
//Pre Condition: the file compiles
//Output: Various. Depends on the method called
//Post Condition: Various. Depends on the method/constructor called
//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public class StudType {
    private int id;
    private String name;
    private double gpa;
    private String sex;

    // ~~~~~ 3PIO Comments for no args constructor ~~~~~//
    //Purpose: create a StudType object
    //Input: n/a
    //Pre Condition: the file compiles
    //Output: n/a
    //Post Condition: A default StudType object is created
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public StudType(){
        id = 0;
        name = "";
        gpa = 0.0;
        sex = "";
    }

    // ~~~~~ 3PIO Comments for three args constructor ~~~~~//
    //Purpose: create a StudType object with given data
    //Input: int, String, double, String
    //Pre Condition: the data is passed to the constructor
    //Output: n/a
    //Post Condition: A StudType object is created with given data
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public StudType(int inId, String inName, double inGpa, String inSex){
        id = inId;
        name = inName;
        gpa = inGpa;
        sex = inSex;
    }

    // ~~~~~ 3PIO Comments for getId ~~~~~//
    //Purpose: return the id
    //Input: n/a
    //Pre Condition: the id is set
    //Output: int
    //Post Condition: the id is returned
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public int getId(){
        return id;
    }

    // ~~~~~ 3PIO Comments for getName ~~~~~//
    //Purpose: return the Name
    //Input: n/a
    //Pre Condition: the name is set
    //Output: String
    //Post Condition: the name is returned
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public String getName(){
        return name;
    }

    // ~~~~~ 3PIO Comments for getGpa ~~~~~//
    //Purpose: return the Gpa
    //Input: n/a
    //Pre Condition: the Gpa is set
    //Output: double
    //Post Condition: the Gpa is returned
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public double getGpa(){
        return gpa;
    }

    // ~~~~~ 3PIO Comments for getSex ~~~~~//
    //Purpose: return the sex
    //Input: n/a
    //Pre Condition: the sex is set
    //Output: String
    //Post Condition: the sex is returned
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public String getSex(){
        return  sex;
    }

    // ~~~~~ 3PIO Comments for setId ~~~~~//
    //Purpose: set the id
    //Input: int
    //Pre Condition: data is provided
    //Output: n/a
    //Post Condition: the id is set to the given value
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public void setId(int inId){
        id = inId;
    }

    // ~~~~~ 3PIO Comments for setName ~~~~~//
    //Purpose: set the Name
    //Input: string
    //Pre Condition: data is provided
    //Output: n/a
    //Post Condition: the name is set to the given value
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public void setName(String inName){
        name = inName;
    }

    // ~~~~~ 3PIO Comments for setGpa ~~~~~//
    //Purpose: set the gpa
    //Input: double
    //Pre Condition: data is provided
    //Output: n/a
    //Post Condition: the gpa is set to the given value
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public void setGpa(double inGpa){
        gpa = inGpa;
    }

    // ~~~~~ 3PIO Comments for setSex ~~~~~//
    //Purpose: set the sex
    //Input: string
    //Pre Condition: data is provided
    //Output: n/a
    //Post Condition: the sex is set to the given value
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public void setSex(String inSex){
        sex = inSex;
    }

    // ~~~~~ 3PIO Comments for ValidStudType ~~~~~//
    //Purpose: test if the given data is valid
    //Input: n/a
    //Pre Condition: all data is set
    //Output: boolean
    //Post Condition: the data is determined to to valid or not.
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public boolean ValidStudType(){
        if (id >= 111 && id <= 999 && gpa >= 0.0 && gpa <= 4.00 && (sex.equals("M") || sex.equals("F")))
            return  true;
        else
            return false;
    }

}
