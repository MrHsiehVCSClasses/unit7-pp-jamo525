package u7pp;

import java.util.Scanner;
import java.util.*;

/*
Simulates a basic 2 player game of War using the Deck and Card classes
*/
public class War {
  
  private Deck warDeck = new Deck();
  private ArrayList<Card> player1Hand = new ArrayList<Card>();
  private ArrayList<Card> player2Hand = new ArrayList<Card>();
  private ArrayList<Card> thePile = new ArrayList<Card>();
  private Card flip1;
  private Card flip2;
  private String player1;
  private String player2;
  private Scanner scan = new Scanner(System.in);

  /*
  contructs war object
  evenly distributes warDeck between two array lists: player1Hand and player2Hand
  */
  public War ()
  {
    for (int i = 0; i <= 26; i++)
    {
      player1Hand.add(warDeck.deal());
      player2Hand.add(warDeck.deal());
    }
  }

  /*
  Runs game of war and ends when either one player forfeits, or one player has zero cards left.
  */
  public void play()
  {
    boolean hopeIsNotLost = true;
    boolean warOn = true;
    System.out.println("THIS IS WAR!");
    System.out.println("Insert player1 name: ");
    player1 = scan.nextLine();
    System.out.println("Insert player2 name: ");
    player2 = scan.nextLine();
    while (player1Hand.size() != 0 && player2Hand.size() != 0 && hopeIsNotLost)
    {
      flip1 = player1Hand.remove(0);
      flip2 = player2Hand.remove(0);
      thePile.add(flip1);
      thePile.add(flip2);
      System.out.println(player1 + " flip: " + flip1.toString());
      System.out.println(player2 + " flip: " + flip2.toString());
      runWar();
      if (calcPoints(flip1.getValue()) > calcPoints(flip2.getValue()))
      {
        System.out.println("Battle winner : " + player1);
        for (Card value : thePile)
        {        
          player1Hand.add(value);
        }
        System.out.println(player2 + " would you like to forfeit? (Y)es or (N)o");
        if (scan.nextLine().toUpperCase().equals("Y"))
        {
          hopeIsNotLost = false;
          player2Hand = new ArrayList<Card>();
        }
      }
      else
      {
        System.out.println("Battle winner : " + player2);
        for (Card value : thePile)
        {
          player2Hand.add(value);
        }
        
        System.out.println(player1 + " would you like to forfeit? (Y)es or (N)o");
        if (scan.nextLine().toUpperCase().equals("Y"))
        {
          hopeIsNotLost = false;
          player1Hand = new ArrayList<Card>();
        }
      }
    }
    if (player1Hand.size() == 0)
      System.out.println ("War victor: " + player2);
    else
      System.out.println ("War victor: " + player1);
  }

  /*
  Tests if two card values are the same. If the same, loop is run until they are not the same. Adding all used cards to thePile array list.
  */
  private void runWar ()
  {
    while (calcPoints(flip1.getValue()) == calcPoints(flip2.getValue()))
        {
          System.out.println("THIS MEANS WAR!");
          for (int i = 0; i < 3; i++)
          {
          thePile.add(player1Hand.remove(0));
          thePile.add(player2Hand.remove(0));
          }
          flip1 = player1Hand.remove(0);
          flip2 = player2Hand.remove(0);
          System.out.println(player1 + " flip: " + flip1.toString());
          System.out.println(player2 + " flip: " + flip2.toString());
        }
  }

  /*
  @param String name of a Card value
  @return the numerical representation for that number
  */
  private int calcPoints (String original)
  {
    if (original.equals("Jack"))
      return 11;
    else if (original.equals("Queen"))
      return 12;
    else if (original.equals("King"))
      return 13;
    else if (original.equals("Ace"))
      return 14;
    else
      return Integer.parseInt(original);
  }
}
