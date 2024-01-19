import java.util.ArrayList;

public class PlayerHero extends Hero {

  // Variables and attributes every PlayerHero has
  private String heroName;
  private String heroRace;
  private String heroGender;
  private String heroClass;
  private String heroAlignment;

  // Constructor for PlayerHero
  public PlayerHero(int heroHealth, int heroLevel, int heroExp, ArrayList<Item> inventory, String heroName,
      String heroRace, String heroGender, String heroClass, String heroAlignment) {

    super(heroHealth, heroLevel, heroExp, inventory);

    this.heroName = heroName;
    this.heroRace = heroRace;
    this.heroGender = heroGender;
    this.heroClass = heroClass;
    this.heroAlignment = heroAlignment;
    heroHealth = 100;
  }

  // Getters and setter methods for PlayerHero
  public String getHeroName() {
    return heroName;
  }

  public String getHeroRace() {
    return heroRace;
  }

  public String getHeroGender() {
    return heroGender;
  }

  public String getHeroClass() {
    return heroClass;
  }

  public String getHeroAlignment() {
    return heroAlignment;
  }

  public void setHeroName(String heroName) {
    this.heroName = heroName;
  }

  public void setHeroRace(String heroRace) {
    this.heroRace = heroRace;
  }

  public void setHeroGender(String heroGender) {
    this.heroGender = heroGender;
  }

  public void setHeroClass(String heroClass) {
    this.heroClass = heroClass;
  }

  public void setHeroAlignment(String heroAlignment) {
    this.heroAlignment = heroAlignment;
  }

  // Overridden method that uses a loop to print the contents of PlayerHero
  // inventory
  @Override
  public void checkInventory() {
    System.out.println("\nYour inventory Contains:\n");

    for (int i = 0; i < this.inventory.size(); i++) {
      Item item = this.inventory.get(i);
      item.printItemInfo();
    }
  }

  // Overridden method that prints PlayerHero stats
  @Override
  public void checkStats() {
    System.out.println("\nYour health is: " + getHeroHealth() + "\n" + "Your level is: " + getHeroLevel() + "\n"
        + "You have " + getHeroExp() + " exp!\n");
  }

  // Overridden method that prints info about Playerhero
  @Override
  public void printHeroInfo() {
    System.out.println("\nYour character " + this.heroName + " is a(n) " + this.heroGender + " " + this.heroRace
        + " and is a(n) " + this.heroClass + " with " + this.heroAlignment + " alignment.\n");
  }
}
