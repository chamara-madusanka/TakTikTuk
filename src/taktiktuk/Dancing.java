/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taktiktuk;

/**
 *
 * @author Rumesh
 */
import java.io.*;

class Dancing {

    static BufferedReader br;
    static PrintWriter pw;
    static int numOfSuprice;
    static int suspicious;
    static int bestResult;

    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Rumesh\\Desktop\\CodeJam\\testDance.in"));
            pw = new PrintWriter(new File("C:\\Users\\Rumesh\\Desktop\\CodeJam\\DancingAns.out"));

            String line = br.readLine();
            int testCase = Integer.parseInt(line);

            for (int i = 0; i < testCase; i++) {
                line = br.readLine();
                String[] data = line.split(" ");

                int numOfGoogle = Integer.parseInt(data[0]);
                numOfSuprice = Integer.parseInt(data[1]);
                bestResult = Integer.parseInt(data[2]); //what is the maximum number of Googlers that could have had a best result of at least p
                suspicious = 0;
                int out = 0;

                int[] marks = new int[numOfGoogle];
                for (int j = 3; j < data.length; j++) {
                    marks[j - 3] = Integer.parseInt(data[j]);
                }

                int[][] descriptiveMarks = new int[marks.length][3];

                for (int j = 0; j < marks.length; j++) {
                    int curMark = marks[j];
                    System.out.println("Sus " + suspicious + "  No of sus " + numOfSuprice);
                    descriptiveMarks[j] = analyze(curMark);
                }

                for (int j = 0; j < descriptiveMarks.length; j++) {
                    for (int k = 0; k < 3; k++) {
                        System.out.print(descriptiveMarks[j][k]);
                    }
                    System.out.println("");
                }
                System.out.println("Best " + bestResult);
                for (int j = 0; j < descriptiveMarks.length; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (descriptiveMarks[j][k] >= bestResult) {
                            out++;
                            break;
                        }
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + out);
                pw.println("Case #" + (i + 1) + ": " + out);
                pw.flush();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    static int[] analyze(int currentMark) {
        int[] out = new int[3];
        int attempt = 1;

        if (currentMark % 3 == 0) {
            out[0] = out[1] = out[2] = currentMark / 3;
            if (out[0] + 1 > bestResult) {
                out[0] = currentMark / 3 + 1;
                out[1] = currentMark / 3 - 1;
                out[2] = currentMark / 3;
            }

            return out;
        }

        abc:
        for (int i = 10; i >= 0; i--) {
            for (int j = 10; j >= 0; j--) {
                if ((i + 2 < j) || (i - 2 > j)) {
                    continue;
                }

                for (int k = 10; k >= 0; k--) {

                    if ((i + 2 < k) || (i - 2 > k)) {
                        continue;
                    }

                    if (i + k + j == currentMark) {
                        if (Math.abs(i - k) == 2 || Math.abs(i - j) == 2 || Math.abs(j - k) == 2) {
                            if ((Math.abs(i - k) > 2 || Math.abs(i - j) > 2 || Math.abs(j - k) > 2)) {
                                continue;
                            } else {
                                if (suspicious == numOfSuprice) {
                                    System.out.println("1");
                                    continue;
                                } else {
                                    // System.out.println("2");
                                    if (attempt == 1) {
                                        attempt++;
                                        continue;
                                    } else {
                                        suspicious++;
                                        out[0] = i;
                                        out[1] = j;
                                        out[2] = k;
                                        System.out.println(currentMark + " " + out[0] + " " + out[1] + " " + out[2]);

                                        break abc;
                                    }
                                }
                            }
                        } else {
                            System.out.println("3");
                            out[0] = i;
                            out[1] = j;
                            out[2] = k;
                            System.out.println(currentMark + " " + out[0] + " " + out[1] + " " + out[2]);
                            break abc;
                        }
                    }
                }
            }
        }
        return out;
    }

    static int[] ana(int currentMark) {
        int[] mark = new int[3];

        if (currentMark % 3 == 0) {
            mark[0] = mark[1] = mark[2] = currentMark / 3;
            if (mark[0] + 1 > bestResult) {
                mark[0] = currentMark / 3 + 1;
                mark[1] = currentMark / 3 - 1;
                mark[2] = currentMark / 3;
            }

            return mark;
        } else {
        }
        return null;
    }
}