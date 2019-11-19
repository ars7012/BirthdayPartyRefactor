package scrap.heap.refactor.beans;
/**
 * Cake class to implement CakeItem
 * with color and material attributes. This class
 * can be constructed using BalloonBuilder.
 */
public class Cake implements CakeItem{

    Size size;
    Color color;
    Flavor flavor;
    FrostingFlavor frostingFlavor;
    Shape shape;

    private Cake (Size size){
        this.size = size;
    }

    @Override
    public ItemType getType() {
        return ItemType.CAKE;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Flavor getFlavor() {
        return flavor;
    }

    @Override
    public FrostingFlavor getFrostingFlavor() {
        return frostingFlavor;
    }

    @Override
    public Shape getShape() {
        return shape;
    }


    public static class CakeBuilder{
        Size size;
        Shape shape;
        Color color;
        Flavor flavor;
        FrostingFlavor frostingFlavor;

        public CakeBuilder( Size size){
            this.size = size;
        }

        public CakeBuilder color(Color color){
            this.color = color;
            return  this;
        }
        public CakeBuilder flavor(Flavor flavor){
            this.flavor = flavor;
            return  this;
        }
        public CakeBuilder frostingFlavor(FrostingFlavor frostingFlavor){
            this.frostingFlavor = frostingFlavor;
            return  this;
        }
        public CakeBuilder shape(Shape shape){
            this.shape = shape;
            return this;
        }

        public Cake build(){
            // null value is set to Default property
            Cake cake = new Cake(this.size==null ? Size.SMALL : this.size);
            cake.flavor = this.flavor == null ? Flavor.CHOCOLATE : this.flavor;
            cake.color = this.color ==null ? Color.BROWN : this.color;
            cake.frostingFlavor = this.frostingFlavor == null ? FrostingFlavor.CHOCOLATE : this.frostingFlavor;
            cake.shape = this.shape == null ? Shape.CIRCLE : this.shape;
            return cake;
        }
    }



}
