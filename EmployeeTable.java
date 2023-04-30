public class EmployeeTable {
  Integer[] keys = new Integer[100];
  Employee[] data = new Employee[100];
  boolean[] used = new boolean[100];
  int num = 0;

  public void put(Employee e) {
    if (num == data.length) {
      System.out.println("Table is full");
      return;
    }
    int idx = findIndex(e.getEmpNo());
    if (idx != -1) {
      data[idx] = e;
    } else {
      idx = hash(e.getEmpNo());
      while (used[idx]) {
        idx = (idx + 1) % data.length;
      }
      used[idx] = true;
      keys[idx] = e.getEmpNo();
      data[idx] = e;
      num++;
    }
  }

  public boolean remove(int emp_no) {
    int idx = findIndex(emp_no);
    if (idx == -1) {
      return false;
    } else {
      data[idx] = null;
      keys[idx] = null;
      used[idx] = false;
      num--;
      return true;
    }
  }

  public int search(int emp_no) {
    int idx = findIndex(emp_no);
    return idx == -1 ? -1 : idx;
  }

  private int hash(int key) {
    return Math.abs(key) % data.length;
  }

  private int findIndex(int key) {
    int idx = hash(key);
    int counter = 0;
    while (counter < data.length && used[idx]) {
      if (keys[idx] != null && keys[idx] == key) {
        return idx;
      }
      idx = (idx + 1) % data.length;
      counter++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Employee employee1 = new Employee("John Smith", 12345, 30, "CA", 12345, "Jane Doe");
    Employee employee2 = new Employee("Mary Johnson", 23456, 25, "NY", 54321, "John Doe");
    Employee employee3 = new Employee("Alice Lee", 34567, 35, "CA", 56789, "Bob Smith");
    Employee employee4 = new Employee("Bob Smith", 45678, 40, "NY", 98765, "Alice Lee");
    Employee employee5 = new Employee("David Brown", 56789, 45, "CA", 24680, "Emily Davis");
    Employee employee6 = new Employee("Emily Davis", 67890, 50, "NY", 13579, "David Brown");

    EmployeeTable employeeTable = new EmployeeTable();
    employeeTable.put(employee1);
    employeeTable.put(employee2);

    // Test search and remove
    System.out.println("Employee 12345 found at index: " + employeeTable.search(12345));
    System.out.println("Employee 23456 found at index: " + employeeTable.search(23456));
    System.out.println("Removing employee 23456: " + employeeTable.remove(23456));
    System.out.println("Employee 23456 found at index: " + employeeTable.search(23456));
    System.out.println("Removing employee 23456 again: " + employeeTable.remove(23456));

    // Add more employees
    employeeTable.put(employee3);
    employeeTable.put(employee4);
    employeeTable.put(employee5);
    employeeTable.put(employee6);

    // Test search for all employees
    System.out.println("Employee 12345 found at index: " + employeeTable.search(12345));
    System.out.println("Employee 23456 found at index: " + employeeTable.search(23456));
    System.out.println("Employee 34567 found at index: " + employeeTable.search(34567));
    System.out.println("Employee 45678 found at index: " + employeeTable.search(45678));
    System.out.println("Employee 56789 found at index: " + employeeTable.search(56789));
    System.out.println("Employee 67890 found at index: " + employeeTable.search(67890));

    // Test adding an employee when table is full
    for (int i = 0; i < 95; i++) {
      employeeTable.put(new Employee("Name", i + 1, 20, "CA", 12345, "Advisor"));
    }
    System.out.println("Adding employee when table is full: ");
    employeeTable.put(new Employee("Last Employee", 100, 30, "NY", 54321, "Advisor"));

    // Test removing a non-existent employee
    System.out.println("Removing non-existent employee: " + employeeTable.remove(123));

    // Test search for non-existent employee
    System.out.println("Searching for non-existent employee: " + employeeTable.search(123));
  }

}
