package jp.Readable;

import java.util.List;

public class Section2 {
    public static void main(String[] args) {
        System.out.println("Start");

    }

    // getの使い方に注意。どこから取得するかもわかるようにすればGood。
    // インターネットから取得とかであればdownloadやfetchにしてみる。
    private Object downloadPage(String url) {
        // do something
        return new Object();
    }

    private int squaresCalculationResult(int number, int squares) {
        int retval = 0;
        for (int i = 0; i < squares; i++) {
            retval += number * number;
            // これだと2乗することに気づきにくい→   retval += v[i];
        }

        // 情報のある変数名にする
        int sumSquares = 0;
        for (int i = 0; i < squares; i++) {
            sumSquares += number * number;
            // これだと2乗し忘れに気づきにやすい→   sumSquares += v[i];
        }
        return sumSquares;
    }


}
