var x=10, y=20, z=0, i=1;
while(true) {
    document.write('i='+i+'( ');
    //yの0ビット目が1かを確認
    if ((y & 1) > 0) {
        z = z + x;
    }
    document.write('y[0]='+(y & 1)+', z='+z);
    x = x << 1; //xを1ビット左シフト
    y = y >> 1; //yを1ビット右シフト
    i = i + 1;
    document.write(', x='+x+', y='+y+' )<br>');
    if (i > 16) {
        break;
    }
}
document.write('<b>出力Z='+z+'</b>');