import random
import math


class SuikaGame:

    def calc_distance(x1, y1, x2, y2):
        """2点間の距離を求める
        """
        diff_x = x1 - x2
        diff_y = y1 - y2
        # **2は累乗
        return math.sqrt(diff_x**2 + diff_y**2)

    suika_x = random.randrange(0, 5)    # スイカのx座標
    suika_y = random.randrange(0, 5)    # スイカのy座標

    player_x = random.randrange(0, 5)    # プレイヤーのx座標
    player_y = random.randrange(0, 5)    # プレイヤーのy座標

    while (suika_x != player_x) or (suika_y != player_y):
    
        distance = calc_distance(player_x, player_y, suika_x, suika_y)
        print("スイカへの距離", distance)
    
        c = input("n:北へ移動 s:南に移動 e:東に移動 w:西に移動")
        if c == "n":
            player_y = player_y - 1
        elif c == "s":
            player_y = player_y + 1
        elif c == "w":
            player_x = player_x - 1
        elif c == "e":
            player_x = player_x + 1
        else:
          print("指定の文字を入力してください")
    
    print("スイカを割りました")