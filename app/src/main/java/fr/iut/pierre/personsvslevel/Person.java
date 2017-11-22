package fr.iut.pierre.personsvslevel;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by lanoix-a on 13/11/2017.
 */

public class Person {

    private final static String DEFAULT_PROFIL = "Metuentes igitur idem latrones Lycaoniam " +
            "magna parte campestrem cum se inpares nostris fore congressione stataria documentis" +
            " frequentibus scirent, tramitibus deviis petivere Pamphyliam diu quidem intactam" +
            " sed timore populationum et caedium, milite per omnia diffuso propinqua, magnis" +
            " undique praesidiis conmunitam.";


    String name;
    Level level;
    String profil;

    public Person(String name, Level level) {
        this.name = name;
        this.level = level;
        this.profil = DEFAULT_PROFIL;
    }

    public Person(String name) {
        this(name, Level.BEGINNER);
    }

    public String getName() {
        return name;
    }

    public String getFirstLetter() {
        return name.toUpperCase().substring(0,1);
    }

    public Level getLevel() {
        return level;
    }

    public String getShortProfil() {
        int limit = 50;
        if (profil.length() < limit) {
            limit = profil.length();
        }
        return profil.substring(0,limit);
    }


    @Override
    public String toString() {
        return name + " (" + level + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return level == person.level;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }

    public static ArrayList<Person> initPersons() {
        ArrayList<Person> list = new ArrayList<Person>();

        String[] names = new String[]{
                "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
                "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
                "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
                "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
                "Yann", "Zoé"
        };

        for (int i = 0; i < names.length; i++) {
            Level l = Level.BEGINNER;
            if (i % 3 == Level.USER.getVal())
                l = Level.USER;
            else if (i %3 == Level.EXPERT.getVal())
                    l = Level.EXPERT;

            list.add(new Person(names[i], l));
        }
        return list;
    }

    enum Level {
        BEGINNER(0, Color.RED),
        USER(1, Color.BLUE),
        EXPERT(2, Color.GREEN);

        private int val = 0;
        private int col;

        Level(int val, int col) {
            this.val = val;
            this.col = col;
        }

        int getVal() {
            return val;
        }

        int getColor() {
            return col;
        }
    }


    public static final Comparator<Person> LEVEL_PRIORITY = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1.level.getVal() != o2.level.getVal()) {
                return o1.level.getVal() - o2.level.getVal();
            }
            else {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
            }
        }
    };


    public static final Comparator<Person> NAME_PRIORITY = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            int comp = String.CASE_INSENSITIVE_ORDER.compare(p1.name, p2.name);
            if (comp == 0) {
                return p1.level.getVal() - p2.level.getVal();
            }
            return comp;
        }
    };
}






