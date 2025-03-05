package Packages;

import java.util.ArrayList;

public class Base {

    class Person{
        public int ID;
        public static ArrayList<Person> personList;
        public String name;
        public String nationalID;
        private static int idcount = 1;

        public Person(String name, String nationalID){

            this.nationalID = nationalID;
            this.name = name;
            this.ID = idcount++;

            personList.add(this);
        }
        public static Person findbyID(int ID){

            for (Person person1 : personList) {
                if (person1.ID == ID) {
                    return person1;
                }
            }
            return null;
        }

    }
}
