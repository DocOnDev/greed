package docondev;

public class SetFactory {
    public static DiceSet getSet(Integer[] value) {
        switch(value.length){
            case 3: return new DiceSetTriple(value);
            case 4: return new DiceSetQuad(value);
            case 5: return new DiceSetQuint(value);
            case 6: return new DiceSetSect(value);
            default: return new DiceSetSingle(value);
        }
    }
}
