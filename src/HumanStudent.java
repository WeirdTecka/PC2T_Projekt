import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class HumanStudent extends Student{

    public HumanStudent(int id, String name, String lastname, Date DatumNarozeni) {
        super(id, name, lastname, DatumNarozeni, "Humanitni");
    }

    public HumanStudent(int id, String name, String lastname, Date DatumNarozeni,
            LinkedList<Integer> grades) {
        super(id, name, lastname, DatumNarozeni, "Humanitni", grades);
    }

    @Override
    public void Dovednosti() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Humanitni skupina:");
        System.out.println("Narozen: " + sdf.format(getDatumNarozeni()) + " Znameni: " + getZnameniZverokruhu());
    }

    public String getZnameniZverokruhu(){
        int denNarozeni = super.monthFromDate();
        int mesicNarozeni = super.dayFromDate();
        return Student.znameniZverokruhu(denNarozeni, mesicNarozeni);
    }
    
}