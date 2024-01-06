public class Student {
   private int id;
   private String name;
   private Department department;
   
   public Student ( int id, String name, Department dept) {
      setId(id).setName(name);
      department =dept;
   }
   
   // TODO
   // include getters id, name, dept
   public int getId() {
      return id;
  }
   
   public String getName() {
      return name;
  }
   
   public Department getDepartment() {
      return department;
  }
   
   //include a setter for dept
   public Student setDepartment(Department dept) {
      this.department = dept;
      return this;
  }
   
    
   public Student setId(int id) {
      if (id<=0) 
         throw new IllegalArgumentException("Improper id: "+ id);
      this.id= id;
      return  this;
   }
   
   public Student setName(String name) {
      //TODO throw excepption if name == null or <2 chars
         if (name == null || name.length() < 2)
             throw new IllegalArgumentException("Name cannot be null or less than 2 characters");
         this.name = name;
         return this;
      
   }
   
   // toString should present key information of the student of the student dept, name, id
   public String toString() {
      return "Student{" + "id=" + id + ", name='" + name + '\'' + ", department=" + department + '}';
  }
   
   // equals, make sure object o is not null, make sure its a studnet and then compare to see if dept, name and id are the same.
   
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Student)) 
          return false;
       Student student = (Student) o;
       return id == student.id && name.equals(student.name) && department == student.department;
   }
   @Override
   public int hashCode() {
      //TODO include the other tow fileds 
      //result = 31*result + field - name(String), id(int)
          int result = department.hashCode();
          result = 31 * result + id;
          result = 31 * result + name.hashCode();
          return result;
      
   }
}
