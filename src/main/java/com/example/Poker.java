package com.example;

public class Poker implements Comparable<Poker> {
  private String suit;
  private int value;

  public Poker(int value, String suit) {
    this.suit = suit;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Poker poker = (Poker) o;

    return value == poker.value;
  }

  public String getSuit() {
    return suit;
  }

  public void setSuit(String suit) {
    this.suit = suit;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(Poker o) {
    return Integer.compare(this.value, o.value);
  }

  @Override
  public String toString() {
    return "Poker{" +
            "suit='" + suit + '\'' +
            ", value=" + value +
            '}';
  }
}
