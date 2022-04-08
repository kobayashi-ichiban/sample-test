searchWord = function() {
    var searchResult,
        searchText = $(this).val(), // 検索ボックスに入力の値
        targetText,
        hitNum;

    // 検索結果を格納
    searchResult=[];

    //結果エリアの表示を空にする
    $('#search-result__list').empty();
    $('.search-result__hit-num').empty();

    // 検索ボックスに値が存在する場合
    if (searchText != '') {
        $('.target-area li').each(function () {
            targetText = $(this).text();
            if (targetText.indexOf(searchText) != -1) {
                searchResult.push(targetText);
            }
        });

        // 結果を画面に表示
        for (var i = 0; i <searchResult.length; i++) {
            $('<span>').text(searchResult[i]).appendTo('#search-result__list');
        }

        // ヒット件数を画面に表示
        hitNum = '<span>検索結果</span>' + searchResult.length + '件見つかりました。';
        $('.search-result__hit-num').append(hitNum);
    }
};

// searchWordの実行
$('#search-text').on('input', searchWord);