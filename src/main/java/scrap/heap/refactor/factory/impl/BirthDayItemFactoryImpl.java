package scrap.heap.refactor.factory.impl;

import scrap.heap.refactor.beans.*;
import scrap.heap.refactor.factory.BirthDayItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * BirthDayItemFactory to build birthDayItem. It supports to build
 * cake and balloon items.
 */
public class BirthDayItemFactoryImpl implements BirthDayItemFactory {


    /**
     * returns list of items (balloon or cake) as per itemType paramaters
     * @param itemType
     * @param properties
     * @param count
     * @return list of supported items or null
     */
    @Override
    public List<BirthDayItem> build(ItemType itemType, List<ItemProperty> properties, int count) {

        if( ItemType.BALLOON.equals(itemType)){
            return buildBalloon(properties, count);
        }
        if( ItemType.CAKE.equals(itemType)){
            return buildCake(properties, count);
        }
        return null;

    }

    /*
      method to build balloon items
     */
    private List<BirthDayItem> buildBalloon(List<ItemProperty> properties , int count) {
        List<BirthDayItem> items = new ArrayList<>();
        BalloonItem.Color color = null;
        BalloonItem.Material material = null;
        if( properties!=null) {
            for (ItemProperty property : properties) {
                if (property instanceof BalloonItem.Color) {
                    color = (BalloonItem.Color) property;
                }
                if (property instanceof BalloonItem.Material) {
                    material = (BalloonItem.Material) property;
                }
            }
        }
        for(int i = 0 ; i < count ; i++){
            BalloonItem item = new Balloon.BalloonBuilder().color(color).material(material).build();
            items.add(item);
        }
        return items;
    }


    /*
      Method to build cake item
     */
    private List<BirthDayItem> buildCake( List<ItemProperty> properties , int count){
        CakeItem.Size size = null;
        CakeItem.Shape shape = null;
        CakeItem.Color color  = null;
        CakeItem.Flavor flavor = null;
        CakeItem.FrostingFlavor frostingFlavor = null;
        if( properties!=null) {
            for (ItemProperty property : properties) {
                if (property instanceof CakeItem.Size) {
                    size = (CakeItem.Size) property;
                }
                if (property instanceof CakeItem.Color) {
                    color = (CakeItem.Color) property;
                }
                if (property instanceof CakeItem.Flavor) {
                    flavor = (CakeItem.Flavor) property;
                }
                if (property instanceof CakeItem.FrostingFlavor) {
                    frostingFlavor = (CakeItem.FrostingFlavor) property;
                }
                if (property instanceof CakeItem.Shape) {
                    shape = (CakeItem.Shape) property;
                }
            }
        }
        List<BirthDayItem> items = new ArrayList<>();
        for(int i = 0 ; i < count ; i++){
            CakeItem item = new Cake.CakeBuilder(size)
                    .shape(shape)
                    .color(color)
                    .flavor(flavor)
                    .frostingFlavor(frostingFlavor)
                    .build();

            items.add(item);
        }
        return items;
    }
}
