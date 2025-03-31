public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];  
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + disc.getTitle());
        } else {
            System.out.println("Giỏ hàng đã đầy, không thể thêm đĩa.");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa phần tử cuối
                qtyOrdered--;
                System.out.println("Đĩa đã được xóa: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa trong giỏ hàng.");
        }
    }
    //14.2
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
        }else{
            System.out.println("The cart is almost full!");
        }
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
        }else{
            System.out.println("The cart is almost full!");
        }
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
