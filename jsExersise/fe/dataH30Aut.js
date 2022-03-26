//基本情報技術者試験　平成30年秋期午後問8のアルゴリズム

var exp = '2×(34-(5+67)÷8)'; //+,-,(,)は半角文字限定です
var explen = exp.length;
var val = compute(exp, explen);

document.getElementById("result").innerHTML = exp + '=' + val;

function compute(Expression, ExpLen)
{
    var Operator = Array(100);
    var Priority = Array(100);
    var Value = Array(100);
    var chr, i, ip, nest, OpCnt;

    //解析部分の処理
    OpCnt = 0;
    Value[0] = 0;
    nest = 0;
    for (i=0; i<ExpLen; i++) {
        chr = Expression[i];
        if (0 <= chr || chr <= 9) {
            Value[OpCnt] = 10 * Value[OpCnt] + Number(chr);
        }
        if (chr == '+' || chr == '-' || chr == '×' || chr == '÷') {
            Operator[OpCnt] = chr;
            if (chr == '+' || chr == '-') {
                Priority[OpCnt] = nest + 1;
            } else {
                Priority[OpCnt] = nest + 2;
            }
            OpCnt = OpCnt + 1;
            Value[OpCnt] = 0;
        }
        if (chr == '(') {
            nest = nest + 10;
        }
        if (chr == ')') {
            nest = nest - 10;
        }
    }

    //解析部分の実行結果
    document.getElementById("Value").innerHTML = 'Value[] = ' + Value.join(',');
    document.getElementById("Operator").innerHTML = 'Operator[] = ' + Operator.join(',');
		document.getElementById("Priority").innerHTML = 'Priority[] = ' + Priority.join(',');
		
    //計算部分の処理
    while (OpCnt > 0) {
        ip = 0;
        for (i=1; i<OpCnt; i++) {
            if (Priority[ip] < Priority[i]) {
                ip = i;
            }
        }
        chr = Operator[ip];
        if (chr == '+') {
            Value[ip] = Value[ip] + Value[ip+1];
        }
        if (chr == '-') {
            Value[ip] = Value[ip] - Value[ip+1];
        }		    
        if (chr == '×') {
            Value[ip] = Value[ip] * Value[ip+1];
        }		
        if (chr == '÷') {
				console.log(Value[ip],Value[ip+1]);
            Value[ip] = Value[ip] / Value[ip+1];
						
        }
        //演算した要素の部分を左詰めする処理
        for (i=ip+1; i<OpCnt; i++) {
            Value[i] = Value[i+1];
            Operator[i-1] = Operator[i];
            Priority[i-1] = Priority[i];
        }
        OpCnt = OpCnt - 1;
    }
    return Value[0];
}