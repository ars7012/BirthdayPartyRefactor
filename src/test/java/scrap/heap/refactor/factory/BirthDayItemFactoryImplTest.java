package scrap.heap.refactor.factory;

import org.junit.Test;
import scrap.heap.refactor.beans.*;
import scrap.heap.refactor.factory.impl.BirthDayItemFactoryImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BirthDayItemFactoryImplTest {
    BirthDayItemFactoryImpl impl = new BirthDayItemFactoryImpl();

    @Test
    public void buildItemTypeNull(){
        List<ItemProperty> propertyList = new ArrayList<ItemProperty>();
        List<BirthDayItem> items = impl.build(null , propertyList, 10);
        assertNull(items);
    }

    @Test
    public void buildBalloons(){
        List<ItemProperty> properties = new ArrayList<>();
        String color = "red";
        String material = "mylar";
        BalloonItem.Color colorEnum = Enum.valueOf(BalloonItem.Color.class,color.toUpperCase());
        BalloonItem.Material materialEnum = Enum.valueOf(BalloonItem.Material.class,material.toUpperCase());

        properties.add(colorEnum);
        properties.add(materialEnum);

        int count =2;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.BALLOON, properties, count);
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            BalloonItem balloon = (BalloonItem)item;
            assertEquals(balloon.getColor().getValue() , color);
            assertEquals(balloon.getMaterial().getValue() ,material);
        }
    }

    @Test
    public void buildBalloonZeroCount(){
        List<ItemProperty> properties = new ArrayList<>();
        String color = "red";
        String material = "mylar";
        BalloonItem.Color colorEnum = Enum.valueOf(BalloonItem.Color.class,color.toUpperCase());
        BalloonItem.Material materialEnum = Enum.valueOf(BalloonItem.Material.class,material.toUpperCase());

        properties.add(colorEnum);
        properties.add(materialEnum);

        int count =0;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.BALLOON, properties, count);
        assertEquals(count, balloons.size() );

    }

    @Test
    public void buildBalloonWithEmptyProperties(){
        List<ItemProperty> properties = new ArrayList<>();

        int count =5;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.BALLOON, properties, count);
        assertEquals(count, balloons.size() );
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            BalloonItem balloon = (BalloonItem)item;
            assertEquals(balloon.getColor().getValue() , BalloonItem.Color.BLUE.getValue());
            assertEquals(balloon.getMaterial().getValue() , BalloonItem.Material.LATEX.getValue());
        }
    }

    @Test
    public void buildBalloonWithNullProperties(){
        List<ItemProperty> properties = new ArrayList<>();

        int count =5;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.BALLOON, null, count);
        assertEquals(count, balloons.size() );
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            BalloonItem balloon = (BalloonItem)item;
            assertEquals(balloon.getColor().getValue() , BalloonItem.Color.BLUE.getValue());
            assertEquals(balloon.getMaterial().getValue() , BalloonItem.Material.LATEX.getValue());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildBalloonsError(){
        List<ItemProperty> properties = new ArrayList<ItemProperty>();
        String color = "white";
        String material = "mylar";
        BalloonItem.Color colorEnum = Enum.valueOf(BalloonItem.Color.class,color.toUpperCase());
        BalloonItem.Material materialEnum = Enum.valueOf(BalloonItem.Material.class,material.toUpperCase());

        properties.add(colorEnum);
        properties.add(materialEnum);

        int count =2;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.BALLOON, properties, count);
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            BalloonItem balloon = (BalloonItem)item;
            assertEquals(balloon.getColor().getValue() , color);
            assertEquals(balloon.getMaterial().getValue() ,material);
        }
    }

    @Test
    public void buildCakes(){
        List<ItemProperty> properties = new ArrayList<>();
        String color = "brown";
        String shape = "circle";
        String flavor ="chocolate";
        String frostingFlavor = "chocolate";
        String size ="med";

        CakeItem.Size sizeEnum =  Enum.valueOf(CakeItem.Size.class,size.toUpperCase());
        CakeItem.Shape shapeEnum = Enum.valueOf(CakeItem.Shape.class,shape.toUpperCase());
        CakeItem.Flavor flavorEnum =Enum.valueOf(CakeItem.Flavor.class,flavor.toUpperCase());
        CakeItem.FrostingFlavor frostingFlavorEnum = Enum.valueOf(CakeItem.FrostingFlavor.class,frostingFlavor.toUpperCase());
        CakeItem.Color colorEnum =Enum.valueOf(CakeItem.Color.class,color.toUpperCase());

        properties.add(sizeEnum);
        properties.add(flavorEnum);
        properties.add(flavorEnum);
        properties.add(shapeEnum);
        properties.add(colorEnum);
        properties.add(frostingFlavorEnum);
        int count =2;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.CAKE, properties, count);
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            CakeItem cake = (CakeItem)item;
            assertEquals(color, cake.getColor().getValue() );
            assertEquals(size, cake.getSize().getValue() );
            assertEquals(shape, cake.getShape().getValue() );
            assertEquals(frostingFlavor, cake.getFrostingFlavor().getValue());
            assertEquals(flavor, cake.getFlavor().getValue());
        }
    }

    @Test
    public void buildCakesEmptyProperty(){
        List<ItemProperty> properties = new ArrayList<>();

        String color = "brown";
        String shape = "circle";
        String flavor ="chocolate";
        String frostingFlavor = "chocolate";
        String size ="small";


        int count =2;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.CAKE, properties, count);
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            CakeItem cake = (CakeItem)item;
            assertEquals(color, cake.getColor().getValue() );
            assertEquals(size, cake.getSize().getValue() );
            assertEquals(shape, cake.getShape().getValue() );
            assertEquals(frostingFlavor, cake.getFrostingFlavor().getValue());
            assertEquals(flavor, cake.getFlavor().getValue());
        }
    }

    @Test
    public void buildCakesNullProperty(){
        List<ItemProperty> properties = new ArrayList<>();

        String color = "brown";
        String shape = "circle";
        String flavor ="chocolate";
        String frostingFlavor = "chocolate";
        String size ="small";


        int count =2;

        List<BirthDayItem> balloons = BirthDayItemFactoryInstance.getInstance().build(ItemType.CAKE, null, count);
        assertEquals(balloons.size() , count);
        for( BirthDayItem item : balloons){
            CakeItem cake = (CakeItem)item;
            assertEquals(color, cake.getColor().getValue() );
            assertEquals(size, cake.getSize().getValue() );
            assertEquals(shape, cake.getShape().getValue() );
            assertEquals(frostingFlavor, cake.getFrostingFlavor().getValue());
            assertEquals(flavor, cake.getFlavor().getValue());
        }
    }


}
