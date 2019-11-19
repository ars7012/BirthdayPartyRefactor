package scrap.heap.refactor.factory;

import scrap.heap.refactor.factory.impl.BirthDayItemFactoryImpl;

/**
 * Singleton class for BirthDayItemFactory
 */
public class BirthDayItemFactoryInstance {
    private static BirthDayItemFactory instance;

    private BirthDayItemFactoryInstance(){}

    /**
     * returns singletonInstance of BirthDayItemFactoryInstance
     * @return
     */
    public static synchronized BirthDayItemFactory getInstance(){
        if(instance == null){
            synchronized (BirthDayItemFactoryInstance.class) {
                if(instance == null){
                    instance = new BirthDayItemFactoryImpl();
                }
            }
        }
        return instance;
    }
}