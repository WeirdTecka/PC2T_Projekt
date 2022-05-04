import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StorageStudent {

    public static HashMap<Integer, Student> ListStudents = new HashMap<>();
    private int idx = 0;

    public void addStudent(int id, Student student){
        ListStudents.put(id, student);
        idx++;
    }

    public Student getStudentById(int id){
        return ListStudents.get(id);
    }

    public int getNextId(){
        return this.idx + 1;
    }

   public static void saveToFile(String soubor){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(soubor, true))){ 
            new FileWriter(soubor, false).close();
            for (Student student: ListStudents.values()){
                bw.write(student.toFile() + "\n");
                bw.flush();
            }
            System.out.println("Uspesne zapsano do souboru");
		}
		catch (IOException e)
		{
			System.out.println("Akce se nepovela, vyjimka typu: " + e.toString());
		} 
	} 

    public static void loadFromFile(String soubor) throws NumberFormatException, ParseException{
        HashMap<Integer, Student> students = new HashMap<>();
        try {
            File mySoubor = new File(soubor);
            Scanner sc = new Scanner(mySoubor);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                Student student = stringToStudent(data);
                students.put(student.getId(), student);
            }
            sc.close();
            ListStudents = students;
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    private static Student stringToStudent(String text) throws NumberFormatException, ParseException{
        String[] arr =  text.split(", ");
        String skupina = arr[4];
        String date = arr[3];
        int id = Integer.parseInt(arr[0]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        text = arrayProcess(text, 5);
        int len = text.length();
        if(len == 4)
        {
            text = text.substring(2, len-2);
            if (skupina.equals("Technicka")){
                return new TechStudent(id, arr[1], arr[2], sdf.parse(date));
            }
            else if (skupina.equals("Humanitni")){
                return new HumanStudent(id, arr[1], arr[2], sdf.parse(date));
            }
            else if (skupina.equals("Kombinovana")){
                return new ComboStudent(id, arr[1], arr[2], sdf.parse(date));
            }
        }else{
            if (skupina.equals("Technicka")){
                return new TechStudent(id, arr[1], arr[2], sdf.parse(date), fillGrades(text));
            }
            else if (skupina.equals("Humanitni")){
                return new HumanStudent(id, arr[1], arr[2], sdf.parse(date) , fillGrades(text));
            }
            else if (skupina.equals("Kombinovana")){
                return new ComboStudent(id, arr[1], arr[2], sdf.parse(date) , fillGrades(text));
            }
        }
        return null;
    }

    private static LinkedList<Integer> fillGrades(String text){
        int len = text.length();
        text = text.substring(2, len-2);
        String[] arr = text.split(", ");
        LinkedList<Integer> grades = new LinkedList<>();
        for (String stringGrades: arr){
            grades.add(Integer.parseInt(stringGrades));
        }
        return grades;
    }

    private static String arrayProcess(String text, int n){
        String[] arr =  text.split(", ");
        List<String> list1 = new ArrayList<String>();
        Collections.addAll(list1, arr);
        for (int i = 0; i < n; i++) {
            list1.remove(0);
        }
        return list1.toString();
    }
    
    public void deleteStudent(int id){
        ListStudents.remove(id);
    }

    public HashMap<Integer, Student> getAllStudents(){
        return ListStudents;
    }

    @Override
    public String toString() {
        return ListStudents.toString();
    }
}