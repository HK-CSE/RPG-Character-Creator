import java.util.Scanner; 
import java.lang.System;
import java.util.ArrayList;
import java.util.Random;   

class Main {
  //Throws exception when name is 1 character long, or when anything other than letters are input
  public static void InvalidNameException(String Name)throws Exception{
    if(Name.length() == 1 || !(Name.matches("[a-zA-Z]+"))){
            throw new Exception("Invalid Name:" + Name + "\nNames must be longer than 1 character, and contain only letters!");
    }
  }

  //Method to generate a set of generalized starter items, as well as class-specific starter items
  public static void generateStarterItems(PlayerHero character){

    //Table of randomly assignable descriptions
    String[] randStartDesc = {"Made of solid gold!", "Enchanted by the Fae!", "Possessed by a demon!", "Blessed by a goddess!", "Infused with elemental essence!"};

    //Add potions to inventory regardless of class
    character.addInventory((new Item("Health Potion", 10, "Restores 25 HP")));
    character.addInventory((new Item("Mana Potion", 15, "Restores 50 MP")));

    //Retrieve hero class and break into switch statement to assign specific items for each class
    String classname = character.getHeroClass();
    String uniqueDesc;
    Random rn = new Random();

    switch(classname){
      case("Bard"):
      uniqueDesc = "A bard's magical instrument. " + randStartDesc[rn.nextInt( randStartDesc.length)];
      character.addInventory(new Item("Lute", 200, uniqueDesc));
      break;
  
      case("Fighter"):
        uniqueDesc = "A basic longsword. " + randStartDesc[rn.nextInt( randStartDesc.length)];
      character.addInventory(new Item("Sword", 150, uniqueDesc));
      break;
  
      case("Ranger"):
        uniqueDesc = "A fine longbow. " + randStartDesc[rn.nextInt( randStartDesc.length)];
      character.addInventory(new Item("Longbow", 250, uniqueDesc));
      break;
  
      case("Rogue"):
        uniqueDesc = "A set of throwing daggers. " + randStartDesc[rn.nextInt( randStartDesc.length)];
      character.addInventory(new Item("Throwing Daggers", 125, uniqueDesc));
      break;
  
      case("Wizard"):
        uniqueDesc = "A staff infused with magic. " + randStartDesc[rn.nextInt( randStartDesc.length)];
      character.addInventory(new Item("Magic Staff", 350, uniqueDesc));
      break;
    } 
    }

  //CreateHero when called prompts the user for input in creating a character, then return a new instance of PlayerHero
  public static PlayerHero createHero(Scanner scan){
    
    //Initialzing values to store user choices
    String name, gender, race, classname, alignment;

    //Initializing race, class, and alignment arrays
    String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling"};
    String[] classes = {"Bard", "Fighter", "Ranger", "Rogue", "Wizard"};
    String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};

    //Setting Name:
    System.out.println("Create a character!\n" + "Enter your name: ");
    name = scan.next();
    try{
      InvalidNameException(name);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(1);
    }
    finally{
    }
    
      //Race Choice:
      System.out.println("\nPick your race:\n");

      for(int i = 0; i < races.length; i++){
        System.out.println((i+1) + "): " + races[i]);
      }
      System.out.println();
    
      int raceChoice = scan.nextInt();
    
    try{
      GetElement(raceChoice - 1, races);
    }
    catch(Exception ex){
      System.out.println("\nInvalid race.\n");
      ex.printStackTrace();
      System.exit(1);
    }
    finally{
      race = races[raceChoice - 1];
      System.out.println("\nYou picked: " + race);
    }

    //Gender Choice:
    System.out.println("\nPick your gender:\n"
                   + "1): Male\n"
                   + "2): Female\n"
                   + "3): Intersex\n"
                   + "4): Androgynous\n");
      int genderNum = scan.nextInt();
    
      switch(genderNum){
          case(1): gender = "Male";
            break;
          case(2): gender = "Female";
            break;
          case(3): gender = "Interex";
            break;
          case(4): gender = "Androgynous";
            break;
        default:
          throw new IllegalStateException(genderNum + " is not a valid gender selection!\n");
      }
    System.out.println("\nYou picked: " + gender);

    //Class Choice:
    System.out.println("\nPick your class:\n");

      for(int i = 0; i < classes.length; i++){
        System.out.println((i+1) + "): " + classes[i]);
      }
      System.out.println();
    
      int classChoice = scan.nextInt();
    try{
       GetElement(classChoice - 1, classes);
    }
    catch(Exception ex){
      System.out.println("\nInvalid class.\n");
      ex.printStackTrace();
      System.exit(1);
    }
    finally{
      classname = classes[classChoice - 1];
      System.out.println("\nYou picked: " + classname); 
    }

    //Alignment Choice:
    System.out.println("\nPick your alignment:\n");

      for(int i = 0; i < alignments.length; i++){
        System.out.println((i+1) + "): " + alignments[i]);
      }
      System.out.println();
    
      int alignChoice = scan.nextInt();
    try{
      GetElement(alignChoice - 1, alignments);
    }
    catch(Exception ex){
      System.out.println("\nInvalid alignment\n");
      ex.printStackTrace();
      System.exit(1);
    }
    finally{
      alignment = alignments[alignChoice - 1];
      System.out.println("\nYour alignment is: " + alignment + "\n");
    }

    //Create a new inventory object to pass to PlayerHero constructor
    ArrayList <Item> inventory = new ArrayList<>();

    PlayerHero character = new PlayerHero(100, 1, 0, inventory, name, race, gender, classname, alignment);
    
    generateStarterItems(character);
    //Return with constructor for PlayerHero given user input and default health, level, and exp
    return character;
  }
  //Entry point
  public static void main(String[] args) {
    
    //Initialize scanner for taking input
    Scanner scan = new Scanner(System.in);
    
    //Begin with creating a hero by entering into the createHero() method
    PlayerHero character = createHero(scan);
    System.out.println("\nCharacter " + "\"" + character.getHeroName() + "\"" + " created!\n");

    //Initialize userchoice to check while loop condition
    int userChoice = 0;

    //While userchoice isn't 4 (quit case), display the options menu
    while(userChoice != 4){

      //Printing options menu
      System.out.println("\nOptions:\n"
                   + "1): Check Inventory\n"
                   + "2): Check Stats\n"
                   + "3): Print Hero Info\n"
                   + "4): Quit\n");

      //Take user input into userChoice from scanner
      userChoice = scan.nextInt();

      //Switch case to handle option chosen by user
      switch(userChoice){
          case(1):
          character.checkInventory();
          break;

          case(2):
          character.checkStats();
          break;

          case(3):
          character.printHeroInfo();
          break;

          case(4):
          scan.close();
          return;

        default:
          System.out.println("Unknown command.\n");
      }
    }
  }
}

