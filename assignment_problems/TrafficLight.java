public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Default starting color
    }

    public void next() {
        if ("RED".equals(this.color)) {
            this.color = "GREEN";
        } else if ("GREEN".equals(this.color)) {
            this.color = "YELLOW";
        } else if ("YELLOW".equals(this.color)) {
            this.color = "RED";
        }
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }
}