package book4.ch6;

import javax.swing.plaf.SeparatorUI;
import java.util.ArrayList;
import java.util.OptionalDouble;

public class Spell
{
    public String name;
    public SpellType type;
    public String description;
    public int price;

    public enum SpellType
    {SPELL, CHARM, CURSE}

    public Spell(String spellName, SpellType spellType, String spellDescription, int spellPrice)
    {
        name = spellName;
        type = spellType;
        description = spellDescription;
        this.price = spellPrice;
    }

    @Override
    public String toString()
    {
        return
                "Name = '" + name + '\'' +
                        ", Type = " + type +
                        ", Description = '" + description + '\'' +
                        "Price : " + price
                ;
    }

    public static void main(String[] args)
    {
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(new Spell("Aparecium", Spell.SpellType.SPELL, "Makes invisible ink appear.", 20));

        spells.add(new Spell("Avis", Spell.SpellType.SPELL, "Launches birds from your wand.", 10));

        spells.add(new Spell("Engorgio", Spell.SpellType.CHARM, "Enlarges something.", 50));

        spells.add(new Spell("Fidelius", Spell.SpellType.CHARM, "Hides a secret within someone.", 100));

        spells.add(new Spell("Finite Incatatum", Spell.SpellType.SPELL, "Stops all current spells.", 40));

        spells.add(new Spell("Locomotor Mortis", Spell.SpellType.CURSE, "Locks an opponent's legs.", 65));


//        for (Spell spell : spells)
//        {
//            System.out.println(spell);
//        }



//   //    Only printing spells
//        spells.stream().forEach(s -> System.out.println(s));

//        for (Spell spell : spells)
//        {
//            if (spell.type == SpellType.SPELL)
//            {
//                System.out.println(spell);
//            }
//
//        }


// //    Same output as above just using stream
//        spells.stream().filter(s -> s.type == SpellType.SPELL)
//                .forEach(s -> System.out.println(s));


//        spells.stream()
//                .filter(s -> s.type == Spell.SpellType.SPELL)
//                .filter(s -> s.name.toLowerCase().startsWith("a"))
//                .forEach(s -> System.out.println(s));
//*/

//        double count = spells.stream()
//                .filter(s -> s.type == SpellType.SPELL)
//                .filter(s -> s.name.toLowerCase().startsWith("a"))
//                .mapToDouble(s -> s.price)
//                .count();
//        System.out.println("There are " + count + " spells !");


//        OptionalDouble avg = spells.stream()
//                .mapToDouble(s -> s.price)
//                .average();
//
//        if (avg.isPresent())
//        {
//            System.out.println("The average price of the spells are " + avg.getAsDouble());
//        }


        System.out.println("First Parallel Stream");
        spells.parallelStream()
                .forEach(s -> System.out.println(s));
        System.out.println("\nSecond Parallel Stream");
        spells.parallelStream()
                .forEach(s -> System.out.println(s));
        System.out.println("\nThird Parallel Stream");
        spells.parallelStream()
                .forEach(s -> System.out.println(s));


    }

}
