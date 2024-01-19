public class Item {

  // Variables Item uses
  private String name;
  private int value;
  private String description;

  // Constructor for Item
  public Item(String name, int value, String description) {
    this.name = name;
    this.value = value;
    this.description = description;
  }

  // Getters and setter methods for Item
  public String getName() {
    return this.name;
  }

  public int getValue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }

  public void setValue(int val) {
    this.value = val;
  }

  public void setDescription(String desc) {
    this.description = desc;
  }

  // Method that prints information related to Items in PlayerHero inventory
  public void printItemInfo(){

  // Fancy desc formatting
    System.out.println("----" + this.name + "----\n" + "Value: " + this.value + "g" + " \nDescription: " + this.description + "\n" + "-".repeat(this.name.length() + 8) + "\n");
  }
}