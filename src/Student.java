import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public abstract class Student implements Comparable<Student>{

    private int Id;
    private String Name;
    private String LastName;
    private Date DatumNarozeni;
    private String Skupina;
    private LinkedList<Integer> grades = new LinkedList<>();

    public enum Znameni {
        Kozoroh, Vodnar, Ryby, Beran, Byk, Blizenec, Rak, Lev, Panna, Vahy, Stir, Strelec
    }

    public Student(int id, String name, String lastname, Date DatumNarozeni, String skupina) {
        this.Id = id;
        this.Name = name;
        this.LastName = lastname;
        this.DatumNarozeni = DatumNarozeni;
        this.Skupina = skupina;
    }

    public Student(int id, String name, String lastname, Date DatumNarozeni, String skupina, LinkedList<Integer> grades) {
        this.Id = id;
        this.Name = name;
        this.LastName = lastname;
        this.DatumNarozeni = DatumNarozeni;
        this.Skupina = skupina;
        this.grades = grades;
    }

    public void setGrades(LinkedList<Integer> grades) {
        this.grades = grades;
    }

    public LinkedList<Integer> getGrades(){
        return grades;
    }

    public void addGrade(int grade){ 
        this.grades.add(grade);
    }

    public double getGradeAverage(){
        double average;
        try{
            double totalGrades = 0.0;
            for (int i = 0; i < grades.size(); i++) {
                totalGrades += grades.get(i);
            }
            average = (double) totalGrades / grades.size();
        }
        catch (NullPointerException e){
            average =0;
        }
        return average;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public Date getDatumNarozeni() {
        return DatumNarozeni;
    }

    public String getSkupina() {
        return Skupina;
    }

    public abstract void Dovednosti();

    public static boolean prestupnyRok(int year) {
        return ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0));
    }

    public static String znameniZverokruhu(int denNarozeni, int mesicNarozeni) {
        switch (mesicNarozeni) {
            case 1: 
                if (denNarozeni < 20) 
                return Znameni.Kozoroh.toString();
                else
                     return Znameni.Vodnar.toString();
            case 2:
                if (denNarozeni < 19)
                    return Znameni.Vodnar.toString();
                else
                    return Znameni.Ryby.toString();
            case 3:
                    if (denNarozeni < 21)
                    return Znameni.Ryby.toString();
                else
                    return Znameni.Beran.toString();
            case 4:
                    if (denNarozeni < 20)
                    return Znameni.Beran.toString();
                else
                    return Znameni.Byk.toString();
            case 5:
                    if (denNarozeni < 21)
                    return Znameni.Byk.toString();
                else
                    return Znameni.Blizenec.toString();
            case 6:
                    if (denNarozeni < 21)
                    return Znameni.Blizenec.toString();
                else
                    return Znameni.Rak.toString();
            case 7:
                    if (denNarozeni < 23)
                    return Znameni.Rak.toString();
                else
                    return Znameni.Lev.toString();
            case 8:
                if (denNarozeni < 23)
                    return Znameni.Lev.toString();
                else
                    return Znameni.Panna.toString();
            case 9:
                if (denNarozeni < 23)
                    return Znameni.Panna.toString();
            else
                    return Znameni.Vahy.toString();
            case 10:
                    if (denNarozeni < 23)
                    return Znameni.Vahy.toString();
                else
                    return Znameni.Stir.toString();
            case 11:
                    if (denNarozeni < 22)
                    return Znameni.Stir.toString();
                else
                    return Znameni.Strelec.toString();
            case 12:
                    if (denNarozeni < 22)
                    return Znameni.Strelec.toString();
                else
                    return Znameni.Kozoroh.toString();
            default:
                    return null;
            }
    }   

    protected int yearFromDate(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdf1.format(DatumNarozeni));
        return year;
    }

    protected int monthFromDate(){
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
        int month = Integer.parseInt(sdf2.format(DatumNarozeni));
        return month;
    }

    protected int dayFromDate(){
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM"); //schvalne naopak
        int day = Integer.parseInt(sdf3.format(DatumNarozeni));
        return day;
    }
    
    public String toFile(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return Id +
                ", " + Name +
                ", " + LastName  +
                ", " + sdf.format(DatumNarozeni) +
                ", " + Skupina +
                ", " + grades.toString();
    }

   @Override
    public int compareTo(Student o) {
        return LastName.compareTo(o.getLastName());
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "ID: " + Id +
                ", Jmeno: " + Name +
                ", Prijmeni: " + LastName  +
                ", Datum narozeni: " + sdf.format(DatumNarozeni) +
                ", Skupina: " + Skupina +
                ", Prumer: " + getGradeAverage();
    }
}
