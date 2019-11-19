package scrap.heap.refactor.beans;

/**
 * Balloon class to implement BalloonItem
 * with color and material attributes. This class
 * can be constructed using BalloonBuilder.
 */
public class Balloon implements BalloonItem {

    Color color;
    Material material;

    @Override
    public ItemType getType() {
        return ItemType.BALLOON;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    public static class BalloonBuilder{

        Color color;
        Material material;

        public BalloonBuilder( ){

        }

        public BalloonBuilder color(Color color){
            this.color = color;
            return  this;
        }
        public BalloonBuilder material(Material material){
            this.material = material;
            return  this;
        }


        public Balloon build(){
            Balloon balloon = new Balloon();
            if( this.color!=null) {
                balloon.color = color;
            }else{
                // set default color to green if not specified
                balloon.color = Color.BLUE;
            }

            if( this.material!=null) {
                balloon.material = material;
            }else{
                // set default material to latex if not specified
                balloon.material = Material.LATEX;
            }
            return balloon;
        }
    }
}
