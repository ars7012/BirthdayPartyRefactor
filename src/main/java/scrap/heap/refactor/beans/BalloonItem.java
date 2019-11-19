package scrap.heap.refactor.beans;

/**
 * Interface for BalloonItem
 */
public interface BalloonItem extends BirthDayItem{

    Color getColor();
    Material getMaterial();

    // enums to define balloon properties.
    // attributes in the property can be addded to these enums to
    // support more property for future need
    public static enum Color implements ItemProperty {
        RED("red"),BLUE("blue"),YELLOW("yellow");

        String value;
        Color(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }
    }
    public static enum Material implements ItemProperty {
        MYLAR("mylar"),LATEX("latex");

        String value;
        Material(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }
    }
}
