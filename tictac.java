import java.util.Scanner;

public class tictac {
    static boolean winner = false;
    static int d = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 3;
        int cols = 3;
        char[][] arr = new char[row][cols];
        char x = 'x';
        char o = 'o';
        int a = 0;
        int m = 0;
        System.out.println("WELCOME TO THE TIC TAC TOE !!!!!");
        System.out.println("Name of the player who take 'X' ?");
        String name1 = sc.nextLine();
        System.out.println("Name of the player who take 'O' ?");
        String name2 = sc.nextLine();

        while (winner == false) {
            if (m == 0) {
                print(arr, row, cols);
                m = 1;

            } else {

                if (a == 0) {
                    System.out.println("player " + name1 + " moves!");
                    System.out.println("At which position of matrix(1-9)! ");
                    int n = sc.nextInt();
                    int[] arr3 = new int[2];
                    arr3 = indexofn(n);

                    if (n >= 1 && n < 10) {
                        int r = arr3[0];
                        int c = arr3[1];

                        add(arr, r, c, x);
                        print(arr, row, cols);
                        int check = check(arr, row, cols);
                        if (check == 1 || check == 3 || check == 5) {
                            System.out.println("Woohooo congratulation " + name1 + " you are the  winner!");
                            System.out.println("Thankyou for playing Game.....");
                            winner = true;
                        }
                        if (check == 9) {
                            System.out.println("Game is Over!! ");
                            winner = true;
                        }

                        a = 1;
                    } else {
                        System.out.println("Please be in TICTAC matrix limit(1-9)!!");
                        a = 0;
                    }
                } else {
                    System.out.println("player " + name2 + " moves!");
                    System.out.println("At which position of matrix(1-9)! ");
                    int n = sc.nextInt();
                    int[] arr2 = new int[2];
                    arr2 = indexofn(n);

                    if (n >= 1 && n < 10) {
                        int r = arr2[0];
                        int c = arr2[1];

                        add(arr, r, c, o);
                        print(arr, row, cols);
                        int check = check(arr, row, cols);
                        if (check == 2 || check == 4 || check == 6) {
                            System.out.println("Woohooo congratulation " + name2 + " you are the  winner!");
                            System.out.println("Thankyou for playing Game.....");
                            winner = true;
                        }
                        if (check == 9) {
                            System.out.println("Game is Over!! ");
                            winner = true;
                        }

                        a = 0;
                    } else {
                        System.out.println("Please be in TICTAC matrix limit(1-9)!!");
                        a = 1;
                    }

                }

            }
        }

    }

    public static void print(char arr[][], int row, int cols) {
        int c = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (d == 0) {
                    System.out.print(c + "_  ");
                    c++;

                } else {

                    if (arr[i][j] == 0) {
                        System.out.print("_  ");
                    } else {
                        System.out.print(arr[i][j] + "  ");
                    }
                }

            }
            System.out.println();
        }
        d++;
    }

    public static void add(char arr[][], int row, int cols, char ch) {

        arr[row][cols] = ch;
    }

    public static int check(char arr[][], int row, int cols) {

        int result = 0;
        int po = 0;
        int px = 0;
        int so = 0;
        int sx = 0;
        int count = 0;

        for (int i = 0; i < row; i++) {
            int o = 0;
            int x = 0;
            int ho = 0;
            int hx = 0;

            for (int j = 0; j < cols; j++) {

                if (arr[i][j] == 'x') {
                    x++;
                } else if (arr[i][j] == 'o') {
                    o++;
                }

                if (arr[j][i] == 'x') {
                    hx++;

                } else if (arr[j][i] == 'o') {
                    ho++;
                }

                if (i == j) {
                    if (arr[i][j] == 'x') {
                        px++;
                    } else if (arr[i][j] == 'o') {
                        po++;
                    }
                }

                if ((i == 0 && j == 2) || (i == 2 && j == 0) || (i == 1 && j == 1)) {

                    if (arr[i][j] == 'x') {
                        sx++;
                    } else if (arr[i][j] == 'o') {
                        so++;
                    }

                }

                if (arr[i][j] != 0) {
                    count++;

                }

            }
            if (x == 3 || hx == 3 || px == 3 || sx == 3) {
                result = 1;
                break;

            }
            if (o == 3 || ho == 3 || po == 3 || so == 3) {
                result = 2;
                break;
            }
            if (count == 9) {
                result = 9;
                break;
            }
        }

        return result;

    }

    public static int[] indexofn(int n) {
        int arr[] = new int[2];
        if (n == 1) {
            arr[0] = 0;
            arr[1] = 0;
        }
        if (n == 2) {
            arr[0] = 0;
            arr[1] = 1;
        }
        if (n == 3) {
            arr[0] = 0;
            arr[1] = 2;
        }
        if (n == 4) {
            arr[0] = 1;
            arr[1] = 0;
        }
        if (n == 5) {
            arr[0] = 1;
            arr[1] = 1;
        }
        if (n == 6) {
            arr[0] = 1;
            arr[1] = 2;
        }
        if (n == 7) {
            arr[0] = 2;
            arr[1] = 0;
        }
        if (n == 8) {
            arr[0] = 2;
            arr[1] = 1;
        }
        if (n == 9) {
            arr[0] = 2;
            arr[1] = 2;
        }

        return arr;

    }

}