package scrap.heap.refactor.beans;

/**
 * interface for CakeItem with getter on attributes
 * of Cake
 */
public interface CakeItem extends BirthDayItem{

    Size getSize();
    Color getColor();
    Flavor getFlavor();
    FrostingFlavor getFrostingFlavor();
    Shape getShape();

    // enums to define cake properties.
    // attributes in the property can be addded to these enums to
    // support more property for future need

    public static enum Color implements ItemProperty {
        BROWN("brown"),YELLOW("yellow");

        String value;
        Color(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }
    }

    public static enum Size implements ItemProperty {
        LARGE("large"),MED("med"),SMALL("small");

        String value;
        Size(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }

    }

    public static enum Shape implements ItemProperty {
        CIRCLE("circle"),SQUARE("square");

        String value;
        Shape(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }

    }
    public static enum Flavor implements ItemProperty {
        CHOCOLATE("chocolate"),VANILLA("vanilla");
        String value;

        Flavor(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }
    }
    public static enum FrostingFlavor implements ItemProperty {
        CHOCOLATE("chocolate"),VANILLA("vanilla");

        String value;

        FrostingFlavor(String value){
            this.value = value;
        }

        @Override
        public String getValue(){
            return value;
        }
    }
}
