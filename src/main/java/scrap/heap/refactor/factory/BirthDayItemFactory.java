package scrap.heap.refactor.factory;

import scrap.heap.refactor.beans.BirthDayItem;
import scrap.heap.refactor.beans.ItemProperty;
import scrap.heap.refactor.beans.ItemType;

import java.util.List;

public interface BirthDayItemFactory {
    List<BirthDayItem> build(ItemType itemType , List<ItemProperty> properties , int count);
}
