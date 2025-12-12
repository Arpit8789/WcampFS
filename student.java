import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class Student1 {
    private String id,name;
    private int marks;

    public Student1 (String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }

    public String getrole()
    {
        return "Undergrad";

    }
    @Override

    public String toString() {
        return id + " - " + name + " ( " + marks + " ) " + getrole();
    }
}
class GraduateStudent extends Student1 {

    private String area;
    public GraduateStudent (String id, String name, int marks,String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getrole()
    {
        return "Grad (" + area + ")";

    }
}
class HonourStudent extends Student1 {
    private int bonusMarks;

    public HonourStudent(String id, String name, int marks, int bonusMarks) {
        super(id, name, marks);
        this.bonusMarks = bonusMarks;
    }

    public int getBonusMarks() {
        return bonusMarks;
    }

    @Override
    public int getMarks() {
        return super.getMarks() + bonusMarks;
    }

    @Override
    public String getrole() {
        return "Honour";
    }

    @Override
    public String toString() {
        return super.toString() + " [bonus=" + bonusMarks + "]";
    }
}
class Repository <T>
{
    private Map<String ,T> data = new HashMap<>();

    public void save (String id , T obj)
    {
        data.put(id , obj);
    }
    public T find (String id)
    {
        return data.get(id);
    }
    public void delete (String id)
    {
        data.remove(id);
    }

}

public class student {
    

    public static void main (String[] args)
    {
        List<Student1> list = new ArrayList<>();
        list.add (new Student1 ("S1" , "Amrit" , 75));
        list.add(new Student1 ("S2" , "Anand" , 90));
        list.add(new Student1("S3", "Arpit", 100));
        list.add(new HonourStudent("H1", "Tapesh Sir", 88, 5));
        list.add(new GraduateStudent("G1", "Ansh sir", 95 , "Spring boot"));


        Repository<Student1> repo = new Repository<>();
        for (Student1 s : list)
        {
            repo.save(s.getId() , s);
        }
        System.out.println("ALL: ");
        list.forEach(System.out::println);
        System.out.println("topper: ");
        Student1 topper = null;
        for (Student1 s : list)
        {
            if (topper == null || s.getMarks() > topper.getMarks())
            {
                topper = s;
            }
        }
        System.out.println(topper);
        
        

        System.out.println("\n LOOKUP S2: ");
        Student1 s = repo.find("S2");
        System.out.println(s != null ? s : "NOT FOUND");

        Iterator<Student1> it = list.iterator();
        while (it.hasNext())
        {
            Student1 st = it.next();

            if (st.getMarks() < 80)
            {
                it.remove();
                repo.delete(st.getId());
            }
        }
        System.out.println("\n AFTER REMOVAL: ");
        list.forEach(System.out::println);
    }
}