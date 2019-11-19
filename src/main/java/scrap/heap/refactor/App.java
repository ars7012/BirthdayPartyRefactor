package scrap.heap.refactor;

import scrap.heap.refactor.beans.*;
import scrap.heap.refactor.factory.BirthDayItemFactory;
import scrap.heap.refactor.factory.BirthDayItemFactoryInstance;

import java.util.ArrayList;
import java.util.List;

public class App {

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

         //Place birthday party orders
         order("red", "mylar", "4", "chocolate", "chocolate", "circle", "large", "brown" );
         order("blue", "latex", "7", "Vanilla", "chocolate", "square", "med", "brown" );
         order("yellow", "mylar", "4", "vanilla", "vanilla", "square", "small", "yellow" );

    }

    private static void order(String balloonColor, String material, String number, String flavor, String frostingFlavor, String shape, String size, String cakeColor){

        orderBalloons(balloonColor, material, number);

        orderCake(frostingFlavor, flavor, shape, size, cakeColor);
    }

    private static void orderBalloons(String balloonColor, String material, String number){

        try {
            List<ItemProperty> properties = new ArrayList<ItemProperty>();
            BalloonItem.Color colorEnum = Enum.valueOf(BalloonItem.Color.class, balloonColor.toUpperCase());
            BalloonItem.Material materialEnum = Enum.valueOf(BalloonItem.Material.class, material.toUpperCase());

            properties.add(colorEnum);
            properties.add(materialEnum);

            List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.BALLOON, properties, 1);

            for( BirthDayItem item : balloons){
                BalloonItem balloon = (BalloonItem)item;
                System.out.println( "Balloon ordered --> color :" + balloon.getColor()  + " size : " + balloon.getMaterial() );
            }

        }catch (IllegalArgumentException exc){
            System.out.println(" property value is not supported " + exc.getMessage());
            throw exc;
        }catch (Exception e){
            System.out.println(" property value is not supported " + e.getMessage());
            throw e;
        }
        System.out.println("Balloons ordered; " + balloonColor + ", " + material  + ", " + number);

    }

    private static void orderCake(String flavor, String frostingFlavor, String shape, String size, String cakeColor){


        try {
            List<ItemProperty> properties = new ArrayList<ItemProperty>();
            CakeItem.Size sizeEnum =  Enum.valueOf(CakeItem.Size.class,size.toUpperCase());
            CakeItem.Shape shapeEnum = Enum.valueOf(CakeItem.Shape.class,shape.toUpperCase());
            CakeItem.Flavor flavorEnum =Enum.valueOf(CakeItem.Flavor.class,flavor.toUpperCase());
            CakeItem.FrostingFlavor frostingFlavorEnum = Enum.valueOf(CakeItem.FrostingFlavor.class,frostingFlavor.toUpperCase());
            CakeItem.Color colorEnum =Enum.valueOf(CakeItem.Color.class,cakeColor.toUpperCase());

            properties.add(sizeEnum);
            properties.add(flavorEnum);
            properties.add(flavorEnum);
            properties.add(shapeEnum);
            properties.add(colorEnum);
            properties.add(frostingFlavorEnum);
            List<BirthDayItem> cakes = BirthDayItemFactoryInstance.getInstance().build(ItemType.CAKE, properties, 1);

            for( BirthDayItem item : cakes){
                CakeItem cake = (CakeItem)item;
                System.out.println( "cake ordered --> color :" + cake.getColor()  + " size : " + cake.getSize() + " shape : " + cake.getShape());
            }

        }catch (IllegalArgumentException exc){
            System.out.println(" property value is not supported " + exc.getMessage());
            throw exc;
        }catch (Exception e){
            System.out.println(" property value is not supported " + e.getMessage());
            throw e;
        }


    }

}
