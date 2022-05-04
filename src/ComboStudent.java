

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ComboStudent extends Student{

    public ComboStudent(int id, String name, String lastname, Date DatumNarozeni) {
        super(id, name, lastname, DatumNarozeni, "Kombinovana");
    }

    public ComboStudent(int id, String name, String lastname, Date DatumNarozeni,
            LinkedList<Integer> grades) {
        super(id, name, lastname, DatumNarozeni, "Kombinovana", grades);
    }

    @Override
    public void Dovednosti() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Kombinovana skupina:");
        System.out.println("Rok narozeni: " + super.yearFromDate() + " Je rok narozeni prestupny? " + jePrestupnyRok());
        System.out.println("Narozen: " + sdf.format(getDatumNarozeni()) + " Znameni: " + getZnameniZverokruhu());
    }

    public boolean jePrestupnyRok() {
        int Rok = super.yearFromDate();
        return Student.prestupnyRok(Rok);
    }

    public String getZnameniZverokruhu(){
        int denNarozeni = super.monthFromDate();
        int mesicNarozeni = super.dayFromDate();
        return Student.znameniZverokruhu(denNarozeni, mesicNarozeni);
    }
}