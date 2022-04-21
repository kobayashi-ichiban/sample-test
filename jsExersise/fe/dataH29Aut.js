//基本情報技術者試験平成29年秋期午後問8 アルゴリズム
var chars = [
    '␣', '.', ',', '?',
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
];

var str = 'ipa␣␣';
var len = str.length;
//検査文字生成
var checkChar = calcCheckCharacter(str, len);
document.write(str + 'の検査文字は' + checkChar + '<br>');

//検査文字付き文字列を検証
str = str + checkChar;
len = str.length;
var result = validateCheckCharacter(str, len);
if (result) {
    document.write(str + 'に誤りはありません。<br>');
} else {
    document.write(str + 'には誤りがあります。<br>');
}
//奇数番目の文字同士、偶数番目の文字同士を入れ替えた文字列で検証
str = 'a␣ip␣f';
len = str.length;
var result = validateCheckCharacter(str, len);
if (result) {
    document.write(str + 'に誤りはありません。');
} else {
    document.write(str + 'には誤りがあります。');
}

function getChar(value) {
    return chars[value];
}

function getValue(char) {
    return chars.indexOf(char);
}

function calcCheckCharacter(input, len) {
    //inputが1始まりの配列になるように調整
    input = ' ' + input;

    var N, sum, i, value, check_value, is_even;
    N = 30; //文字⇔数字の対応表の要素数
    sum = 0;
    is_even = false;
    for (i = len; i > 0; i--) {
        value = getValue(input[i]);
        if (is_even == true) {
            sum = sum + value;
        } else {
            sum = sum + Math.floor((value * 2) / N) + (value * 2) % N;
        }
        is_even = !is_even;
    }
    check_value = (N - sum % N) % N;
    return getChar(check_value);
}

function validateCheckCharacter(input, len) {
    //inputが1始まりの配列になるように調整
    input = ' ' + input;

    var N, sum, i, value, ret_value, is_odd;
    N = 30; //文字⇔数字の対応表の要素数
    sum = 0;
    is_odd = true;
    ret_value = true;
    for (i = len; i > 0; i--) {
        value = getValue(input[i]);
        if (is_odd == true) {
            sum = sum + value;
        } else {
            sum = sum + Math.floor((value * 2) / N) + (value * 2) % N;
        }
        is_odd = !is_odd;
    }
    if (sum % N !== 0) {
        ret_value = false;
    }
    return ret_value;
}