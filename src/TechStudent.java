import java.util.Date;
import java.util.LinkedList;

public class TechStudent extends Student{

    public TechStudent(int id, String name, String lastname, Date DatumNarozeni) {
        super(id, name, lastname, DatumNarozeni, "Technicka");
    }

    public TechStudent(int id, String name, String lastname, Date DatumNarozeni, LinkedList<Integer> grades) {
        super(id, name, lastname, DatumNarozeni, "Technicka", grades);
    }

    @Override
    public void Dovednosti() {
        System.out.println("Technicka skupina: ");
        System.out.println("Rok narozeni: " + super.yearFromDate() + " Je rok narozeni prestupny? " + jePrestupnyRok());
    }

    public boolean jePrestupnyRok() {
        int Rok = super.yearFromDate();
        return Student.prestupnyRok(Rok);
    }
}