package projectone;

import java.io.*;

/** Class to represent the name and count of an item being purchased. */

public class SimpleItem implements Serializable {
  private String newItem;
  private int itemCount;
  private int itemQty;


  public SimpleItem(String itemName) {
    this.newItem = itemName;
    itemCount = 1;
  }

  public String getItemName() {
    return(newItem);
  }

  public int getItemCount() {
    return(itemCount);
  }

  public void incrementItemCount() {
    itemCount = itemCount + 1;
  }

  /** The toString method is called when you simply print an Object. */
  
  @Override
  public String toString() {
    return(newItem + " (" + itemCount + ")");
  }
}
