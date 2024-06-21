package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.PurchaseOrderBOImpl;
import com.example.layeredarchitecture.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}
    public static BOFactory getBoFactory(){
        return (boFactory==null) ? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,ORDER_DETAIL
    }

    public SuperBO getBO(BOTypes boTypes){

        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER_DETAIL:
                return new PurchaseOrderBOImpl();
            default:
                return null;

        }
    }
}
