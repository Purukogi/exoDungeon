package items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private static HashMap<String, Item> EQUIPMENT = new HashMap<>();

    static {
        EQUIPMENT.put("Armour", null);
        EQUIPMENT.put("Boots", null);
        EQUIPMENT.put("Weapon 1", null);
        EQUIPMENT.put("Weapon 2", null);
        EQUIPMENT.put("Ring 1", null);
        EQUIPMENT.put("Ring 2", null);
    }

    public void addItem(Item item){

        String itemType = item.getClass().getSimpleName();

        //for now we autoequip the most recent item
        switch (itemType){
            case("Armour") -> {EQUIPMENT.put("Armour", item);}
            case("Boots") -> {EQUIPMENT.put("Boots", item);}
            case("Weapon") -> {
                if(EQUIPMENT.get("Weapon 1") == null){
                    EQUIPMENT.put("Weapon 1", item);
                }else if (!((Weapon) item).isTwoHanded()){
                    if(((Weapon) EQUIPMENT.get("Weapon 1")).isTwoHanded()){
                        EQUIPMENT.put("Weapon 1", item);
                    }else{
                        EQUIPMENT.put("Weapon 2", item);
                    }
                }else{
                    //add a confirmation of swap
                    //for now we force swap
                    EQUIPMENT.put("Weapon 1", item);
                    EQUIPMENT.put("Weapon 2", null);
                }
            }
            case("Ring") -> {
                if(EQUIPMENT.get("Ring 1") == null){
                    EQUIPMENT.put("Ring 1", item);
                }else if(EQUIPMENT.get("Ring 2") == null) {
                    EQUIPMENT.put("Ring 2", item);
                }else{
                    //add a swap choice
                    //for now the oldest ring is discarded
                    EQUIPMENT.put("Ring 1", EQUIPMENT.get("Ring 2"));
                    EQUIPMENT.put("Ring 2", item);
                }
            }
        }

    }

    public HashMap<String, Item> getEquipment() {
        return EQUIPMENT;
    }

    public void setEquipment(HashMap<String, Item> equipment) {
        EQUIPMENT = equipment;
    }

    @Override
    public String toString(){
        String result = "";
        for(String key : EQUIPMENT.keySet()){
            if(EQUIPMENT.get(key) != null){
                result += key + ": " + EQUIPMENT.get(key) + "\n";
            }else{
                result += key + ": none\n";
            }
        }
        return result;
    }
}
