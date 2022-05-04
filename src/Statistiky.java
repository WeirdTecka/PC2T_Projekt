

import java.util.ArrayList;
import java.util.Scanner;

public class Statistiky {


    public static void statistikyMenu() {

        boolean run = true;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("1 | Abecedne razeny seznam studentu v dane skupine");
            System.out.println("2 | Vypis obecneho studijniho prumeru v dane skupine");
            System.out.println("3 | Vypis poctu studentu v dane skupine");
            System.out.println("4 | Navrat do hlavniho menu");
            System.out.println("----------------------------------");
            System.out.print("Vyberte volbu ze seznamu: ");
            int volba = Akce.onlyInt(1, 4);

            switch (volba) {
                case 1:
                    System.out.println("Technicky obor: ");
                    abcVypisDlePrijmeni("TechStudent");
                    System.out.println("----------------------------------");
                    System.out.println("Humanitni obor: ");
                    abcVypisDlePrijmeni("HumanStudent");
                    System.out.println("----------------------------------");
                    System.out.println("Kombinovany obor: ");
                    abcVypisDlePrijmeni("ComboStudent");
                    System.out.println("----------------------------------");
                    Akce.pressAnyKey();
                    break;
                case 2:
                    System.out.println("Technicky obor: ");
                    obecnyStudijniPrumer("TechStudent");
                    System.out.println("Humanitni obor: ");
                    obecnyStudijniPrumer("HumanStudent");
                    System.out.println("Kombinovany obor: ");
                    obecnyStudijniPrumer("ComboStudent");
                    Akce.pressAnyKey();
                    break;
                case 3:
                    System.out.println("Technicky obor: " + getPocetStudents("TechStudent"));
                    System.out.println("Humanitni obor: " + getPocetStudents("HumanStudent"));
                    System.out.println("Kombinovany obor: " + getPocetStudents("ComboStudent"));
                    Akce.pressAnyKey();
                    break;
                case 4:
                    run = false;
                    break;
            }
            
        }
    }

    public static void abcVypisDlePrijmeni(String skupina) {
        ArrayList<Student> studentiArray = new ArrayList<>();
            for (Student student: StorageStudent.ListStudents.values()){
                if(student.getClass().getName().equals(skupina))
                studentiArray.add(student);
            }
                 studentiArray.sort((a1, a2) -> a1.getLastName().compareTo(a2.getLastName()));;
                    for (Student student: studentiArray) {
                        System.out.println(student);
             }
      }

    public static void obecnyStudijniPrumer(String skupina) {
        int pocet = 0;
        double soucet = 0;
            for (Student student: StorageStudent.ListStudents.values()) {
                if (student.getClass().getName().equals(skupina)) {
                    if (student.getGradeAverage() == 0){
                }
                pocet++;
                soucet = soucet + student.getGradeAverage();
            }
        }
       double average = soucet / pocet;
        if (Double.isNaN(average)) {
            System.out.println("V zadane skupine nejsou zadane zadne znamky");
            System.out.println("----------------------------------");
        }
        else {
            System.out.println("Obecny prumer znamek ve skupine " + skupina + ": " + average);
            System.out.println("----------------------------------");
            }
    }

    public static int getPocetStudents(String skupina){
        int pocet = 0;
        for (Student student: StorageStudent.ListStudents.values()){
            if(student.getClass().getName().equals(skupina)){
                pocet++;
            }
        }
        return pocet;
    }
}