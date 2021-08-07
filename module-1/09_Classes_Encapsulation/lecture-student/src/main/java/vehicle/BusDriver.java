package vehicle;

public class BusDriver {

    public static void main(String[] args) {
        Bus busOne = new Bus();
        busOne.setRouteName("Third to Fifth");
        System.out.println(busOne.getGallonsOfGas());

        busOne.openDoor();

        System.out.println(busOne.getRemainingSeats());
        busOne.board(4);
        busOne.closeDoor();
        System.out.println(busOne.getRemainingSeats());
    }
}
