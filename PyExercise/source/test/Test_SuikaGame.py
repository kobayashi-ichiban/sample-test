import unittest

import math
import SuikaGame


class TestSuikaGame(unittest.TestCase):
    """test class of SuikaGame.py
    """

    def test_calc_distance(self):
        # calc_distanceのテスト
        value_x1 = 2
        value_y1 = 5
        value_x2 = 1
        value_y2 = 3
        # 期待する値(1+2^2)
        excepted_s = math.sqrt(5)
        excepted_f = math.sqrt(4)
        # モジュール.クラス.メソッド名
        actual = SuikaGame.SuikaGame.calc_distance(value_x1, value_y1, value_x2, value_y2)
        self.assertEqual(excepted_s, actual)
        self.assertEqual(excepted_f, actual)


if __name__ == "__main__":
    unittest.main()
