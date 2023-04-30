public class Employee implements Cloneable {
  private String name;
  private int id;
  private int age;
  private String state;
  private int zipCode;
  private String advisor;

  // constructor that sets all values to null and zero
  public Employee() {
    name = null;
    id = 0;
    age = 0;
    state = null;
    zipCode = 0;
    advisor = null;
  }

  public Employee(String name, int id, int age, String state, int zipCode, String advisor) {
    this.name = name;
    this.id = id;
    this.age = age;
    this.state = state;
    this.zipCode = zipCode;
    this.advisor = advisor;
  }

  // constructor that takes object of type Object as parameter
  // then creates a deep copy of it if it is an instance of Employee.
  // the method prevents errors by checking that the String variables are not null
  public Employee(Object obj) {
    if (obj != null && (obj instanceof Employee)) {
      Employee temp = (Employee) obj;
      if (temp.getName() != null) {
        this.name = new String(temp.getName());
      }
      this.id = temp.getEmpNo();
      this.age = temp.getAge();
      if (temp.getState() != null) {
        this.state = new String(temp.getState());
      }
      this.zipCode = temp.getZipCode();
      if (temp.getAdvisor() != null) {
        this.advisor = new String(temp.getAdvisor());
      }
    }
  }

  /*
   * function creates a deep copy of the object on witch it is called
   * and returns it as an object of class Employee.
   * the method prevents errors by checking that the String variables are not null
   */
  @Override
  public Employee clone() throws CloneNotSupportedException {
    Employee cEmployee = null;
    cEmployee = (Employee) super.clone();
    if (this.name != null) {
      cEmployee.setName(new String(this.name));
    }
    cEmployee.setID(this.id);
    cEmployee.setAge(this.age);
    if (this.state != null) {
      cEmployee.setState(new String(this.state));
    }
    cEmployee.setZipCode(this.zipCode);
    if (this.advisor != null) {
      cEmployee.setAdvisor(new String(this.advisor));
    }
    return cEmployee;
  }

  // all setter and getter method for the instacne variables of the class
  // Employee.
  public void setName(String inName) {
    name = inName;
  }

  public String getName() {
    return name;
  }

  public void setID(int inID) {
    id = inID;
  }

  public int getEmpNo() {
    return id;
  }

  public void setAge(int inAge) {
    age = inAge;
  }

  public int getAge() {
    return age;
  }

  public void setState(String inState) {
    state = inState;
  }

  public String getState() {
    return state;
  }

  public void setZipCode(int inZip) {
    zipCode = inZip;
  }

  public int getZipCode() {
    return zipCode;
  }

  public void setAdvisor(String inAdv) {
    advisor = inAdv;
  }

  public String getAdvisor() {
    return advisor;
  }

  /*
   * overrides the toString method and returns all
   * the instance variabel in a single string separetaed by spaces
   */
  public String toString() {
    String s = name + "," + id + "," + age + "," + state + "," + zipCode + "," + advisor;
    return s;
  }

  // function compare the value of id of two object
  // returns false if obj is null or is not an instance of Employee
  public boolean equals(Object obj) {
    if (obj != null && (obj instanceof Employee)) {
      Employee identify = (Employee) obj;
      return (this.id == identify.getEmpNo());
    } else {
      return false;
    }
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    // test for defaul contructur and setter methods.
    Employee Orignial = new Employee();
    Orignial.setAge(12);
    Orignial.setName("jeff");
    Orignial.setAdvisor("steve");
    Orignial.setID(1497);
    Orignial.setState("NM");
    Orignial.setZipCode(88234);

    // test the toString method
    System.out.println(Orignial.toString());
    // test the copy constructor
    Employee copy = new Employee(Orignial);
    copy.setAdvisor("stevenson");
    // ensure there are two different objects by changin an instace varialbe in the
    // copy
    // and comparing it to the origial
    System.out.println(copy.toString());
    System.out.println(Orignial.toString());

    // test clone method
    Employee cloned = Orignial.clone();
    // ensure two different objects exist by changing instace variabel in the clone
    // and comapring it to the origial
    cloned.setAdvisor("Doom guy");
    System.out.println(cloned.toString());
    System.out.println(Orignial.toString());
    // test of the equals method // first test should return true
    System.out.println(copy.equals(cloned));
    cloned.setID(24);
    // afther change the output should be false
    System.out.println(copy.equals(cloned));
    // test changing original object to see if clones are affected
    Orignial.setName("he who remains");
    System.out.println(cloned.toString());
    System.out.println(copy.toString());

    System.out.println(Orignial.toString());
    // test for cases in wich strings are null
    Employee Empty = new Employee();
    Employee cloneEmpty = Empty.clone();
    System.out.println(cloneEmpty.toString());
    Employee copyEmpty = new Employee(Empty);
    System.out.println(copyEmpty.toString());
  }
}// end of class