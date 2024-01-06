
public class Test {
      public static void main(String [] args){
          int score = 0;
          Bag bag = new ArrayBag(10);

          Student [] students = new Student[5];
          students[0] = new Student(4, "Omar Vazques", Department.GEO);
          students[1] = new Student(1, "John Doe", Department.CSCI);
          students[2] = new Student(3, "Sarit Agrawal", Department.BIO);
          students[3] = new Student(5, "Jennifer Wu", Department.CHEM);
          students[4] = new Student(2, "Judy Johnson", Department.PHYSICS);
          Student dummyStudent = new Student(6, "No name", Department.NONE);

          // Test bag.add()
          for (int i=0; i<students.length; i++){
              bag.add(students[i]);
          } // end-for
          
          if (bag.size() == students.length) score += 2;
          if (!bag.isEmpty()) score += 2;

          // Test bag.clear()
          bag.clear();
          if (bag.isEmpty()) score += 2;
          if (bag.size() == 0) score += 2;

          // Add all students again
          for (int i=0; i<students.length; i++){
              bag.add(students[i]);
          } // end-for

          // Test the Iterator
          int [] lut = new int[6];
          for (var s: bag){
              System.out.println(s);
              lut[s.getId()]++;
          } // end-for

          boolean ok = true;
          for (int i=1; i<lut.length; i++){
              if (lut[i] != 1){
                  ok = false;
                  break;
              } // end-if
          } // end-for
          if (ok) score += 20;

          // Test contains & remove
          for (int i=0; i<students.length; i++){
              if (bag.contains(students[i])) score += 5;
          } // end-for

          if (!bag.contains(dummyStudent)) score += 5;
          bag.remove(dummyStudent);
          if (!bag.contains(dummyStudent)) score += 5;

          for (int i=0; i<students.length; i++){
              bag.remove(students[i]);
              if (!bag.contains(students[i])) score += 5;
              if (bag.size() == students.length-i-1) score += 2;
          } // end-for

          if (bag.isEmpty()) score += 2;

          System.out.printf("Your lab score %d\n", score);
      } // end-main
  } //end-SortedLinkedbagTest

