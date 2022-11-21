package pers.xumeng.androidstudy.single.variable.multiple.state;

public class FavouriteBallGamesHelper {

  private static final byte STATE_VALUE_DEFAULT = 0b0000_0000;
  // 每个状态用一位表示，1 选中， 0 未选中
  private static final byte CHECKED_FOOTBALL = 0b0000_0001;
  private static final byte CHECKED_BASKETBALL = 0b0000_0010;
  private static final byte CHECKED_TABLE_TENNIS = 0b0000_0100;
  private static final byte CHECKED_TENNIS = 0b0000_1000;
  private static final byte CHECKED_VOLLEYBALL = 0b0001_0000;
  private static final byte CHECKED_BADMINTON = 0b0010_0000;

  private byte state = STATE_VALUE_DEFAULT;


  private void setState(int state) {
    this.state = (byte) state;
  }

  private int getState() {
    return state;
  }

  public void setFootballCheckedState(boolean isChecked) {
    if (isChecked) {
      state = (byte) (state | CHECKED_FOOTBALL);
    } else {
      state = (byte) (state & ~CHECKED_FOOTBALL);
    }
  }

  public boolean footballIsChecked() {
    return (state & CHECKED_FOOTBALL) == CHECKED_FOOTBALL;
  }

  public void setBasketballCheckedState(boolean isChecked) {
    if (isChecked) {
      state = (byte) (state | CHECKED_BASKETBALL);
    } else {
      state = (byte) (state & ~CHECKED_BASKETBALL);
    }
  }

  public boolean basketballIsChecked() {
    return (state & CHECKED_BASKETBALL) == CHECKED_BASKETBALL;
  }

  public void setTableTennisCheckedState(boolean isChecked) {
    if (isChecked) {
      state = (byte) (state | CHECKED_TABLE_TENNIS);
    } else {
      state = (byte) (state & ~CHECKED_TABLE_TENNIS);
    }
  }

  public boolean tableTennisIsChecked() {
    return (state & CHECKED_TABLE_TENNIS) == CHECKED_TABLE_TENNIS;
  }

  public void setTennisCheckedState(boolean isChecked) {
    if (isChecked) {
      state = (byte) (state | CHECKED_TENNIS);
    } else {
      state = (byte) (state & ~CHECKED_TENNIS);
    }
  }

  public boolean tennisIsChecked() {
    return (state & CHECKED_TENNIS) == CHECKED_TENNIS;
  }

  public void setVolleyballCheckedState(boolean isChecked) {
    if (isChecked) {
      state = (byte) (state | CHECKED_VOLLEYBALL);
    } else {
      state = (byte) (state & ~CHECKED_VOLLEYBALL);
    }
  }

  public boolean volleyballIsChecked() {
    return (state & CHECKED_VOLLEYBALL) == CHECKED_VOLLEYBALL;
  }

  public void setBadmintonCheckedState(boolean isChecked) {
    if (isChecked) {
      state = (byte) (state | CHECKED_BADMINTON);
    } else {
      state = (byte) (state & ~CHECKED_BADMINTON);
    }
  }

  public boolean badmintonIsChecked() {
    return (state & CHECKED_BADMINTON) == CHECKED_BADMINTON;
  }

}
