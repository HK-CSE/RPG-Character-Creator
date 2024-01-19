import java.util.ArrayList;

public abstract class Hero{

  //Variables and attributes every Hero has
  private int heroHealth;
  private int heroLevel;
  private int heroExp;
  public ArrayList<Item> inventory = new ArrayList<>();

  //Constructor for Hero
  public Hero(int heroHealth, int heroLevel, int heroExp, ArrayList <Item> inventory){
    
    this.heroHealth = heroHealth;
    this.heroLevel = heroLevel;
    this.heroExp = heroExp;
    this.inventory = inventory;
  }
  
  //Getter and setter methods for Hero
  public int getHeroHealth(){
    return heroHealth;
  }

  public int getHeroLevel(){
    return heroLevel;
  }

  public int getHeroExp(){
    return heroExp;
  }

  public void setHeroHealth(int heroHealth){
    this.heroHealth = heroHealth;
  }

  public void setHeroLevel(int heroLevel){
    this.heroLevel = heroLevel;
  }

  public void setHeroExp(int heroExp){
    this.heroExp = heroExp;
  }

  public void addInventory(Item item){
    this.inventory.add(item);
  }

  //Methods every Hero has

  public abstract void checkInventory();

  public abstract void checkStats();

  public void printHeroInfo(){
    System.out.println("All hero characters have health, levels, exp, and an inventory.");
  }
}
