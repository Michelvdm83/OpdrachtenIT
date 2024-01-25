public class ForLoop {

  public static void main(String[] args) {
    for (int i = 1; i < 8; i++) {
      System.out.printf("%3d %3d %3d%n", i, i + 1, i + 2);
    }
    System.out.println();

    for (int i = 8; i > 0; i--) {
      for (int j = 0; j < 8; j++) {
        System.out.printf("(%2c%-2d)", ('A' + j), i);
      }
      System.out.println();
    }
  }
}
