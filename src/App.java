import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws NumberFormatException, ParseException {
    boolean run = true;
    StorageStudent students = new StorageStudent();
    Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("1  | Pridat noveho studenta");
            System.out.println("2  | Pridat znamku");
            System.out.println("3  | Propustit studenta a vymazat ho z databaze");
            System.out.println("4  | Vyhledat informace o studentovi podle ID");
            System.out.println("5  | Dovednost studenta podle ID");
            System.out.println("6  | Statistiky");
            System.out.println("7  | Exportovat data do souboru");
            System.out.println("8  | Importovat data ze souboru");
            System.out.println("9  | Ulozit data do SQL databaze");
            System.out.println("10 | Nacist data z SQL databaze");
            System.out.println("11 | Konec aplikace");
            System.out.println("----------------------------------");
            System.out.print("Vyberte volbu ze seznamu: ");
            int vyber = Akce.onlyInt(1,11);
            switch (vyber) {
                case 1: 
                    System.out.print("Zadejte jmeno studenta: ");
                    String jmeno = sc.next();
            
                    System.out.print("Zadejte prijmeni studenta: ");
                    String prijmeni = sc.next();
            
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date Datum;
                    while (true)
                    try {
                        System.out.print("Zadejte cele datum narozeni studenta (DD.MM.YYYY): ");
                        Datum = sdf.parse(sc.next());
                        break;
                    } catch (ParseException e) {
                        System.out.println("Zadane datum je v chybnem formatu");
                        System.out.println("----------------------------------");
                    }

                    System.out.println("SKUPINY");
                    System.out.println("1 - technicky obor");
                    System.out.println("2 - humanitni obor");
                    System.out.println("3 - kombinovane studium");
                    System.out.print("Vyberte skupinu: ");
                    int Skupina = Akce.onlyInt(1,3);

                    switch (Skupina){
                        case 1:
                            students.addStudent(students.getNextId(), new TechStudent(students.getNextId(), jmeno, prijmeni, Datum));
                            break;
                        case 2:
                            students.addStudent(students.getNextId(), new HumanStudent(students.getNextId(), jmeno, prijmeni, Datum));
                            break;
                        case 3:
                            students.addStudent(students.getNextId(), new ComboStudent(students.getNextId(), jmeno, prijmeni, Datum));
                    }
                    System.out.println("Student uspesne pridan do databaze!");
                    System.out.println("----------------------------------");
                    break;
                case 2: 
                    System.out.println("Zadej ID: ");
                    try{
                        int id = Akce.onlyInt(0, 500);
                        Student currentStudent = students.getStudentById(id);
                        System.out.println("Zadej znamku: ");
                        int grade = Akce.onlyInt(1,5);
                        currentStudent.addGrade(grade);
                    }catch (NullPointerException e){
                        System.out.println("ID neni v databazi, student neexistuje");
                    }
                    Akce.pressAnyKey();
                    break;
                case 3:
                    System.out.println("Zadej ID: ");
                    try{
                        int id = Akce.onlyInt(1, 500);
                        students.deleteStudent(id);
                    }catch (NullPointerException e){
                        System.out.println("ID neni v databazi, student neexistuje");
                    }
                    Akce.pressAnyKey();
                    break;
                case 4:
                    System.out.println("Zadej ID: ");
                    try{
                        int id = Akce.onlyInt(0, 500);
                        System.out.println(students.getStudentById(id));
                    }catch (NullPointerException e){
                        System.out.println("ID neni v databazi, student neexistuje");
                    }
                    Akce.pressAnyKey();
                    break;
                case 5:
                    System.out.println("Zadej ID: ");
                    try{
                        int id = Akce.onlyInt(1, 500);
                        Student currentStudent = students.getStudentById(id);
                        currentStudent.Dovednosti();
                    }catch (NullPointerException e){
                        System.out.println("ID neni v databazi, student neexistuje");
                    }
                    Akce.pressAnyKey();
                    break;
                case 6:
                    if (StorageStudent.ListStudents.isEmpty()) {
                        System.out.println("Databaze studentu je prazdna");
                        System.out.println("----------------------------------");
                    }else Statistiky.statistikyMenu();
                    break;
                case 7:
                    StorageStudent.saveToFile("studentiDB");
                    break;
                case 8:
                    System.out.println("Aktualni databaze se vymaze.");
                    try{
                        for(int i = 1; i <= 500; i++){
                            students.deleteStudent(i);
                        }
                    }catch (NullPointerException e){
                        System.out.println("error");}
                    Akce.pressAnyKey();
                    StorageStudent.loadFromFile("studentiDB");
                    break;
                case 9:
                    sqldb.ConnectDB.getDBConnection();
                    sqldb.Create.init_tables();
                    break;
                case 10:
                    //nefunguje
                    break;
                case 11:
                    System.out.println("Ukoncuji aplikaci");
                    try {
                        Akce.loadingBar();
                        System.out.println("\nAplikace ukoncena.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    run = false;
                    break;
                }
             }
            }
}